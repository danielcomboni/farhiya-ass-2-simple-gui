package com.device.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.device.model.Tablet;
import com.device.model.Device;
import com.device.model.Sales;
import com.device.repository.Repository;
import javafx.collections.ObservableList;

public class TabletsData implements Repository {

	private static ArrayList<Device> arrayListOfTablets;

	public static ArrayList<Device> getArrayListOfTablets() {
		return arrayListOfTablets;
	}

	public static void setArrayListOfTablets(ArrayList<Device> arrayListOfTablets) {
		TabletsData.arrayListOfTablets = arrayListOfTablets;
	}

	private ObservableList<Tablet> tabletObservableList;

	public ObservableList<Tablet> getTabletObservableList() {
		return tabletObservableList;
	}

	public void setTabletObservableList(ObservableList<Tablet> tabletObservableList) {
		this.tabletObservableList = tabletObservableList;
	}

	private  void checkIfListIsNullOrEmpty(Device aTablet) {

		if (TabletsData.getArrayListOfTablets() == null || TabletsData.getArrayListOfTablets().isEmpty()) {
			ArrayList<Device> tablets = new ArrayList<>();
			TabletsData.setArrayListOfTablets(tablets);
			TabletsData.getArrayListOfTablets().add(aTablet);
		}
		else {		// update the ArrayList holding Tablets in the Map
			TabletsData.getArrayListOfTablets().add(aTablet);
		}


	}

	@Override
	public Device addAnItemToStock(Device aTablet) {

		System.out.println("Add new \"tablet\"");

		aTablet.setId(HandleUserInputs.getId());

		checkIfListIsNullOrEmpty(aTablet);

		System.out.println("the tablet " + aTablet);

		return aTablet;
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
