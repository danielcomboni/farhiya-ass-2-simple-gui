//package com.device.utilities;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class Prompts {
//
//	public static void startSystem(List<Class<?>> classes) {
//
//		action(classes);
//
//	}
//
//	public static int prompts() {
//
//		Scanner scanner = HandleUserInputs.getScanner();
//		System.out.println("\n");
//		System.out.println("=======================================================================================");
//
//		System.out.println("Select an action");
//		System.out.println("0- Exit the system");
//		System.out.println("1- Add new items to the stock");
//		System.out.println("2- Display all items by categories");
//		System.out.println("3- Display low stock");
//		System.out.println("4- Record a sale");
//		System.out.println("5- Check availability stock");
//		System.out.println("6- print all sales");
//
//		int chosen = scanner.nextInt();
//		return chosen;
//	}
//
//	public static void action(List<Class<?>> classes) {
//
//		int chosen = prompts();
//
//		if (chosen == 1) { // when 1 is chosen
//
//			Scanner scanner = HandleUserInputs.getScanner();
//			System.out.println("==============================");
//
//			for (Class<?> cls : classes) {
//				System.out.println(classes.indexOf(cls) + " - add \"" + cls.getSimpleName() + "\"");
//			}
//
//			System.out.println(classes.size() + 1 + " - back");
//			System.out.println("==============================");
//
//			int clsChosen = scanner.nextInt();
//
//			if (clsChosen == 0) {
//				// adds a Tablet
//				new TabletsData().addAnItemToStock();
//				// go back to prompts
//				action(classes);
//			}
//
//			if (clsChosen == 1) {
//				// add a Smartphone
//				new SmartphoneData().addAnItemToStock();
//				// go back to prompts
//				action(classes);
//			}
//
//			if (clsChosen == 2) {
//				// add a Desktop
//				new DesktopData().addAnItemToStock();
//				// go back to prompts
//				action(classes);
//			}
//
//			if (clsChosen == 3) {
//				// add a Laptop
//				new LaptopData().addAnItemToStock();
//				// go back to prompt
//				action(classes);
//			}
//
//			if (clsChosen == 5) {
//				action(classes);
//			}
//
//		} // end 1st choice (adding new device)
//
//		// ===========================================================================
//		// start display
//		// ===========================================================================
//		// display device by category
//
//		if (chosen == 2) {
//
//			Scanner scanner = HandleUserInputs.getScanner();
//			System.out.println("==============================");
//
//			for (Class<?> cls : classes) {
//				System.out.println(classes.indexOf(cls) + " - display category \"" + cls.getSimpleName() + "\"");
//			}
//
//			System.out.println("5 - back");
//
//			int clsChosen = scanner.nextInt();
//
//			if (clsChosen == 0) {
//
//				// display category tablets
//				System.out.println("All Tablets\n=================================================");
//				new TabletsData().displayAvailableItemsAndGroupByCategory(clsChosen);
//				// go back to prompts
//				action(classes);
//
//			}
//
//			if (clsChosen == 1) {
//				// add a Smartphone
//				System.out.println("All Smartphones\n=================================================");
//				new SmartphoneData().displayAvailableItemsAndGroupByCategory(clsChosen);
//				// go back to prompts
//				action(classes);
//			}
//
//			if (clsChosen == 2) {
//				// add a Desktop
//				System.out.println("All Desktops\n=================================================");
//				new DesktopData().displayAvailableItemsAndGroupByCategory(clsChosen);
//				// go back to prompts
//				action(classes);
//			}
//
//			if (clsChosen == 3) {
//				// add a Laptop
//				System.out.println("All Laptops\n=================================================");
//				new LaptopData().displayAvailableItemsAndGroupByCategory(clsChosen);
//				// go back to prompt
//				action(classes);
//			}
//
//			if (clsChosen == 5) {
//				action(classes);
//			}
//
//		}
//
//	}
//
//}
