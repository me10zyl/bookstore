package net.vicp.zyl_me.model;

public class GoodsBean {
	private long goodsid;
	private String goodsname;
	private String breifintroduction;
	private String detailintroduction;
	private float goodsprice;
	private String photo;
	private String categroy;
	
	public GoodsBean(long goodsid, String goodsname, String breifintroduction, String detailintroduction, float goodsprice, String photo, String categroy) {
		super();
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.breifintroduction = breifintroduction;
		this.detailintroduction = detailintroduction;
		this.goodsprice = goodsprice;
		this.photo = photo;
		this.categroy = categroy;
	}
	public String getBreifintroduction() {
		return breifintroduction;
	}
	public String getCategroy() {
		return categroy;
	}
	public String getDetailintroduction() {
		return detailintroduction;
	}
	public long getGoodsid() {
		return goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public float getGoodsprice() {
		return goodsprice;
	}
	public String getPhoto() {
		return photo;
	}
	public void setBreifintroduction(String breifintroduction) {
		this.breifintroduction = breifintroduction;
	}
	public void setCategroy(String categroy) {
		this.categroy = categroy;
	}
	public void setDetailintroduction(String detailintroduction) {
		this.detailintroduction = detailintroduction;
	}
	public void setGoodsid(long goodsid) {
		this.goodsid = goodsid;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public void setGoodsprice(float goodsprice) {
		this.goodsprice = goodsprice;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
