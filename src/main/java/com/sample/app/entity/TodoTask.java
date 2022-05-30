package com.sample.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoTask {

	@Id
	@GeneratedValue
	private int id;
	private String desc;
	private Date date;
	private boolean status;
}
