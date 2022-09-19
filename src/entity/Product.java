package entity;

public class Product {
	private int id;
	private int groupID;
	private String name;
	private String imgPath;
	private String description;
	private double cost;
	private int salePercentage;
	private int idSeller;
	private int storage;
	private int timesBought;
	private String size;

	public Product(int id, int groupID, String name, String imgPath, String description, double cost,
			int salePercentage, int idSeller, int storage, int timesBought, String size) {
		super();
		this.id = id;
		this.groupID = groupID;
		this.name = name;
		this.imgPath = imgPath;
		this.description = description;
		this.cost = cost;
		this.salePercentage = salePercentage;
		this.idSeller = idSeller;
		this.storage = storage;
		this.timesBought = timesBought;
		this.size = size;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getSalePercentage() {
		return salePercentage;
	}
	
	public void setSalePercentage(int salePercentage) {
		this.salePercentage = salePercentage;
	}
	
	public int getIdSeller() {
		return idSeller;
	}
	
	public void setIdSeller(int idSeller) {
		this.idSeller = idSeller;
	}
	
	public int getStorage() {
		return storage;
	}
	
	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	public int getTimesBought() {
		return timesBought;
	}
	
	public void setTimesBought(int timesBought) {
		this.timesBought = timesBought;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
