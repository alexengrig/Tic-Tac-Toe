package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        printFiled(chars);
        char x = 'X';
        char o = 'O';
        if (win(chars, x)) {
            System.out.println("X wins");
        } else if (win(chars, o)) {
            System.out.println("O wins");
        }
        if (!hasEmpty(chars) && !win(chars, x) && !win(chars, o)) {
            System.out.println("Draw");
        }
        if (hasEmpty(chars) && !win(chars, x) && !win(chars, o)) {
            System.out.println("Game not finished");
        }
        if (win(chars, x) && win(chars, o) || hasDifferenceCount(chars)) {
            System.out.println("Impossible");
        }
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
        System.out.println();
    }

    public static boolean win(char[] values, char value) {
        boolean horizontal = (value == values[0] && value == values[1] && value == values[2])
                ||
                (value == values[3] && value == values[4] && value == values[5])
                ||
                (value == values[6] && value == values[7] && value == values[8]);
        boolean vertical = (value == values[0] && value == values[3] && value == values[6])
                ||
                (value == values[1] && value == values[4] && value == values[7])
                ||
                (value == values[2] && value == values[5] && value == values[8]);
        boolean diagonal = (value == values[0] && value == values[4] && value == values[8])
                ||
                (value == values[2] && value == values[4] && value == values[6]);
        return horizontal || vertical || diagonal;
    }

    public static boolean hasEmpty(char[] values) {
        for (char value : values) {
            if (value == '_') {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDifferenceCount(char[] values) {
        int x = 0;
        int o = 0;
        for (char value : values) {
            if (value == 'X') {
                x++;
            } else if (value == 'O') {
                o++;
            }
        }
        int difference = x - o;
        return difference >= 2 || difference <= -2;
    }
}
