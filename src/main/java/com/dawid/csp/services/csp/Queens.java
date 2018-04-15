package com.dawid.csp.services.csp;

import com.dawid.csp.app.App;
import com.dawid.csp.services.utils.MyTreeNode;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("q")
public class Queens implements IProblem {

    private final static int N = 8;
    public static int counter = 0;

    public Queens() { }

    @Override
    public int[][] placeNext(MyTreeNode current, int next) {

        counter++;
        int[][] data = (int[][]) current.getData();

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


    private boolean check(int[][] data, int x, int y) {
        for(int i = 0; i < N; i++) {
            if(data[x][i] == 1) return false;
            if(data[i][y] == 1) return false;
            if(x+i < N && y+i < N && data[x + i][y + i] == 1) return false;
            if(x-i >= 0 && y-i >= 0 && data[x - i][y - i] == 1) return false;
            if(x+i < N && y-i > 0 && data[x+i][y-i] == 1) return false;
            if(x-i > 0 && y+i < N && data[x-i][y+i] == 1) return false;
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
    /*
     if(unavailable[current_row][j] == 1) continue;
            current[current_row][j] = 1;
            mark(current_row, j);
            current_row++;
            placeNext(current, 1);
     */


}
