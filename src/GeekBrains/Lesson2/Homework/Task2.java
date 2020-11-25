package GeekBrains.Lesson2.Homework;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr;
        arr = makeRandomArr(n);
        System.out.println(Arrays.toString(arr));
        changeArr(arr);
        System.out.println(Arrays.toString(arr) + "\n");

        int[] arr2 = new int[8];
        fullEmptyArr(arr2);
        System.out.println(Arrays.toString(arr2) + "\n");

        int[] arr3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeSomeElementsInArr(arr3);
        System.out.println(Arrays.toString(arr3) + "\n");

        int arrSize = 7;
        int[][] arr4 = new int[arrSize][arrSize];
        fullDiagonalOfArr(arr4, arrSize);
        printArr2Dv2(arr4);
        System.out.println();

        int[] arr5 = new int[] {1, 8, 356, 98, 3, 8, 35, 32, -75, -9, 0, -752};
        int maxElement = getMaxElement(arr5);
        int minElement = getMinElement(arr5);
        System.out.printf("%d - максимальный элемент массива; %d - минимальный элемент массива  + \n", maxElement, minElement);

        int[] arr6 = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        boolean checkBalanceRez = checkBalance(arr6);
        System.out.println(Arrays.toString(arr6));
        System.out.println(checkBalanceRez + "\n");

        int[] arr7 = new int[]{1, 2, 3, 4, 5, 6};
        int step = 0;
        moveArr(arr7, step);
        System.out.println(Arrays.toString(arr7));
    }

    public static int[] makeRandomArr (int n) {
        int [] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2);
        }
        return arr;
    }

    public static void changeArr (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void fullEmptyArr(int[] arr) {
        for (int i = 0; i < 8; i++) {
            arr[i] = i * 3;
        }
    }

    public static void changeSomeElementsInArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

    }

    public static void fullDiagonalOfArr(int[][] arr, int arrSize){
        for (int i = 0; i < arrSize; i++) {
            arr[i][i] = 1;
            arr[i][arrSize-i-1] = 1;
        }

    }

    public static void printArr2Dv2(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int getMaxElement(int[] arr){
        int maxElement = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if (maxElement < arr[i]){
                maxElement = arr[i];
            }
        }
        return maxElement;
    }

    public static int getMinElement(int[] arr){
        int minElement = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if (minElement > arr[i]){
                minElement = arr[i];
            }
        }
        return minElement;
    }

    public static boolean checkBalance(int[] arr){
        int i = 0, j = arr.length;
        int sum1 = 0, sum2 = 0;
        while (i != j){
            if (sum1 <= sum2){
                sum1 += arr[i++];
            } else {
                sum2 += arr[--j];
            }
        }
        return (sum1 == sum2);
    }

    public static void moveArr (int[] arr, int step){
        int tmp;
        step %= arr.length;
        boolean flag = true;
        if(step < 0){
            step *= -1;
            flag = false;
        }
        for (int i = 0; i < step; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(flag) {
                    tmp = arr[0];
                    arr[0] = arr[j + 1];
                    arr[j + 1] = tmp;
                } else {
                    tmp = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[arr.length - j - 2];
                    arr[arr.length - j - 2] = tmp;
                }
            }
        }

    }


}
