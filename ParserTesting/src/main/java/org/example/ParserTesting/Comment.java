package org.example.ParserTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class Comment {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\Swarna\\eclipse-workspace\\ParserTesting\\src\\main\\java\\org\\example\\ParserTesting\\test.java";
        FileInputStream in = new FileInputStream(filePath);

        CompilationUnit cu;

        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // Visit and print sysout statements
        new MethodVisitor().visit(cu, null);

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            out.write(cu.toString().getBytes());
        }
    }

    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(ExpressionStmt n, Void arg) {
            super.visit(n, arg);

            if (n.getExpression() instanceof MethodCallExpr) {
                MethodCallExpr methodCall = (MethodCallExpr) n.getExpression();
                if (methodCall.getScope() != null && methodCall.getScope().toString().equals("System.out") && methodCall.getName().equals("println")) {
                    System.out.println("Found System.out.println: " + n);
                }
            }
        }
    }
}
