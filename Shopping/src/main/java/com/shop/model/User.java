package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	private int userid;
	private String userName;
	private String mobileNumber;
	private String email;
	private String password;

}
