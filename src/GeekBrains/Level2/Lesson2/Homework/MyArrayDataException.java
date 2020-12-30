package GeekBrains.Level2.Lesson2.Homework;

public class MyArrayDataException extends NumberFormatException {
    private String n;

    public String getN() {
        return n;
    }

    public MyArrayDataException(String n) {
        this.n = n;
    }

    public MyArrayDataException(String s, String n) {
        super(s);
        this.n = n;
    }
}
