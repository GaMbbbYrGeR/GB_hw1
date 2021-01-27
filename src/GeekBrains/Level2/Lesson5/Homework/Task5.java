package GeekBrains.Level2.Lesson5.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Task5 {

    static ArrayList<float[]> cutArray = new ArrayList<>();
    static ArrayList<Thread> threads  = new ArrayList<>();
    static long startTime;
    static final int size = 10000000;
    static float[] array = new float[size];
    static final int numOfThreads = 5;
    static int pieceOfSize;
    static int position;

    public static void main(String[] args) {
        singleThread(null);
        multiThread(null);
    }

    public static void singleThread(String[] args) {
        Arrays.fill(array, 1);
        startTime = System.currentTimeMillis();
        fillFirstArray();
        System.out.println("Single thread: " + (System.currentTimeMillis() - startTime));
    }

    public static void multiThread(String[] args) {

        Arrays.fill(array, 1);

        startTime = System.currentTimeMillis();

        cutArrays();
        calculate();
        mergeArrays();

        System.out.println("Multi thread: " + (System.currentTimeMillis() - startTime));
    }

    private static void calculate() {
        int position = 0;
        for(float[] piece : cutArray){
            int chunkPosition = position;
            position += piece.length;
            Thread t = new Thread(() -> fillSecondArray(piece, chunkPosition));
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads ) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void cutArrays() {
        pieceOfSize = array.length / numOfThreads ;

        for(int i = 0; i < array.length; i += pieceOfSize) {
            cutArray.add(Arrays.copyOfRange(array, i, i + pieceOfSize));
        }

    }

    private static void mergeArrays() {
        position = 0;
        for(float[] chunk : cutArray) {
            System.arraycopy(chunk, 0, array, position,chunk.length);
            position += chunk.length;
        }
    }

    private static void fillFirstArray() {
        for(int i = 0; i < array.length; i++) {
            array[i] = calculateValue(i);
        }
    }

    private static void fillSecondArray(float[] arr, int startPosition) {
        for(int i = 0, j = startPosition ; i < arr.length; i++, j++) {
            arr[i] = calculateValue(j);
        }
    }

    private static float calculateValue ( int i) {
        return (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
