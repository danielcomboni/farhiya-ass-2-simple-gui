
/**
 * @author Farhiya Ahmed
 * 
 *         This class Extends Device class to provide a model for a Desktop device
 */
package com.device.model;

public class Desktop extends Device {

	private String screenWidth;

	public String getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(String screenWidth) {
		this.screenWidth = screenWidth;
	}

	@Override
	public String toString() {
		return super.toString() + ", screenWidth=" + this.screenWidth + "]";
	}

}
