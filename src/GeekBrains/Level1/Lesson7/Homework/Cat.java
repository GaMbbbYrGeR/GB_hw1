package GeekBrains.Level1.Lesson7.Homework;

public class Cat {
    private String name;
    private int amountOfEat;
    private boolean fullCatFlag = false;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getFullOrNotCat() {
        if(fullCatFlag){
            System.out.println("Кот " + name + " сыт");
        } else {
            System.out.println("Кот " + name + " голоден");
        }
    }

    public void eat(Plate plate, int amountOfEat) {
        if(plate.decreaseFood(amountOfEat)){
            System.out.println("cat " + name + " eat...");
            fullCatFlag = true;
        } else {
            System.out.println("Мало еды в тарелке для " + name + " :(");
        }
    }

}
