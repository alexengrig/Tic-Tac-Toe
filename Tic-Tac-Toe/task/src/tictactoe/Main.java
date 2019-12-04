package tictactoe;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        char[] chars = new char[]{'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O', 'X'};
        for (int i = 0; i < chars.length; i++) {
            if (i >= size && i % size == 0) {
                System.out.println();
            }
            System.out.print(chars[i] + " ");
        }
    }
}
