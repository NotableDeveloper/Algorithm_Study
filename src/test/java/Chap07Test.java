import Chap07.Chap07_01;
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

    @Test
    void Problem01(){
        int n = 3;
        Chap07_01.solution(n);
        output = outputStream.toString();
        Assertions.assertEquals("1 2 3\n", output);
    }
}
