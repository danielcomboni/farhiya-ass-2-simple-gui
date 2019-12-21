package com.device.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.device.model.Smartphone;
import com.device.model.Device;
import com.device.model.Sales;
import com.device.repository.Repository;
import javafx.collections.ObservableList;

public class SmartphoneData implements Repository {

	private static ArrayList<Device> arrayListOfSmartphones;

	public static ArrayList<Device> getArrayListOfSmartphones() {
		return arrayListOfSmartphones;
	}

	public static void setArrayListOfSmartphones(ArrayList<Device> arrayListOfSmartphones) {
		SmartphoneData.arrayListOfSmartphones = arrayListOfSmartphones;
	}

	private ObservableList<Smartphone> smartphoneObservableList;

	public ObservableList<Smartphone> getSmartphoneObservableList() {
		return smartphoneObservableList;
	}

	public void setSmartphoneObservableList(ObservableList<Smartphone> smartphoneObservableList) {
		this.smartphoneObservableList = smartphoneObservableList;
	}

	private  void checkIfListIsNullOrEmpty(Device aSmartphone) {

		if (SmartphoneData.getArrayListOfSmartphones() == null || SmartphoneData.getArrayListOfSmartphones().isEmpty()) {
			ArrayList<Device> smartphones = new ArrayList<>();
			SmartphoneData.setArrayListOfSmartphones(smartphones);
			SmartphoneData.getArrayListOfSmartphones().add(aSmartphone);
		}
		else {		// update the ArrayList holding Smartphones in the Map
			SmartphoneData.getArrayListOfSmartphones().add(aSmartphone);
		}

	}

	@Override
	public Device addAnItemToStock(Device aSmartphone) {

		System.out.println("Add new \"smartphone\"");

		aSmartphone.setId(HandleUserInputs.getId());

		checkIfListIsNullOrEmpty(aSmartphone);

		System.out.println("the smartphone " + aSmartphone);

		return aSmartphone;
	}

	@Override
	public double checkAvailableStock(int deviceId) {
		return 0;
	}

	@Override
	public Sales recordASale(Sales aSale) {
		return null;
	}

	@Override
	public void displayLowStocks() {

	}

	@Override
	public void displayAvailableItemsAndGroupByCategory(int indexOfArrayListInMap) {

	}

	@Override
	public void printAllSales() {

	}

	@Override
	public Map<Integer, ArrayList<Device>> findAllDevicesMappedToTheirIndicesInAList() {
		return null;
	}

	@Override
	public ArrayList<Device> particularDeviceList() {
		return null;
	}

}
