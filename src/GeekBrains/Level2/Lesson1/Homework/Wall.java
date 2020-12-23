package GeekBrains.Level2.Lesson1.Homework;

public class Wall implements Barriers{
    private static int wallHigh;

    public Wall(int wallHigh) {
        this.wallHigh = wallHigh;
    }

    @Override
    public void moveOverBarrier(Participants P) {
        P.jump(wallHigh);
    }
}
