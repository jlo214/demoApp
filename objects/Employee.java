/*
Jorge Lopez 
Demo app
*/
package objects;

public class Employee{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	private Record record;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String phoneNumber, Address address, Record record) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.record = record;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setRecord(Record record) {
		this.record = record;
	}
	
	public Record getRecord() {
		return record;
	}
	
	@Override
	public String toString() {
		//return "Employee Details:\n First name: "+firstName+ " Last name: "+lastName+ " Phone number: "+phoneNumber+ " \nAddress: "+address+ "\nRecord: "+record;
		return firstName+" "+lastName+" "+phoneNumber+" "+address+" "+record;
	}
	
}