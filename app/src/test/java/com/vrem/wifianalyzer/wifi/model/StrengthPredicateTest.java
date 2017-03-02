/*
 * WiFi Analyzer
 * Copyright (C) 2017  VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.vrem.wifianalyzer.wifi.model;

import android.support.annotation.NonNull;

import com.vrem.wifianalyzer.wifi.band.WiFiWidth;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StrengthPredicateTest {

    @Test
    public void testStrengthPredicate() throws Exception {
        WiFiDetail wiFiDetail = makeWiFiDetail(-60);
        assertTrue(new StrengthPredicate(Strength.THREE).evaluate(wiFiDetail));
        assertFalse(new StrengthPredicate(Strength.FOUR).evaluate(wiFiDetail));
    }

    @NonNull
    private WiFiDetail makeWiFiDetail(int level) {
        WiFiSignal wiFiSignal = new WiFiSignal(2445, 2445, WiFiWidth.MHZ_20, level);
        return new WiFiDetail("SSID", "BSSID", "WPA", wiFiSignal, WiFiAdditional.EMPTY);
    }

}