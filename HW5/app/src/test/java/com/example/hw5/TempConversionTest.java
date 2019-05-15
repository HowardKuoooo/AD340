package com.example.hw5;

import com.google.common.truth.Truth;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;

import static com.google.common.truth.Truth.assertThat;

public class TempConversionTest {

    TempConversion tempConversion;

    @Before
    public void setUp(){
        this.tempConversion = new TempConversion(0,32);
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

    }

    @After
    public void after(){

    }


}
