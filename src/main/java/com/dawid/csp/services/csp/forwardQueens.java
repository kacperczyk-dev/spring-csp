package com.dawid.csp.services.csp;

import com.dawid.csp.app.App;
import com.dawid.csp.services.utils.MyTreeNode;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@SuppressWarnings("Duplicates")
@Service
@Profile("fqueens")
public class forwardQueens implements IProblem {

    final static int N = App.N;
    static int counter = 0;

    @Override
    public int[][] placeNext(MyTreeNode current, int next) {

        counter++;
        int[][] data = (int[][]) current.getData();
        if(!forsee(data, next)) {
            return placeNext(current.getParent(), next-1);
        }
        if(current.getChildren().size() == 0 ) {
            for (int j = 0; j < N; j++) {
                int[][] copy_of_current = cloneArray(data);
                if (check(copy_of_current, next, j)) {
                    copy_of_current[next][j] = 1;
                    current.addChild(copy_of_current);
                }
            }
        } else {
            current.getChildren().remove(0);
        }

        if(current.getChildren().size() > 0) {
            next++;
            if(next < N) {
                MyTreeNode child = (MyTreeNode) current.getChildren().get(0);
                return placeNext(child, next);
            } else {
                System.out.println("Number of recurrent calls made: " + counter);
                return (int[][])((MyTreeNode) current.getChildren().get(0)).getData();
            }
        } else {
            return placeNext(current.getParent(), next-1);
        }
    }

    private boolean forsee(int[][] data, int next) {
        for(int i = next; i < N; i++) {
            int options = 0;
            for(int j = 0; j < N; j++) {
                options += check(data, i, j) ? 1 : 0;
            }
            if(options == 0) return false;
        }
        return true;
    }

    @Override
    public int[][] placeNext(MyTreeNode current, int next, int v) {
        return placeNext(current, next);
    }

    private boolean check(int[][] data, int x, int y) {
        for(int i = 0; i < N; i++) {
            if(data[x][i] == 1 || data[i][y] == 1
                    || x+i < N && y+i < N && data[x + i][y + i] == 1 ||  x-i >= 0 && y-i >= 0 && data[x - i][y - i] == 1
                    ||  x+i < N && y-i > 0 && data[x+i][y-i] == 1 || x-i > 0 && y+i < N && data[x-i][y+i] == 1)
                return false;
        }
        return true;
    }

    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
}
