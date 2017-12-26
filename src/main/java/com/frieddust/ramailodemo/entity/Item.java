package com.frieddust.ramailodemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ramailo.meta.annotation.RamailoField;
import com.ramailo.meta.annotation.RamailoResource;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
@RamailoResource(value = "items", stringify = "name")
@Entity
@Table(name = "items")
public class Item implements Serializable {

	private static final long serialVersionUID = -574715585363480539L;

	@RamailoField(label = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@RamailoField
	@Column
	@NotNull
	@Size(min = 2, max = 50)
	private String name;

	@RamailoField
	@Column
	@NotNull
	private BigDecimal rate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@PrePersist
	public void testPrePersist() {
		System.out.println("ON PRE PERSIST");
	}
}
