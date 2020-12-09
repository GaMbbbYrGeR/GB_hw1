package GeekBrains.Lesson6.Homework.Animals;

public class Cat extends Animal{

    static int countOfCats = 0;

    public int getCountOfCats() {
        return countOfCats;
    }

    public Cat(String name){
        super(name);
        countOfCats++;
    }

    @Override
    public void run(int distance) {
        if(distance > 200) {
            System.out.println(name + " пробежал 200 м.");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    @Override
    public void sweem(int distance) {
        System.out.println("Коты не умеют плавать." + name + " не исключение!");
    }
}
