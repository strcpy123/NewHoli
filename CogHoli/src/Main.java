import java.util.List;

public class Main {
	public static void main(String[] args) {
		TravelAgency travelAgency = new TravelAgency();
		String path = "C:/Users/842094/workspace/CogHoli/src/VarshTourPackageDetails.txt";
		List<Package> holi = travelAgency.generatePackageCost(path);
		for (int i = 0; i < holi.size(); i++) {
			
			System.out.print(holi.get(i).getPackageId()+" ");
			System.out.print(holi.get(i).getSourcePlace()+" ");
			System.out.print(holi.get(i).getDestinationPlace()+" ");
			System.out.print(holi.get(i).getBasicFare()+" ");
			System.out.print(holi.get(i).getNoOfDays()+" ");
			System.out.println(holi.get(i).getPackageCost()+" ");
			}
		
		List<Package> holi1 = travelAgency.findPackagesWithMinimumNumberOfDays();
		for (int i = 0; i < holi1.size(); i++) {
			System.out.print(holi.get(i).getPackageId()+" ");
			System.out.print(holi.get(i).getSourcePlace()+" ");
			System.out.print(holi.get(i).getDestinationPlace()+" ");
			System.out.print(holi.get(i).getNoOfDays()+" ");
			System.out.println(holi.get(i).getPackageCost()+" ");
		}
	}
}
