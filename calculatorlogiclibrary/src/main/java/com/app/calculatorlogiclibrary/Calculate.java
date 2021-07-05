package com.app.calculatorlogiclibrary;

public class Calculate {

    //Method used for calculating the sum of two numbers
    public String add(double num1, double num2){
        return String.valueOf(num1+num2);
    }

    public String subtract(double num1, double num2){
        return String.valueOf(num1-num2);
    }

    public String multiply(double num1, double num2){
        return String.valueOf(num1 * num2);
    }

    public String divide(double num1, double num2){
        return String.valueOf(num1 / num2);
    }

    public String sine(double num){
        return String.valueOf(Math.sin(Math.toRadians(num)));
    }

    public String cos(double num){
        return String.valueOf(Math.cos(Math.toRadians(num)));
    }

    public String tan(double num){
        return String.valueOf(Math.tan(Math.toRadians(num)));
    }
}
