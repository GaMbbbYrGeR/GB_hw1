package GeekBrains.Level2.Lesson1.Homework;

public class Track implements Barriers{
    private int trackLength;

    public Track(int trackLength) {
        this.trackLength = trackLength;
    }

    @Override
    public void moveOverBarrier(Participants P) {
        P.run(trackLength);
    }
}
