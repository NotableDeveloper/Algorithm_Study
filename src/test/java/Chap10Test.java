import Chap10.Chap10_01;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
