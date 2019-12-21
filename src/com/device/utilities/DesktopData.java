package com.device.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.device.model.Desktop;
import com.device.model.Device;
import com.device.model.Sales;
import com.device.repository.Repository;
import javafx.collections.ObservableList;

public class DesktopData implements Repository {

	private static ArrayList<Device> arrayListOfDesktops;

	public static ArrayList<Device> getArrayListOfDesktops() {
		return arrayListOfDesktops;
	}

	public static void setArrayListOfDesktops(ArrayList<Device> arrayListOfDesktops) {
		DesktopData.arrayListOfDesktops = arrayListOfDesktops;
	}

	private ObservableList<Desktop> desktopObservableList;

	public ObservableList<Desktop> getDesktopObservableList() {
		return desktopObservableList;
	}

	public void setDesktopObservableList(ObservableList<Desktop> desktopObservableList) {
		this.desktopObservableList = desktopObservableList;
	}

	private  void checkIfListIsNullOrEmpty(Device aDesktop) {

		if (DesktopData.getArrayListOfDesktops() == null || DesktopData.getArrayListOfDesktops().isEmpty()) {
			ArrayList<Device> desktops = new ArrayList<>();
			DesktopData.setArrayListOfDesktops(desktops);
			DesktopData.getArrayListOfDesktops().add(aDesktop);
		}
		else {		// update the ArrayList holding Desktops in the Map
			DesktopData.getArrayListOfDesktops().add(aDesktop);
		}


	}

	@Override
	public Device addAnItemToStock(Device aDesktop) {

		System.out.println("Add new \"desktop\"");

		aDesktop.setId(HandleUserInputs.getId());

		checkIfListIsNullOrEmpty(aDesktop);

		System.out.println("the desktop " + aDesktop);

		return aDesktop;
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
