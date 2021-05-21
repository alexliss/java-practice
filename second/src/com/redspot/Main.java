package com.redspot;

public class Main {

    // for tests
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static void printArray(int[][] array) {
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 1
    public static int[] reverseBinaryArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    // 2
    public static int[] generateArrayBy3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        return array;
    }

    // 3
    public static int[] ifLessThan6MultiplyBy2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        return array;
    }

    // 5
    public static int maxNum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }

    public static int minNum(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i])
                min = array[i];
        }
        return min;
    }

    // 6
    public static boolean checkBalance(int[] array) {
        // "разделитель" сначала находится перед нулевым элементом
        int sumBegin = 0; // сумма элементов с начала массива по "разделитель"
        int sumEnd = 0; // сумма элементов массива с конца по "разделитель"
        for (int element : array) {
            sumEnd += element;
        }
        for (int element : array) {
            sumBegin += element;
            sumEnd -= element;
            if (sumBegin == sumEnd) {
                return true;
            }
        }
        return false;
    }

    // 7
    public static int[] moveElements(int[] array, int shift) { //.....Press F to pay respect.....
        boolean isNegative = shift < 0;
        for (int j = 0; j < Math.abs(shift); j++) {
            if (isNegative) {
                for (int i = 1; i < array.length; i++) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            } else {
                for (int i = array.length - 2; i >= 0; i--) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {

        // 1
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10 % 2);
        }
        printArray(array);
        printArray(reverseBinaryArray(array));

        // 2
        array = new int[8];
        printArray(generateArrayBy3(array));

        // 3
        array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array);
        printArray(ifLessThan6MultiplyBy2(array));

        // 4
        int[][] mArray = new int[11][11]; // m - multidimensional
        for (int i = 0; i < mArray.length; i++) {
            for (int j = 0; j < mArray[i].length; j++) {
                if (i == j || i + j == mArray.length - 1) {
                    mArray[i][j] = 1;
                } else mArray[i][j] = 0;
            }
        }
        printArray(mArray);

        // 5
        array = new int[]{1, 5, 3, 2, 11, 4, -5, 2, 4, 8, 9, 1};
        printArray(array);
        System.out.println("max: " + maxNum(array) + "\nmin: " + minNum(array));

        // 6
        array = new int[]{1, 2, 3, 5};
        printArray(array);
        System.out.println(checkBalance(array));
        array = new int[]{8, 2, 5, 3, 2};
        System.out.println(checkBalance(array));

        // 7
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        printArray(moveElements(array, -7));
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        printArray(moveElements(array, 3));

    }
}