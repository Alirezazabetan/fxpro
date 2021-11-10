package com.fxpro.service;

import com.fxpro.service.validation.Validation;

public class WaterCalculator {

    public static int calculateWaterAmount(int[] landscape) {
        Validation.validateSize(landscape);
        int indRight = landscape.length - 1;
        int indLeft = 0, maxLeft = 0, maxRight = 0, collectedWater = 0;
        while (indLeft <= indRight) {
            Validation.validateHeight(landscape, indRight, indLeft);
            if (maxRight <= maxLeft) {
                collectedWater += Math.max(0, maxRight - landscape[indRight] - 2);
                maxRight = Math.max(maxRight, landscape[indRight]);
                indRight -= 1;
            } else {
                collectedWater += Math.max(0, maxLeft - landscape[indLeft] - 2);
                maxLeft = Math.max(maxLeft, landscape[indLeft]);
                indLeft += 1;
            }
        }
        return collectedWater;
    }
}

