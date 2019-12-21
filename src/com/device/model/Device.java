/**
 * @author Farhiya Ahmed
 * 
 * 
 *         This class provides a general model of a device,basing on properties and attributes
 */
package com.device.model;

public class Device {

	// attributes / properties of a device
	private int id;
	private String name;
	private String type;

	public Device() {

	}

	// getters and setters for the attributes / properties

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", type=" + type + "";
	}

}
