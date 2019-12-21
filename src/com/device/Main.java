//package com.device;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.device.model.Desktop;
//import com.device.model.Laptop;
//import com.device.model.Smartphone;
//import com.device.model.Tablet;
////import com.device.utilities.Prompts;
//
//public class Main {
//
//	public static void main(String[] args) {
//
//		// list of all model class / devices
//		List<Class<?>> deviceModels = new ArrayList<>();
//
//		deviceModels.add(Tablet.class);
//		deviceModels.add(Smartphone.class);
//		deviceModels.add(Desktop.class);
//		deviceModels.add(Laptop.class);
//
//		for (Class<?> cls : deviceModels) {
//			System.out.println("cls: " + cls.getSimpleName() + " " + deviceModels.indexOf(cls));
//		}
//
//		Prompts.startSystem(deviceModels);
//
//	}
//
//}