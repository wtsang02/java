package com.wtsang.java.swing.application;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.wtsang.java.swing.application.model.CustomerState;

public class StateChooserPanel {
	JButton buttonNone = new JButton("None");
	JButton button1 = new JButton("None1");
	JButton button2 = new JButton("None2");
	JButton button3 = new JButton("None3");
	StateChangeListener listener;
	public StateChooserPanel(StateChangeListener listen) {
		listener=listen;
	}

	public Component get() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				selectedState(1);
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				selectedState(2);

			}
		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				selectedState(3);

			}
		});
		buttonNone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				selectedState(0);
			}
		});

		panel.add(buttonNone);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		return panel;
	}

	void selectedState(int i) {
		listener.onStateChange();
		System.out.println("button selected  "+CustomerState.findByNumber(i).toString());
	}

}
