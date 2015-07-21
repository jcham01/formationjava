package com.loncoto.InterfaceBuilder.windows;

import java.awt.GridLayout;

import javax.swing.JComponent;

import org.w3c.dom.Element;

public class GridWindow extends BaseWindow {
	
	public GridWindow(String name, int cols, int rows) {
		super(name);
		setLayout(new GridLayout(rows, cols));
	}

	@Override
	public void placeComponent(JComponent c, Element componentDetails) {
		add(c);
	}

}
