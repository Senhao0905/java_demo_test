package com.example.java_demo_test.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Type;
import javax.persistence.Id;
import javax.persistence.Table;

;

@Entity
@Table(name = "new_menu")
public class NewMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private int seq ;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "price")
	private int price;
	
	@Type(type = "uuid-char")
	@Column(name = "uuid")
	private UUID uuid = UUID.randomUUID();

	public int getSeq() {
		return seq;
	}

	public NewMenu(String category, String item, int price, UUID uuid) {
		super();
		this.category = category;
		this.item = item;
		this.price = price;
		this.uuid = uuid;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
