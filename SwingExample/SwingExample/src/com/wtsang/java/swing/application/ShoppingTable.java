package com.wtsang.java.swing.application;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShoppingTable {
	public static final String PURCHASE_BUTTON_STRING = "Purchase";
	public static final String ITEM_NAME_STRING = "Item Name";
	public static final String ITEM_CAT_STRING = "Category";
	private static final String[] COL_NAME = { ITEM_NAME_STRING,
			PURCHASE_BUTTON_STRING, ITEM_CAT_STRING };

	private Object[][] data;
	private ItemPurchaseListener listener;

	public ShoppingTable(Object[][] data,
			ItemPurchaseListener itemPurchaseListener) {
		this.listener = itemPurchaseListener;
		this.data = data;
	}

	public Component get() {
		DefaultTableModel dm = new DefaultTableModel();

		dm.setDataVector(data, COL_NAME);

		final JTable table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				super.mouseReleased(evt);
				int row=table.rowAtPoint(evt.getPoint());
				int col=table.columnAtPoint(evt.getPoint());
				listener.onItemPurchase(row,col);
			}

		});


		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}

}
