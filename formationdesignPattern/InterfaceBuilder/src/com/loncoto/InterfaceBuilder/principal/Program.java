package com.loncoto.InterfaceBuilder.principal;

import javax.swing.JFrame;

import com.loncoto.InterfaceBuilder.factory.WindowFactory;

public class Program {

	public static void main(String[] args) {
		
		WindowFactory wf  = new WindowFactory("fenetre1.xml");
		
		JFrame f1 = wf.BuildWindow("window3");
		f1.setVisible(true);
	}

}
