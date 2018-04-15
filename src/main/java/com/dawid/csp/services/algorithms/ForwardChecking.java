package com.dawid.csp.services.algorithms;

import com.dawid.csp.services.csp.IProblem;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("fc")
public class ForwardChecking implements IAlgorithm {

    private IProblem problem;

    public ForwardChecking(IProblem problem) {
        this.problem = problem;
    }

    @Override
    public int[][] calculate() {
        return new int[0][0];
    }
}
