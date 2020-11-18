package GeekBrains.Lesson1.Homework1;

public class Task {
    public static void main(String[] args) {

        byte byteElement = 127;
        short shortElement = -6789;
        int intElement = 567570;
        long longElement = -45769078098L;

        float floatElement = -578.567769f;
        double doubleElement = 89808.676968070;

        boolean booleanElement = true;

        char charElement = 'C';
        String stringElement = "Всем привет в этом чатике";

        System.out.println(byteElement);
        System.out.println(shortElement);
        System.out.println(intElement);
        System.out.println(longElement);
        System.out.println(floatElement);
        System.out.println(doubleElement);
        System.out.println(booleanElement);
        System.out.println(charElement);
        System.out.println(stringElement);

        System.out.println(count(1, 2, 3, 4));
        System.out.println(isSumInInterval(10, 10));
        printPositiveOrNegative(0);
        System.out.println(isPositiveOrNegative(-14));
        printName("Кирилл");
        printHighYearOrNot(2001);

    }

    public static float count (float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }

    public static boolean isSumInInterval (int a, int b) {
        return (((a + b) >= 10) && ((a + b) <= 20));

    }

    public static void printPositiveOrNegative (int i) {
        if (i >= 0) {
            System.out.println( i + " - положительное");
        } else {
            System.out.println( i + " - отрицательное");
        }
    }

    public static boolean isPositiveOrNegative (int i) {
        return !(i >= 0);
    }

    public static void printName (String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void printHighYearOrNot (int year) {
        if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
            System.out.println( year + " - високосный год");
        } else {
            System.out.println( year + " год не является високосным");
        }

    }


}
