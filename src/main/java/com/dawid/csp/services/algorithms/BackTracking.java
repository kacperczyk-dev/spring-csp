package com.dawid.csp.services.algorithms;

import com.dawid.csp.services.problems.IProblem;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("bt")
public class BackTracking implements IAlgorithm {

    private IProblem problem;

    public BackTracking(IProblem problem) {
        this.problem = problem;
    }

    @Override
    public int[][] calculate() {
        return new int[0][0];
    }
}
