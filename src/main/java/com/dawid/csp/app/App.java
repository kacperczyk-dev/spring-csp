package com.dawid.csp.app;

import com.dawid.csp.services.algorithms.IAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class App {

    private IAlgorithm alg;
    public final static int N = 8;

    public App(IAlgorithm alg) {
        this.alg = alg;
    }

    public void solve(){

        int[][] solved = alg.calculate();

        if(solved != null){
            for (int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    System.out.print(solved[i][j] + "    ");
                }
                System.out.print("\n");
            }
            System.out.println("Solved");
        }

    }
}
