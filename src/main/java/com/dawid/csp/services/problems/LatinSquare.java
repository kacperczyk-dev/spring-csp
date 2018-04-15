package com.dawid.csp.services.problems;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("l")
public class LatinSquare implements IProblem {

    public LatinSquare() {
    }

    @Override
    public int[][] placeNext(int[][] current, int next) {

        return new int[0][0];
    }
}
