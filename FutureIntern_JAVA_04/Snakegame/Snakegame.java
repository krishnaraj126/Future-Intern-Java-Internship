package Snakegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snakegame {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final char SNAKE_SYMBOL = 'O';
    private static final char FOOD_SYMBOL = '*';
    private static final char EMPTY_SYMBOL = ' ';

    private char[][] board;
    private List<int[]> snake;
    private int[] food;
    private int direction; // 0: up, 1: right, 2: down, 3: left

    public Snakegame() {
        board = new char[HEIGHT][WIDTH];
        snake = new ArrayList<>();
        snake.add(new int[]{HEIGHT / 2, WIDTH / 2});
        food = new int[]{generateRandomNumber(HEIGHT), generateRandomNumber(WIDTH)};
        direction = 1; // Start moving right
    }

    private int generateRandomNumber(int max) {
        return (int) (Math.random() * max);
    }

    private void initializeBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = EMPTY_SYMBOL;
            }
        }
    }

    private void updateBoard() {
        initializeBoard();

        // Draw snake
        for (int[] segment : snake) {
            board[segment[0]][segment[1]] = SNAKE_SYMBOL;
        }

        // Draw food
        board[food[0]][food[1]] = FOOD_SYMBOL;
    }

    private void printBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private void moveSnake() {
        int headX = snake.get(0)[0];
        int headY = snake.get(0)[1];

        switch (direction) {
            case 0:
                headX--;
                break;
            case 1:
                headY++;
                break;
            case 2:
                headX++;
                break;
            case 3:
                headY--;
                break;
        }

        snake.add(0, new int[]{headX, headY});

        if (headX == food[0] && headY == food[1]) {
            food = new int[]{generateRandomNumber(HEIGHT), generateRandomNumber(WIDTH)};
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            updateBoard();
            printBoard();

            System.out.print("Enter direction (w/a/s/d): ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'w':
                    direction = 0;
                    break;
                case 'd':
                    direction = 1;
                    break;
                case 's':
                    direction = 2;
                    break;
                case 'a':
                    direction = 3;
                    break;
            }

            moveSnake();

            // Check for game over (snake hits itself or wall)
            if (isGameOver()) {
                System.out.println("Game Over!");
                break;
            }

            try {
                Thread.sleep(100); // Adjust delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private boolean isGameOver() {
        // Check for collision with self
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0)[0] == snake.get(i)[0] && snake.get(0)[1] == snake.get(i)[1]) {
                return true;
            }
        }

        // Check for collision with walls
        int headX = snake.get(0)[0];
        int headY = snake.get(0)[1];
        return headX < 0 || headX >= HEIGHT || headY < 0 || headY >= WIDTH;
    }

    public static void main(String[] args) {
        Snakegame game = new Snakegame();
        game.play();
    }
}