import Chap03.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chap03Test {
    @Test
    void Problem01(){
        int n = 3, m = 5;
        int[] arr1 = {1, 3, 5}, arr2 = {2, 3, 6, 7, 9};
        int[] answer = Chap03_01.solution(n, arr1, m, arr2);

        Assertions.assertArrayEquals(new int[]{1, 2, 3, 3, 5, 6, 7, 9}, answer);
    }

    @Test
    void Problem02(){
        int n = 5, m = 5;
        int[] arr1 = {1, 3, 9, 5, 2}, arr2 = {3, 2, 5, 7, 8};
        int[] answer = Chap03_02.solution(n, arr1, m, arr2);

        Assertions.assertArrayEquals(new int[]{2, 3, 5}, answer);
    }
}
