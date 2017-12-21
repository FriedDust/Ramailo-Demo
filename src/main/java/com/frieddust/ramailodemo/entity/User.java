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

import com.ramailo.annotation.RamailoField;
import com.ramailo.annotation.RamailoResource;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
@RamailoResource(value = "users", stringify = "email")
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 3804457357710412333L;

	@RamailoField(label = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@RamailoField
	@Column
	private String email;

	@RamailoField
	@Column
	private String password;

	@RamailoField
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}