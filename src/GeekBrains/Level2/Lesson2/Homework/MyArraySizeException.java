package GeekBrains.Level2.Lesson2.Homework;

public class MyArraySizeException extends IllegalArgumentException {
    private int n;

    public int getN() {
        return n;
    }

    public MyArraySizeException(int n) {
        this.n = n;
    }

    public MyArraySizeException(String s, int n) {
        super(s);
        this.n = n;
    }
}
