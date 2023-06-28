package Basic;

import Basic.Chap04.Chap04_01;
import Basic.Chap04.Chap04_02;
import Basic.Chap04.Chap04_03;
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
}
