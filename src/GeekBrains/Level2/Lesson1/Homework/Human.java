package GeekBrains.Level2.Lesson1.Homework;

public class Human implements Participants {
    private static String name;
    private static int runLimit;
    private static int jumpLimit;
    private static boolean flag = true;


    public Human(String name, int runLimit, int jumpLimit) {
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
            if (jumpLimit > wallHigh) {
                System.out.println(name + " перепрыгнул стену");
            } else {
                System.out.println(name + " не смог перепрыгнуть стену и выбывает");
                flag = false;
            }
        }
    }
}
