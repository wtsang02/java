package com.wtsang.java.swing.application;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartPanel {
	private DefaultListModel listModel;
	private JList list;

	public CartPanel() {

	}

	public Component get() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		listModel = new DefaultListModel();
		listModel.addElement("Jane Doe");
		listModel.addElement("John Smith");
		listModel.addElement("Kathy Green");
		listModel.addElement("Jane Doe");
		listModel.addElement("John Smith");
		listModel.addElement("Kathy Green");
		list = new JList(listModel);

		JScrollPane listScrollPane = new JScrollPane(list);
		panel.add(listScrollPane,BorderLayout.NORTH);
		
		JPanel control=new JPanel();
		control.setLayout(new BoxLayout(control, 0));
		JButton delete=new JButton("Delete");
		JButton checkout=new JButton("Checkout");
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				pop();
				
			}
			
			
		});
		checkout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkout();
				
			}
			
		});
		control.add(delete);
		control.add(checkout);
		
		panel.add(control,BorderLayout.SOUTH);
		
		return panel;
	}

	public void push(String item) {
		listModel.addElement(item);
	}

	public void pop() {
		listModel.remove(listModel.getSize()-1);
	}
	public void clear(){
		listModel.clear();
	}

	public void checkout() {
		System.out.println("checkout");
	}
}
