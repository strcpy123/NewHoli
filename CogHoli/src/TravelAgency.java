import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelAgency {

	public List<Package> generatePackageCost(String filePath) {
		List<Package> objList = new ArrayList<>();
		BufferedReader br;
		File file = new File(filePath);
		try {
			br = new BufferedReader(new FileReader(file));
			String temp = br.readLine();
			while (temp != null) {
				String data[] = temp.split(",");
				try {
					if (validate(data[0])) {
						Package pkg = new Package();
						pkg.setPackageId(data[0]);
						pkg.setSourcePlace(data[1]);
						pkg.setDestinationPlace(data[2]);
						pkg.setBasicFare(Double.parseDouble(data[3]));
						pkg.setNoOfDays(Integer.parseInt(data[4]));
						pkg.calculatePackageCost();

						objList.add(pkg);
					}
				} catch (InvalidPackageIdException e) {

					System.out.println(e.getMessage());
				}
				temp = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return objList;
	}

	public List<Package> findPackagesWithMinimumNumberOfDays() {
		List<Package> minList = new ArrayList<Package>();
		Package min = new Package();
		try {
			String query = "select * from Package_Details where no_of_days in (select min(no_of_days) from Package_Details)";
			PreparedStatement preparedStatement = new DBHandler().establishConnection().prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				min.setPackageId(rs.getString(1));
				min.setSourcePlace(rs.getString(2));
				min.setDestinationPlace(rs.getString(3));
				min.setNoOfDays(rs.getInt(4));
				min.setPackageCost(rs.getInt(5));
				minList.add(min);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return minList;
	}

	public boolean validate(String packageId) throws InvalidPackageIdException {
			String regex = "[a-zA-Z0-9]{3}+/[a-zA-Z0-9]{3}";
		if (packageId.matches(regex))
			return true;
		else
			throw new InvalidPackageIdException("Invalid Package ID Exception");
	}
}
