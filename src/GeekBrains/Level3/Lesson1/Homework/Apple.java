package GeekBrains.Level3.Lesson1.Homework;

public class Apple extends Fruits{

    private static float weight = 1.0f;
    private static String sort;

    public Apple(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }

    public float getWeight() {
        return weight;
    }
}
