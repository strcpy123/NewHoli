
public class Package {
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int noOfDays;
	private double packageCost;

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public double getBasicFare() {
		return basicFare;
	}

	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public void calculatePackageCost() {
			double dis=0;
			double gst=0;
			if(this.noOfDays<=5) {
				dis=0;
			}
			
			if(this.noOfDays>5 && this.noOfDays<=8) {
				dis=(double)((this.basicFare*this.noOfDays)*(0.03));
			}
			if(this.noOfDays>8 && this.noOfDays<=10) {
				dis=(double)((this.basicFare*this.noOfDays)*(0.05));
			}
			if(this.noOfDays>10) {
				dis=(double)((this.basicFare*this.noOfDays)*(0.07));
			}
			gst = (((this.basicFare*this.noOfDays)-dis)*(0.12));
			this.packageCost=(double)(((this.basicFare*this.noOfDays)-dis)+gst);
	}
}
