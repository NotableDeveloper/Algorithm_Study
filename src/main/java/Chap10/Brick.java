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

    @Override
    public int compareTo(Brick brick) {
        return brick.width - this.width;
    }
}
