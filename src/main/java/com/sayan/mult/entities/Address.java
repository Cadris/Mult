package com.sayan.mult.entities;

public class Address implements IEntitiesMaster {
	
	private String location;
	private String street;
	private String country;
	
	public Address() {}
	
	public Address(String location, String street, String country) {
		super();
		this.location = location;
		this.street = street;
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Address [location=" + location + ", street=" + street + ", country=" + country + "]";
	}

	
}
