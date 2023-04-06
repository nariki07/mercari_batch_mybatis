package com.example.demo.domain;

/**
 * tsvファイルの情報を表すドメインクラス.
 * 
 * @author moriharanariki
 *
 */
public class Original {

	/* ID */
	private Integer id;
	/* 商品名 */
	private String name;
	/* 状態 */
	private Integer conditionId;
	/* カテゴリ名 */
	private String categoryName;
	/* ブランド名 */
	private String brand;
	/* 価格 */
	private double price;
	/* 運送方法 */
	private Integer shipping;
	/* 説明 */
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getShipping() {
		return shipping;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "original [id=" + id + ", name=" + name + ", conditionId=" + conditionId + ", categoryName="
				+ categoryName + ", brand=" + brand + ", price=" + price + ", shipping=" + shipping + ", description="
				+ description + "]";
	}

}
