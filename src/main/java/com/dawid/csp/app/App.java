package com.dawid.csp.app;

import com.dawid.csp.services.algorithms.IAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class App {

    final static int N = 8;
    private IAlgorithm alg;

    public App(IAlgorithm alg) {
        this.alg = alg;
    }
}
