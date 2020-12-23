package GeekBrains.Level1.Lesson6.Homework.Animals;

public class Dog extends Animal{

    static int countOfDogs = 0;

    public int getCountOfDogs() {
        return countOfDogs;
    }

    public Dog(String name){
        super(name);
        countOfDogs++;
    }

    @Override
    public void run(int distance) {
        if(distance > 500) {
            System.out.println(name + " пробежал 500 м.");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    @Override
    public void sweem(int distance) {
        if(distance > 10) {
            System.out.println(name + " проплыл 10 метров");
        } else {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
}
