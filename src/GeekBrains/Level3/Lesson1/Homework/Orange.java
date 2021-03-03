package GeekBrains.Level3.Lesson1.Homework;

public class Orange extends Fruits{

    private static float weight = 1.5f;
    private static String sort;

    public Orange(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }

    public float getWeight() {
        return weight;
    }
}
