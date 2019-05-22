package com.example.hw5;


import android.content.Context;

public class TempConversion {

    //private String name;
    private double celsius;
    private static double fahrenheit;
    private String name;

    public enum name{Hot,Comfortable,Cold}



    public String getName() {

        return name;
    }

    public TempConversion(double celsius, double fahrenheit, String name) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
        this.name = name;
    }

    public double getCelsius(int i) {
        return celsius;
    }

    public double setCelsius(double celsius) {
        this.celsius = celsius;
        return celsius;
    }

    public double getFahrenheit(int i) {
        return fahrenheit;
    }

    public double setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        return fahrenheit;
    }

    public static double cTof(double celsius){
        return (celsius*(9/5)) + 32;
    }

    public static double fToc(double fahrenheit){
        return (fahrenheit-32)*(5/9);
    }

    public TempConversion(Context ctx){
        this.name = "Default";

        String default_celsius;
        default_celsius = "21";
        this.celsius = Double.parseDouble (default_celsius);
        String default_fahrenheit = "70";
        this.fahrenheit = Double.parseDouble (default_fahrenheit);
    }



    /*
    pulic TempConversion(Context ctx){
    this.name = "Default profile"

    String defaulttemp = "32";

    //not sure about the baseRate
    this.baseRate = Double



    }
     */

}
