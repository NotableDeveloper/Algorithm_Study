package Advanced;

import Advanced.Chap01.Chap01_01;
import Advanced.Chap01.Chap01_02;
import Advanced.Chap01.Chap01_03;
import Advanced.Chap01.Chap01_04;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;


public class Chap01Test {
    @Test
    void Problem01(){
       HashMap<Integer, int[][]> inputHM = new HashMap();
       HashMap<Integer, char[]> answerHM = new HashMap();

       inputHM.put(5, new int[][]{{1, 3}, {2, 4}, {1, 4}});
       inputHM.put(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}});
       inputHM.put(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}});
       inputHM.put(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}});

       answerHM.put(5, new char[]{'D', 'B', 'A', 'C', 'E'});
       answerHM.put(7, new char[]{'A', 'C', 'B', 'F', 'D', 'G', 'E'});
       answerHM.put(8, new char[]{'C', 'A', 'B', 'F', 'D', 'E', 'H', 'G'});
       answerHM.put(12, new char[]{'C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H'});

       for(int n : answerHM.keySet()){
           int[][] input = inputHM.get(n);
           char[] expected = answerHM.get(n);
           char[] answer = Chap01_01.solutionWithSimulation(n, input);
           Assertions.assertArrayEquals(expected, answer);
       }
    }

    @Test
    void Problem02(){
        int[] array = {10, 25};
        ArrayList<int[][]> inputs = new ArrayList<>();
        ArrayList<int[]> answers = new ArrayList<>();

        inputs.add(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}});


        inputs.add(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}});

        answers.add(new int[]{2, 2});
        answers.add(new int[]{0, 1});

        for(int i = 0; i < answers.size(); i++){
            int k = array[i];
            int[][] board = inputs.get(i);
            int[] answer = Chap01_02.solution(board, k);
            int[] expected = answers.get(i);

            Assertions.assertArrayEquals(expected, answer);
        }
    }

    @Test
    void Problem03() {
        ArrayList<int[][]> inputs = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();

        inputs.add(new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        });

        inputs.add(new int[][]{
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
        });

        answers.add(51);
        answers.add(17);

        for(int i = 0; i < answers.size(); i++){
            int answer = Chap01_03.solution(inputs.get(i));
            Assertions.assertEquals(answers.get(i), answer);
        }
    }

    @Test
    void Problem04(){
        Assertions.assertArrayEquals(new int[]{6, 3}, Chap01_04.solution(6, 5, 12));
        Assertions.assertArrayEquals(new int[]{2, 3}, Chap01_04.solution(6, 5, 20));
        Assertions.assertArrayEquals(new int[]{4, 3}, Chap01_04.solution(6, 5, 30));
        Assertions.assertArrayEquals(new int[]{0, 0}, Chap01_04.solution(6, 5, 31));
    }
}
