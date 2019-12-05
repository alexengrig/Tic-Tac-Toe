package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        printFiled(chars);
    }

    public static void printFiled(char[] values) {
        int length = values.length;
        int size = (int) Math.sqrt(length);
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.print("\n| ");
        for (int i = 0; i < length; i++) {
            if (i >= size && i % size == 0) {
                System.out.print("|\n| ");
            }
            System.out.print(values[i] + " ");
        }
        System.out.println("|");
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
    }
}
