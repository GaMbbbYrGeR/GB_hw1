package GeekBrains.Level3.Lesson1.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Box<Apple> box = new Box<Apple>();
        Box<Apple> box2 = new Box<Apple>();
        Box<Orange> box1 = new Box<Orange>();
        Apple greenApple = new Apple("green apple");
        Orange redOrange = new Orange("red orange");

        box.addFruit(greenApple, 3);
        box2.addFruit(greenApple, 5);
        box1.addFruit(redOrange, 2);

        System.out.println(box);
        System.out.println(box2);
        System.out.println(box1);

        System.out.println(box.compare(box1));
        System.out.println(box.compare(box2));

        box.moveFruitsToOtherBox(box2);

        System.out.println(box);
        System.out.println(box2);
    }

    private static <T> void swapTwoElements(List<T> arr, int i, int j) {
        T t;
        t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t);
    }

    private static <T> List<T> convertListToArrayList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }
}
