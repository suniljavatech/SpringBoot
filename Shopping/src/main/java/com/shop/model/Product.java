package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
@Entity
@Data
public class Product {
	@Id
	private Integer productId;
	private String productName;
	private String productCost;

}
