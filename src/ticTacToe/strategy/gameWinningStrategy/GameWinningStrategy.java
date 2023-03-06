package ticTacToe.strategy.gameWinningStrategy;

import ticTacToe.model.Board;
import ticTacToe.model.Move;
import ticTacToe.model.Player;

public interface GameWinningStrategy {

    Boolean updateBoardAndCheckWinner(Board board, Player lastMovedPlayer, Move move);
}
