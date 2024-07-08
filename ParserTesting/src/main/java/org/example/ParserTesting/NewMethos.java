package org.example.ParserTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import japa.parser.ASTHelper;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.SwitchStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class NewMethos {

    public static void main(String[] args) throws Exception {
        // Create an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("C:\\Users\\Swarna\\eclipse-workspace\\ParserTesting\\src\\main\\java\\org\\example\\ParserTesting\\test.java");

        CompilationUnit cu;
        try {
            // Parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // Add a new method to calculate square area
        addSquareAreaMethod(cu);

        // Print the resulting compilation unit to default system output
        System.out.println(cu.toString());

        // Optionally write the modified compilation unit back to the file
        FileOutputStream out = new FileOutputStream("C:\\Users\\Swarna\\eclipse-workspace\\ParserTesting\\src\\main\\java\\org\\example\\ParserTesting\\test.java");
        out.write(cu.toString().getBytes());
        out.close();
    }

    private static void addSquareAreaMethod(CompilationUnit cu) {
        // Create a new method declaration
        MethodDeclaration squareAreaMethod = new MethodDeclaration();
        squareAreaMethod.setName("calculateSquareArea");
        squareAreaMethod.setType(ASTHelper.DOUBLE_TYPE);
      //  ASTHelper.addModifier(squareAreaMethod, ModifierSet.PUBLIC);

        // Add parameters to the method
        ASTHelper.addParameter(squareAreaMethod, ASTHelper.createParameter(ASTHelper.DOUBLE_TYPE, "side"));

        // Create method body
        BlockStmt methodBody = new BlockStmt();
      //  ASTHelper.addStmt(methodBody, ASTHelper.createReturnStmt(ASTHelper.createBinaryExpr(new NameExpr("side"), japa.parser.ast.expr.BinaryExpr.Operator.mult, new NameExpr("side"))));
        squareAreaMethod.setBody(methodBody);

        // Add the new method to the class
        TypeDeclaration typeDeclaration = (TypeDeclaration) cu.getTypes().get(0); // Assuming there's only one class in the file
        ASTHelper.addMember(typeDeclaration, squareAreaMethod);
    }
}
