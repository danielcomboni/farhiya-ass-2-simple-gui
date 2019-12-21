package com.device.model;

public class Laptop extends Device {

	private String core;

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	@Override
	public String toString() {
		return super.toString() + ", core=" +core+"]";
	}

}
