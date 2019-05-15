package com.example.hw5;


import android.content.Context;

public class TempConversion {

    //private String name;
    private double celsius;
    private double fahrenheit;


    public TempConversion(double celsius, double fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public double getCelsius(int i) {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit(int i) {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public static double cTof(double celsius){
        return (celsius*(9/5)) + 32;
    }

    public static double fToc(double fahrenheit){
        return (fahrenheit-32)*(5/9);
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
