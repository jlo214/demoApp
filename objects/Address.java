/*
Jorge Lopez
Demo app
*/
package objects;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public Address(){

	}

	public Address(String street, String city, String state, String zipCode){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public void setStreet(String street){
		this.street = street;
	}
	
	public String getStreet(){
		return street;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	public String getZipCode(){
		return zipCode;
	}

	@Override
	public String toString(){
		//return "\n Street: "+street+ " City: "+city+" State: "+state+ " Zip code: "+zipCode;
		return street+" "+city+" "+state+" "+zipCode;
	}
	
}