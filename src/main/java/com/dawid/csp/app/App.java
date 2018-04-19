package com.dawid.csp.app;

import com.dawid.csp.services.algorithms.IAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class App {

    private IAlgorithm alg;
    public final static int N = 9;

    public App(IAlgorithm alg) {
        this.alg = alg;
    }

    public void solve(){

        int[][] solved = alg.calculate();

        if(solved != null) {
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    String s = solved[i][j] >= 10 ? "   " : "    ";
                    System.out.print(solved[i][j] + s);
                }
                System.out.print("\n");
            }
            System.out.println("Solved!");
        }

    }
}
