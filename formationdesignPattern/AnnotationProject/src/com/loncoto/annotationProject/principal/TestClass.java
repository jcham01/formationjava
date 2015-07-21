package com.loncoto.annotationProject.principal;

import com.loncoto.annotationProject.util.CommentAnnotation;

@CommentAnnotation(comment="une classe de test", version=2)
public class TestClass {
	
	
	@CommentAnnotation(comment="et aussi sur une methode")
	public void testMethode() {
		System.out.println("rien.....");
	}

}
