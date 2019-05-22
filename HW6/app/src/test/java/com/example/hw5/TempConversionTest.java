package com.example.hw5;

import android.content.Context;

import com.google.common.truth.Truth;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

public class TempConversionTest {

    TempConversion tempConversion;

    @Mock
    Context mockContext;




    @Before
    public void setUp(){
        this.tempConversion = new TempConversion(0,32,"");

        MockitoAnnotations.initMocks (this);

        when(mockContext.getString (R.string.default_TempConversion))
                .thenReturn("Default Temp");

        when(mockContext.getString (R.string.default_celsius))
                .thenReturn (String.valueOf (21));


    }

    @Test
    public void TempConversion_ReturnsCorrectValues(){

        double newCelisius = (double) tempConversion.getCelsius (0);
        assertThat(newCelisius).isEqualTo (0.0);
        double newFahrenheit = (double) tempConversion.getFahrenheit (32);
        assertThat(newFahrenheit).isEqualTo (32.0);

        double testctof = (double) tempConversion.cTof (0);
        assertThat(testctof).isEqualTo (32.0);
        double testftoc = (double) tempConversion.fToc (32);
        assertThat(testftoc).isEqualTo (0.0);

        double testsetter = tempConversion.setCelsius(10);
        assertThat(testsetter).isEqualTo (10.0);
        double testsetter2 = tempConversion.setFahrenheit (20);
        assertThat(testsetter2).isEqualTo (20.0);

        TempConversion temp1 = new TempConversion(40,0,"HOT");
        assertThat (temp1.getName()).isEqualTo("HOT");

        TempConversion temp2 = new TempConversion(21,0,"Comfortabe");
        assertThat (temp2.getName()).isEqualTo("Comfortabe");

        TempConversion temp3 = new TempConversion(-5,0,"Cold");
        assertThat (temp3.getName()).isEqualTo("Cold");

        TempConversion temp4 = new TempConversion(0,86,"HOT");
        assertThat (temp4.getName()).isEqualTo("HOT");

        TempConversion temp5 = new TempConversion(0,70,"Comfortabe");
        assertThat (temp5.getName()).isEqualTo("Comfortabe");

        TempConversion temp6 = new TempConversion(0,23,"Cold");
        assertThat (temp6.getName()).isEqualTo("Cold");


    }

    @Test
    public void TempConversion_Default_ReturnsCorrectValues(){
        TempConversion defaultTempCov = new TempConversion(mockContext);

        double dCelisius = defaultTempCov.getCelsius (30);
        assertThat (dCelisius).isEqualTo (21.0);

    }

    @After
    public void after(){

    }


}
