/**
 * @author Farhiya Ahmed
 * 
 *         This class Extends Device class to provide a model for a Smart phone device
 */
package com.device.model;

public class Smartphone extends Device {

	private double cameraStrength;

	public double getCameraStrength() {
		return cameraStrength;
	}

	public void setCameraStrength(double cameraStrength) {
		this.cameraStrength = cameraStrength;
	}

	@Override
	public String toString() {
		return super.toString() + ", camera strength=" + this.cameraStrength + "]";
	}
	
	
}
