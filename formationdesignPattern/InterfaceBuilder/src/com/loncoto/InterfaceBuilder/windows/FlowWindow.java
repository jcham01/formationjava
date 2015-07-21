package com.loncoto.InterfaceBuilder.windows;

import java.awt.FlowLayout;

import javax.swing.JComponent;

import org.w3c.dom.Element;

public class FlowWindow extends BaseWindow {
	public FlowWindow(String name) {
		super(name);
		setLayout(new FlowLayout());
	}

	@Override
	public void placeComponent(JComponent c, Element componentDetails) {
		add(c);
	}

}
