package th.co.aware.apartment.bean;

public class Invoice {

	private int i_id;
	private int u_id;
	private int r_id;
	private int i_water;
	private int i_light;
	private int i_total;
	private int r_price;
	private String i_status;
	private String u_fname;
	private String u_lname;

	public int getR_price() {
		return r_price;
	}

	public void setR_price(int r_price) {
		this.r_price = r_price;
	}

	public String getI_status() {
		return i_status;
	}

	public void setI_status(String i_status) {
		this.i_status = i_status;
	}

	public String getU_fname() {
		return u_fname;
	}

	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}

	public String getU_lname() {
		return u_lname;
	}

	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getI_water() {
		return i_water;
	}

	public void setI_water(int i_water) {
		this.i_water = i_water;
	}

	public int getI_light() {
		return i_light;
	}

	public void setI_light(int i_light) {
		this.i_light = i_light;
	}

	public int getI_total() {
		return i_total;
	}

	public void setI_total(int i_total) {
		this.i_total = i_total;
	}

}
