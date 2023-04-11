import Chap07.Chap07_01;
import Chap07.Chap07_02;
import Chap07.Chap07_03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Chap07Test {
    static ByteArrayOutputStream outputStream;
    static String output;

    @BeforeEach
    void setUp(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    static void getOutput(){
        output = outputStream.toString();
    }

    @Test
    void Problem01(){
        int n = 3;
        Chap07_01.solution(n);
        getOutput();
        Assertions.assertEquals("1 2 3 ", output);
    }

    @Test
    void Problem02(){
        int n = 11;
        Chap07_02.solution(n);
        getOutput();
        Assertions.assertEquals("1011", output);
    }

    @Test
    void Problem03(){
        int n = 5;
        int answer = Chap07_03.solution(n);
        Assertions.assertEquals(120, answer);
    }

    @Test
    void Problem04(){
        int n = 10;
        Chap07_04.solution(n);
        getOutput();
        Assertions.assertEquals("1 1 2 3 5 8 13 21 34 55 ", output);
    }
}
