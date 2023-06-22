package Basic;

import Basic.Chap01.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chap01Test {
    @Test
    void problem01(){
        int answer = Chap01_01.solution("Computercooler", 'c');
        Assertions.assertEquals(2, answer);
    }

    @Test
    void problem02(){
        String answer = Chap01_02.solution("StuDY");
        Assertions.assertEquals("sTUdy", answer);

        answer = Chap01_02.solution2("StuDY");
        Assertions.assertEquals("sTUdy", answer);
    }

    @Test
    void problem03(){
        String answer = Chap01_03.solution("it is time to study");
        Assertions.assertEquals("study", answer);

        answer = Chap01_03.solution("banana java monkey");
        Assertions.assertEquals("banana", answer);
    }

    @Test
    void problem04(){
        String[] input = {"good", "Time", "Big"};
        String[] answer = Chap01_04.solution(3, input);
        Assertions.assertArrayEquals(new String[]{"doog", "emiT", "giB"}, answer);
    }

    @Test
    void problem05(){
        String answer = Chap01_05.solution("a#b!GE*T@S");
        Assertions.assertEquals("S#T!EG*b@a", answer);

        answer = Chap01_05.solution("a@xzq%t");
        Assertions.assertEquals("t@qzx%a", answer);
    }

    @Test
    void problem06(){
        String answer = Chap01_06.solution("ksekkset");
        Assertions.assertEquals("kset", answer);

        answer = Chap01_06.solution("abcaabtk");
        Assertions.assertEquals("abctk", answer);
    }

    @Test
    void problem07(){
        String answer = Chap01_07.solution("gooG");
        Assertions.assertEquals("YES", answer);

        answer = Chap01_07.solution("AbcD");
        Assertions.assertEquals("NO", answer);
    }

    @Test
    void problem08(){
        String answer = Chap01_08.solution("found7, time: study; Yduts; emit, 7Dnuof");
        Assertions.assertEquals("YES", answer);

        answer = Chap01_08.solution("time: study; Yduts; abcd");
        Assertions.assertEquals("NO", answer);
    }


    @Test
    void problem09(){
        int answer = Chap01_09.solution("g0en2T0s8eSoft");
        Assertions.assertEquals(208, answer);
    }

    @Test
    void problem10(){
        int[] answer = Chap01_10.solution("teachermode", 'e');
        Assertions.assertArrayEquals(new int[]{1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0}, answer);
    }

    @Test
    void problem11(){
        String answer = Chap01_11.solution("KKHSSSSSSSE");
        Assertions.assertEquals("K2HS7E", answer);
    }

    @Test
    void problem12(){
        String answer = Chap01_12.solution(4, "#****###**#####**#####**##**");
        Assertions.assertEquals("COOL", answer);
    }
}
