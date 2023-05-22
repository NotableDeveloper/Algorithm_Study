package Chap10;

public class Brick implements Comparable<Brick>{
    int width;
    int height;
    int weight;
    public Brick(int width, int height, int weight) {
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    /*
        넓이 중심으로 내림차순 정렬한다.
     */
    @Override
    public int compareTo(Brick brick) {
        return brick.width - this.width;
    }
}
