package com.wtsang.java.swing.application.model;

public class ShoppingItem {
	private String name;
	private double price;
	private ItemCategory cat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ItemCategory getCat() {
		return cat;
	}

	public void setCat(ItemCategory cat) {
		this.cat = cat;
	}

	public static Object[][] flattenObject(Object[] data) {
		Object[][] tableData = new Object[data.length][3];

		for (int i = 0; i < data.length; i++) {
			ShoppingItem item = (ShoppingItem) data[i];

			tableData[i][0] = item.getName();
			tableData[i][1] = item.getPrice();
			tableData[i][2] = item.getCat();

		}

		return tableData;
	}
}
