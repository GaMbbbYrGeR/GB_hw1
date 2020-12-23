package GeekBrains.Level1.Lesson6.Homework.Animals;

public class Animal {

    String name;
    static int countOfAnimals = 0;

    public int getCountOfAnimals() {
        return countOfAnimals;
    }

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
        countOfAnimals++;
    }

    void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    void sweem(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
}
