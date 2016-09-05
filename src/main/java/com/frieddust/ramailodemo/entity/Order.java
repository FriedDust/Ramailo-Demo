package com.frieddust.ramailodemo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ramailo.RamailoResource;
import com.ramailo.jpautil.LocalDateAttributeConverter;
import com.ramailo.jpautil.LocalDateDeserializer;
import com.ramailo.jpautil.LocalDateSerializer;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
@RamailoResource(value = "orders", stringify = "name")
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -258440034790261589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "order_date")
	@Convert(converter = LocalDateAttributeConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate orderDate;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference
	private List<OrderItem> orderItems = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
