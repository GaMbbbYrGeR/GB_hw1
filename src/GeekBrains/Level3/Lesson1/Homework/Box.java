package GeekBrains.Level3.Lesson1.Homework;

import java.util.ArrayList;

public class Box <T extends Fruits>{

    private ArrayList<T> box = new ArrayList<T>();

    public ArrayList<T> getBox() {
        return box;
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            boxWeight += box.get(i).getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<? extends Fruits> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.000001;
    }

    public void addFruit(T fruit, int count) {
        for (int i = 0; i < count; i++) {
            box.add(fruit);
        }
    }

    public void moveFruitsToOtherBox(Box<T> box) {
        if(this.box.get(0) != null) {
            box.addFruit(this.box.get(0), this.box.size());
        }
        this.box.removeAll(this.box);
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < box.size() - 1; i++) {
            str += box.get(i).getSort() + " ,";
        }
        if(!str.equals("[")) {
            str += box.get(box.size() - 1).getSort() + "]";
        } else {
            str += "]";
        }
        return str;
    }
}
