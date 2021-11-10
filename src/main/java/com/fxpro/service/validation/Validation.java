package com.fxpro.service.validation;

import com.fxpro.service.exception.*;

public class Validation {

    public static void validateSize(int[] landscape) {
        if (landscape.length > 32000)
            throw new InvalidLandscapeException();
    }

    public static void validateHeight(int[] landscape, int indRight, int indLeft) {
        if (landscape[indRight] > 32000 ||
                landscape[indRight] < 0 ||
                landscape[indLeft] > 32000 ||
                landscape[indLeft] < 0)
            throw new InvalidHeightException();
    }

}
