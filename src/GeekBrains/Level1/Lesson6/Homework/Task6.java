package GeekBrains.Level1.Lesson6.Homework;

import GeekBrains.Level1.Lesson6.Homework.Animals.*;

public class Task6 {
    public static void main(String[] args) {
        Cat catTucha = new Cat("Tucha");
        Cat catMeow = new Cat("Meow");
        Dog dogGav = new Dog("Gav");
        Dog dogBobik = new Dog("Bobik");

        catTucha.run(147);
        dogGav.run(470);
        catMeow.run(240);
        dogBobik.run(730);

        catTucha.sweem(23);
        dogGav.sweem(9);
        dogBobik.sweem(20);

        System.out.println(catMeow.getCountOfCats());
        System.out.println(dogGav.getCountOfDogs());
        System.out.println(catTucha.getCountOfAnimals());
    }
}
