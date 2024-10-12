package backend.model;

public class Producto {

	private String code;
	private String type;
	private String name;
	private float price;
	private int units;

	public Producto(String code, String type, String name, float price, int units) {
		this.code = code;
		this.type = type;
		this.name = name;
		this.price = price;
		this.units = units;
	}

	public Producto(Producto anotherItem) {
		this(anotherItem.code, anotherItem.type, anotherItem.name, anotherItem.price, anotherItem.units);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(" - ");
		sb.append(this.type);
		sb.append(" - ");
		sb.append(this.price);
		sb.append(" �\n");
		return sb.toString();
	}
}
