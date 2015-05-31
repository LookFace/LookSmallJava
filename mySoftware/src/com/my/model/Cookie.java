package com.my.model;

/**
 * Cookie entity. @author MyEclipse Persistence Tools
 */

public class Cookie implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ingredient;
	private String name;
	private Integer price;

	// Constructors

	/** default constructor */
	public Cookie() {
	}

	/** full constructor */
	public Cookie(String ingredient, String name, Integer price) {
		this.ingredient = ingredient;
		this.name = name;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}