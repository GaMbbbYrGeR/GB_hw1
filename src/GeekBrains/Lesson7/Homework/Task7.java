package GeekBrains.Lesson7.Homework;

public class Task7 {
    public static void main(String[] args) {
        Cat[] cat = {
                new Cat("Murzik"),
                new Cat("Barsik"),
                new Cat("Tom"),
                new Cat("Tucha"),
                new Cat("Vitya"),
                new Cat("Fufik"),
            };

        Plate plate = new Plate(100);
        cat[0].eat(plate, 10);
        cat[1].eat(plate, 13);
        cat[2].eat(plate, 20);
        cat[3].eat(plate, 7);
        cat[4].eat(plate, 25);
        plate.info();
        for (int i = 0; i < cat.length; i++) {
            cat[i].getFullOrNotCat();
        }
        plate.addEat(20);
        plate.info();
        cat[3].eat(plate,30);
        cat[5].eat(plate, 20);
        plate.addEat(30);
        plate.info();
        cat[5].eat(plate, 30);
        cat[5].getFullOrNotCat();
    }
}
