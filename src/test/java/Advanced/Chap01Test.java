package Advanced;

import Advanced.Chap01.*;
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

    @Test
    void Problem05(){
        Assertions.assertEquals(5, Chap01_05.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        Assertions.assertEquals(8, Chap01_05.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        Assertions.assertEquals(6, Chap01_05.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        Assertions.assertEquals(5, Chap01_05.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }

    @Test
    void Problem06(){
        ArrayList<int[][]> fruits = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();

        answers.add(58);
        answers.add(24);
        answers.add(32);

        fruits.add(new int[][]{
                {10, 20, 30},
                {12, 15, 20},
                {20, 12, 15},
                {15, 20, 10},
                {10, 15, 10}});

        fruits.add(new int[][]{
                {10, 9, 11},
                {15, 20, 25}});

        fruits.add(new int[][]{
                {0, 3, 27},
                {20, 5, 5},
                {19, 5, 6},
                {10, 10, 10},
                {15, 10, 5},
                {3, 7, 20}});

        for(int i = 0; i < answers.size(); i++){
            int[][] fruit = fruits.get(i);
            int answer = answers.get(i);

            Assertions.assertEquals(answer, Chap01_06.solution(fruit));
        }

    }

    @Test
    void Problem07(){
        Assertions.assertEquals(8,
                Chap01_07.solution(
                    new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8},
                    "7596218")
        );

        Assertions.assertEquals(12,
                Chap01_07.solution(
                        new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6},
                        "63855526592")
        );

        Assertions.assertEquals(13,
                Chap01_07.solution(
                        new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1},
                        "323254677")
        );

        Assertions.assertEquals(8,
                Chap01_07.solution(
                        new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2},
                        "3337772122")
        );
    }

    @Test
    void Problem08(){
        Assertions.assertArrayEquals(new int[]{3, 1, 2, 2},
                Chap01_08.solution(new int[]{1, 2, 3, 4},
                        new int[]{2, 4, 1, 3}));

        Assertions.assertArrayEquals(new int[]{3, 1, 2, 1, 3},
                Chap01_08.solution(new int[]{1, 2, 5, 3, 4},
                        new int[]{2, 3, 1, 4, 5}));

        Assertions.assertArrayEquals(new int[]{6, 2, 2, 4, 2, 3, 4, 1},
                Chap01_08.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8},
                        new int[]{2, 3, 5, 6, 1, 4, 8, 7}));
    }
}
