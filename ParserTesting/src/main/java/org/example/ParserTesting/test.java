package org.example.ParserTesting;

import java.util.Scanner;

@Deprecated
public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the shape to calculate the area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter the length of the rectangle:");
                double length = scanner.nextDouble();
                System.out.println("Enter the width of the rectangle:");
                double width = scanner.nextDouble();
                double rectangleArea = calculateRectangleArea(length, width);
                System.out.println("The area of the rectangle is: " + rectangleArea);
                break;
            case 2:
                System.out.println("Enter the radius of the circle:");
                double radius = scanner.nextDouble();
                double circleArea = calculateCircleArea(radius);
                System.out.println("The area of the circle is: " + circleArea);
                break;
            case 3:
                System.out.println("Enter the base of the triangle:");
                double base = scanner.nextDouble();
                System.out.println("Enter the height of the triangle:");
                double height = scanner.nextDouble();
                double triangleArea = calculateTriangleArea(base, height);
                System.out.println("The area of the triangle is: " + triangleArea);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        scanner.close();
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    
}
