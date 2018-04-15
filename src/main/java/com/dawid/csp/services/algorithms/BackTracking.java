package com.dawid.csp.services.algorithms;

import com.dawid.csp.app.App;
import com.dawid.csp.services.csp.IProblem;
import com.dawid.csp.services.utils.MyTreeNode;
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
        int[][] start = new int[App.N][App.N];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                start[i][j] = 0;
            }
        }
        MyTreeNode root = new MyTreeNode(start);

        return problem.placeNext(root, 0);
    }
}
