package Advanced;

import Advanced.Chap02.Chap02_01;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chap02Test {
    @Test
    void Problem01(){
        Assertions.assertEquals(3, Chap02_01.solution("statitsics"));
        Assertions.assertEquals(-1, Chap02_01.solution("aabb"));
        Assertions.assertEquals(3, Chap02_01.solution("stringshowtime"));
        Assertions.assertEquals(5, Chap02_01.solution("abcdeabcdfg"));
    }
}
