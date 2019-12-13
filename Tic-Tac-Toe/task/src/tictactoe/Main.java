package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Stone[] stones = new Stone[9];
        Arrays.fill(stones, Stone.FREE);
        Stone current = Stone.FREE;
        GameStatus gameStatus;
        do {
            current = current.opposite();
            print(stones);
            move(stones, current);
            gameStatus = check(stones, current);
        } while (gameStatus == GameStatus.NONE);
        print(stones);
        if (gameStatus == GameStatus.WIN) {
            System.out.println(current + " wins");
        } else {
            System.out.println("Draw");
        }
    }

    private static void print(Stone[] stones) {
        int length = stones.length;
        int size = (int) Math.sqrt(length);
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.print("\n| ");
        for (int i = 0; i < length; i++) {
            if (i >= size && i % size == 0) {
                System.out.print("|\n| ");
            }
            System.out.print(stones[i] + " ");
        }
        System.out.println("|");
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void move(Stone[] stones, Stone stone) {
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
            if (stones[index] == Stone.FREE) {
                stones[index] = stone;
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } while (true);
    }

    private static GameStatus check(Stone[] stones, Stone stone) {
        if (win(stones, stone)) {
            return GameStatus.WIN;
        } else if (!hasEmpty(stones)) {
            return GameStatus.DRAW;
        }
        return GameStatus.NONE;
    }

    public static boolean win(Stone[] stones, Stone stone) {
        boolean horizontal = (stone == stones[0] && stone == stones[1] && stone == stones[2])
                ||
                (stone == stones[3] && stone == stones[4] && stone == stones[5])
                ||
                (stone == stones[6] && stone == stones[7] && stone == stones[8]);
        boolean vertical = (stone == stones[0] && stone == stones[3] && stone == stones[6])
                ||
                (stone == stones[1] && stone == stones[4] && stone == stones[7])
                ||
                (stone == stones[2] && stone == stones[5] && stone == stones[8]);
        boolean diagonal = (stone == stones[0] && stone == stones[4] && stone == stones[8])
                ||
                (stone == stones[2] && stone == stones[4] && stone == stones[6]);
        return horizontal || vertical || diagonal;
    }

    public static boolean hasEmpty(Stone[] stones) {
        for (Stone stone : stones) {
            if (stone == Stone.FREE) {
                return true;
            }
        }
        return false;
    }

    enum Stone {
        X {
            @Override
            public String toString() {
                return "X";
            }

            @Override
            public Stone opposite() {
                return O;
            }
        },
        O {
            @Override
            public String toString() {
                return "O";
            }

            @Override
            public Stone opposite() {
                return X;
            }
        },
        FREE {
            @Override
            public String toString() {
                return " ";
            }

            @Override
            public Stone opposite() {
                return X;
            }
        };

        public abstract Stone opposite();
    }

    enum GameStatus {
        WIN,
        DRAW,
        NONE
    }
}
