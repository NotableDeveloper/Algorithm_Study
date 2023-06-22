package Advanced;

import Advanced.Chap01.Chap01_01;
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
}
