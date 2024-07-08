package org.example.ParserTesting;

import java.io.FileInputStream;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.PackageDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class MethodPrinter {
	
	public static void main(String[] args) throws Exception {
	    // creates an input stream for the file to be parsed
	    FileInputStream in = new FileInputStream("C:\\Users\\Swarna\\eclipse-workspace\\ParserTesting\\src\\main\\java\\org\\example\\ParserTesting\\test.java");

	    CompilationUnit cu;
	    try {
	        // parse the file
	       // cu = JavaParser.parse(in);
	    } finally {
	        in.close();
	    }

	    // visit and print the methods names
	    new MethodVisitor().visit(cu, null);
	}

	/**
	 * Simple visitor implementation for visiting MethodDeclaration nodes. 
	 */
	private static class MethodVisitor extends VoidVisitorAdapter {

	    @Override
	    public void visit(MethodDeclaration n, Object arg) {
	    	
	        System.out.println(n.getName());
	    }
	    
	    
	   
	}

}
