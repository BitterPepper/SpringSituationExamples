package com.macbook.jpa_spring_data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail {
	private Long id;
	private int version;
	private String telType;
	private String telNumber;
	private Contact contact;

	public ContactTelDetail() {
	}

	public ContactTelDetail(String telType, String telNumber) {
		this.telType = telType;
		this.telNumber = telNumber;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "TEL_TYPE")
	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	@Column(name = "TEL_NUMBER")
	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@ManyToOne
	@JoinColumn(name = "CONTACT_ID")
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "ContactTelDetail [id=" + id + ", Contact id: " + getContact().getId() + ", telType=" + telType
				+ ", telNumber=" + telNumber + "]";
	}
}
