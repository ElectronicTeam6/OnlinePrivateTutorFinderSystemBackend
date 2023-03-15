package com.optfs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class DemoRequests {

	@Id
	@GeneratedValue
	private Integer demoId;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Parent parent;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Tutor tutor;
	
	private boolean accepted = false;

}