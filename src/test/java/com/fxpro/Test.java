package com.fxpro;

import com.fxpro.service.WaterCalculator;
import com.fxpro.service.exception.*;
import org.junit.Assert;
import java.util.Random;

public class Test {

    @org.junit.Test(expected = InvalidLandscapeException.class)
    public void exceeded_limit_of_landscape_size() {
        int[] arr = new int[32001];
        for (int i = 0; i< 32001; i++) {
            arr[i] = 0;
        }
        WaterCalculator.calculateWaterAmount(arr);
    }

    @org.junit.Test(expected = InvalidHeightException.class)
    public void exceeded_limit_of_height_size() {
        int[] arr = {32001};
        WaterCalculator.calculateWaterAmount(arr);
    }

    @org.junit.Test
    public void empty_array() {
        int[] arr = {};
        int i = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertTrue( "Your implementation for this problem is not correct", i == 0);
    }

    @org.junit.Test
    public void one_element_array() {
        int[] arr = {0};
        int i = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertTrue( "Your implementation for this problem is not correct", i == 0);
    }

    @org.junit.Test
    public void mountain_without_pits() {
        int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
        int i = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertTrue( "Your implementation for this problem is not correct", i == 0);
    }


    @org.junit.Test
    public void array_with_ten_elements() {
        int[] arr = {5,1,2,4,5,4,0,3,1,9};
        int i = WaterCalculator.calculateWaterAmount(arr);
        Assert.assertTrue( "Your implementation for this problem is not correct", i == 8);
    }

    @org.junit.Test
    public void array_with_one_hundred_elements() {
        long startTime = System.currentTimeMillis();
        int[] arr = new int[100];
        Random objGenerator = new Random();
        for (int i = 0; i< 100; i++) {
            arr[i] = objGenerator.nextInt(32000);
        }
        WaterCalculator.calculateWaterAmount(arr);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        Assert.assertTrue( "The Algorithm used has poor performance", timeTaken < 20);
    }

    @org.junit.Test
    public void array_with_one_thousand_elements() {
        long startTime = System.currentTimeMillis();
        int[] arr = new int[1000];
        Random objGenerator = new Random();
        for (int i = 0; i< 1000; i++) {
            arr[i] = objGenerator.nextInt(32000);
        }
        WaterCalculator.calculateWaterAmount(arr);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        Assert.assertTrue( "The Algorithm used has poor performance", timeTaken < 20);
    }

    @org.junit.Test
    public void array_with_thirty_two_thousand_elements() {
        long startTime = System.currentTimeMillis();
        int[] arr = new int[32000];
        Random objGenerator = new Random();
        for (int i = 0; i< 32000; i++) {
            arr[i] = objGenerator.nextInt(32000);
        }
        WaterCalculator.calculateWaterAmount(arr);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        Assert.assertTrue( "The Algorithm used has poor performance", timeTaken < 20);
    }

}