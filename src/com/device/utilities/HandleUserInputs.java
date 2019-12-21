package com.device.utilities;

import java.util.ArrayList;
import java.util.Scanner;

import com.device.model.Device;

public class HandleUserInputs {

	private static int id = 0;

	public static int getId() {

		HandleUserInputs.id += 1;

		return id;
	}

	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

	public static void exitTheSystem() {
		System.exit(0);
	}

	public static void addNewItemToStock(Device aDevice, ArrayList<Device> allDevices) {
		allDevices.add(aDevice);
	}

}
