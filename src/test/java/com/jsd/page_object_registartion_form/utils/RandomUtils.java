package com.jsd.page_object_registartion_form.utils;

import java.util.Random;

import static com.jsd.page_object_registartion_form.utils.TestData.NCR_CITIES;
import static com.jsd.page_object_registartion_form.utils.TestData.UP_CITIES;

public class RandomUtils {

    public static int getRandomIndex(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }

    public static String getRandomValue(String[] arr) {
        int index = getRandomIndex(arr.length);
        return arr[index];
    }

    public static String getRandomCity(String state) {
        /*String[] cities = switch (state) {
            case "NCR" -> NCR_CITIES;
            case "Uttar Pradesh" -> UP_CITIES;
            default -> throw new IllegalArgumentException("Invalid state: " + state);
        };
        int index = getRandomIndex(cities.length);
        return cities[index];*/

        String[] cities;
        switch (state) {
            case "NCR":
                cities = NCR_CITIES;
                break;
            case "Uttar Pradesh":
                cities = UP_CITIES;
                break;
            default:
                throw new IllegalArgumentException("Invalid state: " + state);
        }
        int index = getRandomIndex(cities.length);
        return cities[index];
    }
}
