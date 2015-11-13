package th.co.aware.apartment.bean;

public class Room {

	private int r_id;
	private String r_status;
	private int u_id;
	private String u_fname;
	private String u_lname;
	private int r_water;
	private int r_light;
	private int r_price;
	private int r_orid;

	public int getR_orid() {
		return r_orid;
	}

	public void setR_orid(int r_orid) {
		this.r_orid = r_orid;
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

	public int getR_price() {
		return r_price;
	}

	public void setR_price(int r_price) {
		this.r_price = r_price;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_status() {
		return r_status;
	}

	public void setR_status(String r_status) {
		this.r_status = r_status;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getR_water() {
		return r_water;
	}

	public void setR_water(int r_water) {
		this.r_water = r_water;
	}

	public int getR_light() {
		return r_light;
	}

	public void setR_light(int r_light) {
		this.r_light = r_light;
	}

}
