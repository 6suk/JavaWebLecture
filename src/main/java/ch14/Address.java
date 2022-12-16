package ch14;

public class Address {
	private int zipCode;
	private String city;
	private String county;

	public Address(int zipCode, String city, String county) {
		this.zipCode = zipCode;
		this.city = city;
		this.county = county;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Override
	public String toString() {
		return "Address [zipCode=" + zipCode + ", city=" + city + ", county=" + county + "]";
	}

}
