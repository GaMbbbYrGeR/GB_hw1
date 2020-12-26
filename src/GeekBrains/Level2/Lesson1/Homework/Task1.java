package GeekBrains.Level2.Lesson1.Homework;

public class Task1 {
    public static void main(String[] args) {
        Participants[] participants = {
                new Cat("Мурзик", 1000, 150),
                new Robot("R2D2", 50000, 20),
                new Human("Кирилл", 5000, 100)
        };

        Barriers[] barriers = {
                new Track(1000),
                new Wall(10),
                new Track(2000),
                new Wall(20),
                new Track(4000),
        };

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                barriers[j].moveOverBarrier(participants[i]);
            }
        }
    }
}
