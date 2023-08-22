package com.springbootjwt.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//this class is used to generate products order detail ordered by an user
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column
	private double total;

	@Column
	@NotNull
	private int quantity;

	@Column
	private LocalDate orderDate=LocalDate.now();
	
	@Column(length=20, nullable=false)
	private String paymentMode;
	
	@NotNull
	@Column(length = 20)
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//an single order details can hold many product detail
	private Product product;

	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	//a single order detail can holds single user detail
	private User user;
	
//	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//	private Cart cart;
	
}
