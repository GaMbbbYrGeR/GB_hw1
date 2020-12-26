package GeekBrains.Level2.Lesson2.Homework;

public class Task2 {
    public static void main(String[] args) {

        String[][] arr = {
                {"123", "3", "312", "1"},
                {"123", "3", "7", "0"},
                {"123", "3", "23", "2131"},
                {"123", "3", "789", "-45"},

        };

        String[][] arr1 = {
                {"123", "3"},
                {"123", "3", "7"},
                {"123", "3"},
                {"123", "3", "789"},
        };

        String[][] arr2 = {
                {"123", "ffsdf"},
                {"123", "3", "7"},
        };

        try {
            sumOfElements(arr);
            sumOfElements(arr1);
            sumOfElements(arr2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumOfElements(String[][] arr) throws  MyArraySizeException, MyArrayDataException{
        int sum = 0;
        if(arr.length != 4) {
            throw new MyArraySizeException("Не корректное кол-во строк в массиве: " + arr.length, arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i].length != 4) {
                    throw new MyArraySizeException("Не корректное кол-во элементов в строке " + i + ": " + arr[i].length, arr[i].length);
                }
                try {
                    sum = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный формат строки в ячейке arr[" + i + "][" + j + "]", arr[i][j]);
                }
            }
        }
        return sum;
    }
}
