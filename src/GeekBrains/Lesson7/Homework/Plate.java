package GeekBrains.Lesson7.Homework;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addEat(int amountToAdd) {
        food += amountToAdd;
    }

    public boolean decreaseFood(int amount) {
        if (amount < 0 || food < amount) {
            return false;
        } else {
            food -= amount;
            return true;
        }
    }

    public void info() {
        System.out.println("Food: " + food);
    }
}
