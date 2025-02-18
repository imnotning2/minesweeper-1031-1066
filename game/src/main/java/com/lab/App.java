package com.lab;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    // Initialize minefield with some preset mines
    static Minesweeper initMineField() {
        Minesweeper game = new Minesweeper(9, 9);
        game.setMineCell(0, 1);
        game.setMineCell(1, 5);
        game.setMineCell(1, 8);
        game.setMineCell(2, 4);
        game.setMineCell(3, 6);        
        game.setMineCell(4, 2);
        game.setMineCell(5, 4);
        game.setMineCell(6, 2);
        game.setMineCell(7, 2);
        game.setMineCell(8, 6);
        return game;
    }

    // Initialize minefield from a file
    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }

    static void displayMenu() {
        System.out.println("Minesweeper Game");
        System.out.println("1. Play with Default Minefield");
        System.out.println("2. Load Minefield from File");
        System.out.println("3. Exit");
        System.out.print("Please select an option (1-3): ");
    }

  // Handle user input for the game
static void playGame(Minesweeper game) {
    Scanner scanner = new Scanner(System.in);
    boolean gameOver = false;
    
    while (!gameOver) {
        game.displayField();
        System.out.print("Enter row (1-9): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column (1-9): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= 9 || col < 0 || col >= 9) {
            System.out.println("Invalid input. Please enter values between 1 and 9.");
            continue;
        }

        if (game.cells[row][col] == Minesweeper.IS_MINE) {
            System.out.println("Boom! Dead. You hit a mine at row " + (row + 1) + ", column " + (col + 1) + ".");
            gameOver = true;
        } else {
            System.out.println("Safe! Keep going.");

        }
    }
}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Minesweeper game = null;
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    game = initMineField();
                    playGame(game);
                    break;
                case 2:
                    System.out.print("Enter the path of the minefield file: ");
                    String filePath = scanner.next();
                    game = initMineFieldFromFile(filePath);
                    playGame(game);
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
