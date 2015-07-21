package com.loncoto.InterfaceBuilder.windows;

import java.awt.BorderLayout;

import javax.swing.*;

import org.w3c.dom.Element;

public class BorderWindow extends BaseWindow {

	public BorderWindow(String name) {
		super(name);
		setLayout(new BorderLayout());
	}

	@Override
	public void placeComponent(JComponent c, Element componentDetails) {
		switch (componentDetails.getAttribute("pos")) {
			case "north":
				add(c, BorderLayout.NORTH);
				break;
			case "west":
				add(c, BorderLayout.WEST);
				break;
			case "south":
				add(c, BorderLayout.SOUTH);
				break;
			case "east":
				add(c, BorderLayout.EAST);
				break;
			case "center":
				add(c, BorderLayout.CENTER);
				break;
		}
	}
}
