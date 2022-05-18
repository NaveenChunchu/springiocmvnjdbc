package ai.jobiak.mvc;

public class User {
	
	private String fname;
	private long mobile;
	private String email;
	public User() {
		
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String fname, String email, long mobile) {
		super();
		this.fname = fname;
		this.mobile = mobile;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [fname=" + fname + ", mobile=" + mobile + ", email=" + email + "]";
	}
	

}