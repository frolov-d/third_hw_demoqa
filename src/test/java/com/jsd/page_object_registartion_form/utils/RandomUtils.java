package com.jsd.page_object_registartion_form.utils;

import java.util.Random;

import static com.jsd.page_object_registartion_form.utils.TestData.NCR_CITIES;
import static com.jsd.page_object_registartion_form.utils.TestData.UP_CITIES;

public class RandomUtils {

    public static String getRandomValue(String[] arr) {
        Random random = new Random();
        int index = random.nextInt(arr.length);
        return arr[index];
    }

    public static String getRandomCity(String state) {
        String[] cities = switch (state) {
            case "NCR" -> NCR_CITIES;
            case "Uttar Pradesh" -> UP_CITIES;
            default -> throw new IllegalArgumentException("Invalid state: " + state);
        };
        return cities[new Random().nextInt(cities.length)];
    }
}
