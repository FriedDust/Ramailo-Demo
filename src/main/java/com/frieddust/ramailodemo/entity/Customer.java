package com.frieddust.ramailodemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.frieddust.ramailodemo.entity.action.CustomerActions;
import com.ramailo.meta.annotation.RamailoField;
import com.ramailo.meta.annotation.RamailoResource;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
@RamailoResource(value = "customers", stringify = "name", gridHeaders = { "name", "category", "country" }, actions = {
		CustomerActions.class })
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = -3957833521642758148L;

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
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	@NotNull
	private Category category;

	@RamailoField
	@ManyToOne(optional = true)
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
