import Chap10.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Chap10Test {
    @Test
    void Problem01(){
        int n = 7;
        int answer = Chap10_01.solution(n);
        Assertions.assertEquals(21, answer);
    }

    @Test
    void Problem02(){
        int n = 7;
        int answer = Chap10_02.solution(n);
        Assertions.assertEquals(34, answer);
    }

    @Test
    void Problem03(){
        int n = 8;
        int[] arr = {5, 3, 7, 8, 6, 2, 9, 4};
        int answer = Chap10_03.solution(n, arr);
        Assertions.assertEquals(4, answer);
    }

    @Test
    void Problem04(){
        int n = 5;
        ArrayList<Brick> bricks = new ArrayList<Brick>();

        bricks.add(new Brick(25, 3, 4));
        bricks.add(new Brick(4, 4, 6));
        bricks.add(new Brick(9, 2, 3));
        bricks.add(new Brick(16, 2, 5));
        bricks.add(new Brick(1, 5, 2));

        int answer = Chap10_04.solution(n, bricks);
        Assertions.assertEquals(10, answer);
    }

    @Test
    void Problem05(){
        int n = 3;
        int[] coin = {1, 2, 5};
        int money = 15;

        int answer = Chap10_05.solution(n, coin, money);
        Assertions.assertEquals(3, answer);
    }
}
