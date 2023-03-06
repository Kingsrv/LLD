package ticTacToe;

import ticTacToe.controller.GameController;
import ticTacToe.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the dimension ");
        int dimension = sc.nextInt();

        GameController gameController = new GameController();

        System.out.println("Will there be any bot in the game ?");
        String isBotString = sc.next();

        List<Player> players = new ArrayList<>();
        int toIterate = isBotString.equalsIgnoreCase("Y") ? dimension - 2 : dimension -1;


        for (int i = 0; i < toIterate; i++) {
            System.out.println("Please enter the name of player " + i+1);
            String playerName = sc.next();

            System.out.println("Please enter the symbol of player " + i+1);
            String playerSymbol = sc.next();

            players.add(new Player(playerSymbol.charAt(0),playerName, PlayerType.HUMAN));

        }

        if(isBotString.equalsIgnoreCase("Y")){
            System.out.println("what is the name of the Bot ?");
            String botName = sc.next();

            System.out.println("what is the symbol of the Bot ");
            String botSymbol = sc.next();

            players.add(new Bot(botSymbol.charAt(0),botName, BotDifficultyLevel.EASY));
        }

        Game game = gameController.createGame(dimension, players);

        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is the current Board");
            gameController.displayBoard(game);

            System.out.println("does anyone wants to undo ?");
            String undoInput = sc.next();

            if(undoInput.equalsIgnoreCase("Y")){
                game.undo();
            }else{
                game.makeNextMove();
            }
        }

        System.out.println("Game has ended, result is " + game.getGameStatus());
        if(game.getGameStatus().equals(GameStatus.ENDED)){
            System.out.println("Winner is " + game.getWinner().getName());
        }

    }
}
