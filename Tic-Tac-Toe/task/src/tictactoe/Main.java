package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        char[] chars = SCANNER.nextLine().toCharArray();
        printFiled(chars);
        System.out.println();
        char current = whoseMove(chars);
        move(chars, current);
        printFiled(chars);
    }

    private static void move(char[] values, char value) {
        do {
            System.out.println("Enter the coordinates: ");
            String line = SCANNER.nextLine();
            int column;
            int row;
            try {
                String[] coordinates = line.split("\\s");
                column = Integer.parseInt(coordinates[0]);
                row = Integer.parseInt(coordinates[1]);
                if (column > 3 || column < 1 || row > 3 || row < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            int index = 8 + column - 3 * row;
            if (values[index] == '_') {
                values[index] = value;
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } while (true);
    }

    private static char whoseMove(char[] values) {
        int x = 0;
        int o = 0;
        for (char value : values) {
            if (value == 'X') {
                x++;
            } else if (value == 'O') {
                o++;
            }
        }
        return x > o ? 'O' : 'X';
    }

    private static void printResult(char[] chars) {
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
