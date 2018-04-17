package com.dawid.csp.services.csp;

import com.dawid.csp.services.utils.MyTreeNode;

public interface IProblem {

    int[][] placeNext(MyTreeNode current, int next);
    int[][] placeNext(MyTreeNode current, int next, int v);
}
