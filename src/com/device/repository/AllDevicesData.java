package com.device.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.device.model.Device;

public class AllDevicesData {

	private static Map<Integer, ArrayList<Device>> allDevicesMap;

	public static Map<Integer, ArrayList<Device>> getAllDevicesMap() {
		return AllDevicesData.allDevicesMap;
	}

	public static void setAllDevicesMap(Map<Integer, ArrayList<Device>> allDevicesMap) {
		AllDevicesData.allDevicesMap = allDevicesMap;
	}

	public static void addDeviceToDataStore(int indexOfDevice, ArrayList<Device> arrayListOfADevice) {

		if (getAllDevicesMap() == null || getAllDevicesMap().isEmpty()) {

			Map<Integer, ArrayList<Device>> aMap = new HashMap<>();

			aMap.put(indexOfDevice, arrayListOfADevice);

			setAllDevicesMap(aMap);

		} else {

			getAllDevicesMap().put(indexOfDevice, arrayListOfADevice);

		}

	}
}
