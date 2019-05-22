package com.example.hw5;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import androidx.test.core.app.ApplicationProvider;

import static com.google.common.truth.Truth.assertThat;

@RunWith(RobolectricTestRunner.class)
public class TempConversionRobolectricTest {

    @Test
    public void TempConversion_Default_ReturnsCorrectValues_Robolectric() {
        Context roboContext = ApplicationProvider.getApplicationContext ();

        TempConversion defaultTempCov = new TempConversion(roboContext);

        double dCelisius = defaultTempCov.getCelsius (30);
        assertThat (dCelisius).isEqualTo (21.0);

    }
}