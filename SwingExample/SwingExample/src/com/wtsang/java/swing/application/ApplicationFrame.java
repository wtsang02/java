package com.wtsang.java.swing.application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.wtsang.java.swing.application.model.ItemCategory;
import com.wtsang.java.swing.application.model.ShoppingItem;
import com.wtsang.java.swing.application.util.MapListUtil;

@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame {
	private Map<ItemCategory, List<ShoppingItem[]>> mappingInv;
	private Map<ItemCategory, List<ShoppingItem[]>> mappingCart;
	private Object[][] data;

	public ApplicationFrame() {

		
		data = getData();

	}

	private Object[][] getData() {
		Map<ItemCategory, List<ShoppingItem>> mapping = new HashMap<ItemCategory, List<ShoppingItem>>();
		ShoppingItem item = new ShoppingItem();
		item.setCat(ItemCategory.GAMES);
		item.setName("sdfsdf");
		item.setPrice(32423.232);

		mapping = MapListUtil.add(mapping, ItemCategory.GAMES, item);
		ShoppingItem item2 = new ShoppingItem();
		item2.setCat(ItemCategory.GAMES);
		item2.setName("sdfssdfddf");
		item2.setPrice(32322423.232);
		mapping = MapListUtil.add(mapping, ItemCategory.GAMES, item2);
		ShoppingItem item3 = new ShoppingItem();
		item3.setCat(ItemCategory.PHONE);
		item3.setName("sdffsdsdf");
		item3.setPrice(335352423.232);
		mapping = MapListUtil.add(mapping, ItemCategory.PHONE, item3);

		Object[][] data = ShoppingItem.flattenObject(MapListUtil
				.mapListToArray(mapping));
		// TODO
		return data;

	}

	public void addComponentsToPane(final Container pane) {
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		JLabel title = new JLabel("Welcome to application");
		topPanel.add(title);

		ShoppingTable table = new ShoppingTable(data,new ItemPurchaseListener(){

			@Override
			public void onItemPurchase(int row,int col) {
			
				System.out.print("purchase "+row+"  "+col);
			}});
		
		StateChooserPanel state = new StateChooserPanel(
				new StateChangeListener() {

					@Override
					public void onStateChange() {
						// TODO
						System.out.print("state changed");

					}
				});
		CartPanel cart = new CartPanel();

		pane.add(cart.get(), BorderLayout.EAST);
		pane.add(state.get(), BorderLayout.NORTH);
		pane.add(table.get(), BorderLayout.WEST);
		pane.add(topPanel, BorderLayout.SOUTH);
		//pane.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.CENTER);
	}
}
