package entity;

public class User {
	private int id;
	private String name;
	private String email;
	private String passwordHash;
	private String imgPic;
	private int isSeller;
	private double paidBack;
	private String phone;
	private String address;
	private int receiveEmail;
	
	public User(int id, String name, String email, String passwordHash, String imgPic, int isSeller, double paidBack, String phone, String address, int receiveEmail) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.imgPic = imgPic;
		this.isSeller = isSeller;
		this.paidBack = paidBack;
		this.phone = phone;
		this.address = address;
		this.receiveEmail = receiveEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getImgPic() {
		return imgPic;
	}

	public void setImgPic(String imgPic) {
		this.imgPic = imgPic;
	}

	public int getIsSeller() {
		return isSeller;
	}

	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}

	public double getPaidBack() {
		return paidBack;
	}

	public void setPaidBack(double paidBack) {
		this.paidBack = paidBack;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getReceiveEmail() {
		return receiveEmail;
	}

	public void setReceiveEmail(int receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
}
