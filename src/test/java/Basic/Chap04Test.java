package Basic;

import Basic.Chap04.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Chap04Test {
    @Test
    void Problem01(){
        String input = "BACBACCACCBDEDE";
        char answer = Chap04_01.solution(input);
        Assertions.assertEquals('C', answer);
    }

    @Test
    void Problem02(){
        Assertions.assertEquals("YES", Chap04_02.solution("AbaAeCe", "baeeACA"));
        Assertions.assertEquals("NO", Chap04_02.solution("abaCC", "Caaab"));
    }

    @Test
    void Problem03(){
        int[] sales = {20, 12, 20, 10, 23, 17, 10};
        Assertions.assertEquals(List.of(3, 4, 4, 3), Chap04_03.solution(7, 4, sales));
    }

    @Test
    void Problem04(){
        Assertions.assertEquals(3,
                Chap04_04.solution("bacaAacba", "abc"));
        Assertions.assertEquals(3,
                Chap04_04.solution("bacaAacbaa", "abca"));
    }

    @Test
    void Problem05(){
        int[] arr = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};
        Assertions.assertEquals(143, Chap04_05.solution(arr, 10, 3));
    }
}
