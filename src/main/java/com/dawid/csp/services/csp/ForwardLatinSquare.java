package com.dawid.csp.services.csp;

import com.dawid.csp.app.App;
import com.dawid.csp.services.utils.MyTreeNode;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@SuppressWarnings("Duplicates")
@Service
@Profile("fLatinSquare")
public class ForwardLatinSquare implements IProblem  {

    final static int N = App.N;
    static int counter = 0;

    public ForwardLatinSquare() {
    }

    @Override
    public int[][] placeNext(MyTreeNode current, int next) {
        return new int[0][0];
    }

    @Override
    public int[][] placeNext(MyTreeNode current, int next, int v_pos) {

        counter++;
        int[][] data = (int[][]) current.getData();


        if(!forsee(data, next, v_pos)) {
            if(v_pos-1 < 0){
                v_pos = 0;
                next -= 1;
            } else {
                v_pos -= 1;
            }
            return placeNext(current.getParent(), next, v_pos);
        }

        if(current.getChildren().size() == 0 ) {
            for(int x = 1; x <= N; x++) {
                int[][] copy_of_current = cloneArray(data);
                if (check(copy_of_current, next, v_pos, x)) {
                    copy_of_current[next][v_pos] = x;
                    current.addChild(copy_of_current);
                }
            }
        } else {
            current.getChildren().remove(0);
        }

        if(current.getChildren().size() > 0) {
            if(v_pos < N-1) {
                v_pos += 1;
            } else {
                v_pos = 0;
                next += 1;
            }

            if(next == N) {
                System.out.println("Number of recurrent calls made: " + counter);
                return (int[][])((MyTreeNode) current.getChildren().get(0)).getData();
            } else {
                MyTreeNode child = (MyTreeNode) current.getChildren().get(0);
                return placeNext(child, next, v_pos);
            }
        } else {
            if(v_pos == 0){
                next -= 1;
                v_pos = N-1;
            } else {
                v_pos -= 1;
            }
            return placeNext(current.getParent(), next, v_pos);
        }
    }

    private boolean check(int[][] data, int x, int y, int number) {
        for(int i = 0; i < N; i++) {
            if(data[x][i] == number || data[i][y] == number) return false;
        }
        return true;
    }

    private boolean forsee(int[][] data, int next, int v_pos) {
        while(next < N && v_pos < N) {
            int options = 0;
            for(int i = 1; i <= N; i++) {
                if(check(data, next, v_pos, i)) {
                    options++;
                    break;
                }
            }
            if(options != 0) {
                v_pos++;
                if(v_pos >= N && next < N-1 ) {
                    v_pos = 0;
                    next++;
                }
            } else {
                return false;
            }
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
