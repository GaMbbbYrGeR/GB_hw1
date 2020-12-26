package GeekBrains.Level2.Lesson1.Homework;

public class Cat implements Participants {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean flag = true;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void run(int trackLength) {
        if(flag) {
            if (runLimit >= trackLength) {
                System.out.println(name + " пробежал дистанцию");
            } else {
                System.out.println(name + " не смог пробежать дистанцию и выбывает");
                flag = false;
            }
        }
    }

    @Override
    public void jump(int wallHigh) {
        if(flag) {
            if (jumpLimit >= wallHigh) {
                System.out.println(name + " перепрыгнул стену");
            } else {
                System.out.println(name + " не смог перепрыгнуть стену и выбывает");
                flag = false;
            }
        }
    }
}
