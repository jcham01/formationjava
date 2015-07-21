package com.loncoto.annotationProject.principal;

import com.loncoto.annotationProject.util.CommentAnnotation;

public class Program {

	
	public static void main(String[] args) {
		
		TestClass tc = new TestClass();
		Class cls = tc.getClass();
		
		CommentAnnotation ca = (CommentAnnotation) cls.getAnnotation(CommentAnnotation.class);
		System.out.println("pour" + cls.getCanonicalName() 
				+ " :" + ca.comment() + " -> " + ca.version());
		
	}

}
