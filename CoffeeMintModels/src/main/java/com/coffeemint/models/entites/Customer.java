package com.coffeemint.models.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.coffeemint.models.emnumered.AuthProvider;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "email", nullable = false, length = 48, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false, length = 128)
	private String password;

	@Column(name = "first_name", nullable = true, length = 64)
	private String firstName;

	@Column(name = "last_name", nullable = true, length = 64)
	private String lastName;

	@Column(name = "phone_number", nullable = true, length = 12)
	private String phoneNumber;

	@Column(name = "address", nullable = true, length = 128)
	private String address;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@Column(name = "photo", nullable = true, length = 128)
	private String photo;

	@Column(name = "auth_provider")
	@Enumerated(EnumType.STRING)
	private AuthProvider authProvider;

	@Column(name = "last_login", nullable = true)
	private Date lastLogin;

	@Column(name = "create_date", nullable = true)
	private Date createDate;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public AuthProvider getAuthProvider() {
		return authProvider;
	}

	public void setAuthProvider(AuthProvider authProvider) {
		this.authProvider = authProvider;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Transient
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	@Transient
	public String getPhotoPath() {
		if (id == null && this.photo == null) {
			return null;
		}

		return "/profile-photos/" + this.id + "/" + this.photo;
	}
}