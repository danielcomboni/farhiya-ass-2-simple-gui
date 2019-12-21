package com.device.utilities;

import java.util.ArrayList;

import com.device.model.Device;

public class ActionChoice {

	public static int actionToPerform(Device aDevice, ArrayList<Device> allDevices) {

		int actionId = -1;

		if (actionId == 0) {
			HandleUserInputs.exitTheSystem();
		}

		if (actionId == 1) {
			HandleUserInputs.addNewItemToStock(aDevice, allDevices);
		}

		if (actionId == 2) {
			HandleUserInputs.addNewItemToStock(aDevice, allDevices);
		}

		if (actionId == 3) {
			HandleUserInputs.addNewItemToStock(aDevice, allDevices);
		}

		if (actionId == 4) {
			HandleUserInputs.addNewItemToStock(aDevice, allDevices);
		}

		if (actionId == 5) {
			HandleUserInputs.addNewItemToStock(aDevice, allDevices);
		}

		return actionId;
	}
}
