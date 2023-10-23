package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ToDo {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	    private String title;
	    private String description;
	    private String imagePath;
	    private String imageFileName;

}
