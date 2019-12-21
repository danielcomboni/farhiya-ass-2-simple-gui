package com.device.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.device.model.Laptop;
import com.device.model.Device;
import com.device.model.Sales;
import com.device.repository.Repository;
import javafx.collections.ObservableList;

public class LaptopData implements Repository {

	private static ArrayList<Device> arrayListOfLaptops;

	public static ArrayList<Device> getArrayListOfLaptops() {
		return arrayListOfLaptops;
	}

	public static void setArrayListOfLaptops(ArrayList<Device> arrayListOfLaptops) {
		LaptopData.arrayListOfLaptops = arrayListOfLaptops;
	}

	private ObservableList<Laptop> laptopObservableList;

	public ObservableList<Laptop> getLaptopObservableList() {
		return laptopObservableList;
	}

	public void setLaptopObservableList(ObservableList<Laptop> laptopObservableList) {
		this.laptopObservableList = laptopObservableList;
	}

	private  void checkIfListIsNullOrEmpty(Device aLaptop) {

		if (LaptopData.getArrayListOfLaptops() == null || LaptopData.getArrayListOfLaptops().isEmpty()) {
			ArrayList<Device> laptops = new ArrayList<>();
			LaptopData.setArrayListOfLaptops(laptops);
			LaptopData.getArrayListOfLaptops().add(aLaptop);
		}
		else {		// update the ArrayList holding Laptops in the Map
			LaptopData.getArrayListOfLaptops().add(aLaptop);
		}


	}

	@Override
	public Device addAnItemToStock(Device aLaptop) {

		System.out.println("Add new \"laptop\"");

		aLaptop.setId(HandleUserInputs.getId());

		checkIfListIsNullOrEmpty(aLaptop);

		System.out.println("the laptop " + aLaptop);

		return aLaptop;
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
