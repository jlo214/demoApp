/*
Jorge Lopez 
Demo app
*/
package objects;

public class Record{
	
	private String licenseStatus;
	private int accidents;
	private int violations; 
	
	public Record(){

	}

	public Record(String licenseStatus, int accidents, int violations){
		this.licenseStatus = licenseStatus;
		this.accidents = accidents;
		this.violations = violations;
	}

	public void setLicenseStatus(String licenseStatus){
		this.licenseStatus = licenseStatus;
	}

	public String getLicenseStatus(){
		return licenseStatus;
	}

	public void setAccidents(int accidents){
		this.accidents = accidents;
	}

	public int getAccidents(){
		return accidents;
	}

	public void setViolations(int violations){
		this.violations = violations;
	}

	public int getViolations(){
		return violations;
	}

	@Override
	public String toString(){
		//return "\n License Status: "+licenseStatus+ " Accidents: "+accidents+ " Violations: "+violations;
		return licenseStatus+" "+accidents+" "+violations;
	}

}
