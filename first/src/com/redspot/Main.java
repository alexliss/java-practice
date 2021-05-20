package com.redspot;

import java.util.Scanner;

public class Main {

    // 3
    public static float someCalculations(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // 4
    public static boolean isFrom10to20(int num) {
        return num >= 10 && num <= 20;
    }

    public static boolean isFrom10to20(float num) {
        return num >= 10 && num <= 20;
    }

    // 5
    public static void writeIsNumberNegative(int num) {
        if (isNumberNegative(num)) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is positive");
        }
    }

    public static void writeIsNumberNegative(float num) {
        if (isNumberNegative(num)) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is positive");
        }
    }

    // 6
    public static boolean isNumberNegative(int num) {
        return num < 0;
    }

    public static boolean isNumberNegative(float num) {
        return num < 0;
    }

    // 7
    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // 8
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && !(year % 100 == 0)) || year % 400 == 0;
    }

    // 1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2
        byte b = 120;
        short sh = 327;
        char ch = 'ы';
        int i = 300045;
        long l = 34568L;
        float f = -3.141437830f;
        double d = 345.347194801277868976473478363;

        // tests
        // 2
        System.out.println("byte: " + b + "\nshort: " + sh + "\nchar: " + ch + "\nint: " + i +
                "\nlong: " + l + "\nfloat: " + f + "\ndouble: " + d);

        // 3
        System.out.println("Введите 4 дробных числа (разделитель дробной части - запятая):");
        float float1 = scanner.nextFloat();
        float float2 = scanner.nextFloat();
        float float3 = scanner.nextFloat();
        float float4 = scanner.nextFloat();

        System.out.println("a * (b + (c / d)) = " + someCalculations(float1, float2, float3, float4));

        // 4
        System.out.println(float1 + " is from 10 to 20: " + isFrom10to20(float1));
        System.out.println((int)float1 + " is from 10 to 20: " + isFrom10to20((int)float1));

        // 5 & 6
        System.out.print(float1 + ": ");
        writeIsNumberNegative(float1);
        System.out.print(float2 + ": ");
        writeIsNumberNegative(float2);

        // 7
        System.out.println("Введите имя: ");
        scanner.nextLine(); // после nextFloat пропускается ровно один nextLine, потому что nextFloat передает сюда \n...
        String name = scanner.nextLine();
        greetings(name);

        // 8
        System.out.println("Введите год: ");
        i = scanner.nextInt();
        System.out.println("Високосный ли год " + i + "?... " + isLeapYear(i));
    }
}
