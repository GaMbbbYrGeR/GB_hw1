package GeekBrains.Level1.Lesson3.Homework;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    static Scanner PRINT = new Scanner(System.in);
    static Random RANDOM = new Random();
    static String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
            "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        String numberOfGame = PRINT.nextLine();
        if(numberOfGame.equals("game 1")) {
            playGameGuessNumber();
        } else {
            if(numberOfGame.equals("game 2")) {
                playGameGuessWord();
            }
        }
    }

    public static int getRandomNumber() {
        return RANDOM.nextInt(10);
    }

    public static String getRandomWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public static void playGameGuessNumber() {
        int findNumber = getRandomNumber(), i = 0;
        while (i < 3) {
            int nextNumber = PRINT.nextInt();
            if(nextNumber > findNumber) {
                System.out.println("Число " + nextNumber + " больше загаданного");
            } else {
                if (nextNumber < findNumber) {
                    System.out.println("Число " + nextNumber + " меньше загаданного");
                } else {
                    System.out.println("Поздравляем, вы победили :)");
                    break;
                }
            }
            i++;
        }
        if(i == 3) {
            System.out.println("Вы проиграли :(");
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        byte choice = PRINT.nextByte();
        if(choice == 1) {
            playGameGuessNumber();
        } else {
            System.out.println("До встречи !");
        }
    }

    public static void playGameGuessWord() {
        String findWord = getRandomWord();
        char[] resultString = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        int count = 0;
        boolean flag = true;
        while(flag) {
            String nextWord = PRINT.nextLine();
            if(findWord.length() > nextWord.length()) {
                for (int i = 0; i < nextWord.length(); i++) {
                    if(findWord.charAt(i) == nextWord.charAt(i)) {
                        resultString[i] = findWord.charAt(i);
                        count++;
                    }
                }
            } else {
                for (int i = 0; i < findWord.length(); i++) {
                    if(findWord.charAt(i) == nextWord.charAt(i)) {
                        resultString[i] = findWord.charAt(i);
                        count++;
                    }
                }
            }
            if(count == findWord.length()) {
                System.out.println("Вы угадали слово:");
                System.out.println(findWord);
                flag = false;
            } else {
                if(nextWord.length() != 0) {
                    System.out.println("Неправильное слово:");
                    System.out.println(resultString);
                    count = 0;
                }
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        byte choice = PRINT.nextByte();
        if(choice == 1) {
            playGameGuessWord();
        } else {
            System.out.println("До встречи !");
        }
    }
}
