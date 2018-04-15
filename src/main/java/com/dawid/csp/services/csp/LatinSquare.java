package com.dawid.csp.services.csp;

import com.dawid.csp.services.utils.MyTreeNode;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("l")
public class LatinSquare implements IProblem {

    public LatinSquare() {
    }

    @Override
    public int[][] placeNext(MyTreeNode current, int next) {

        return new int[0][0];
    }
}
