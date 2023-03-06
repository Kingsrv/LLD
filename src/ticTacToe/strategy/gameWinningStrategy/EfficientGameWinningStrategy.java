package ticTacToe.strategy.gameWinningStrategy;

import ticTacToe.model.Board;
import ticTacToe.model.Move;
import ticTacToe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EfficientGameWinningStrategy implements GameWinningStrategy{

    List<HashMap<Character, Integer>> rowSymbolCount = new ArrayList<>();
    List<HashMap<Character, Integer>> colSymbolCount = new ArrayList<>();
    HashMap<Character, Integer> topLeftDiagonalSymbolCount = new HashMap<>();
    HashMap<Character, Integer> bottomLeftDiagonalSymbolCount = new HashMap<>();
    int dimension;

    public EfficientGameWinningStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
        this.dimension = dimension;
    }

    public boolean isTopLeftDiagonal(int row, int col){
        return row == col;
    }

    public boolean isBottomLeftDiagonal(int row, int col){
        return row+col == dimension-1;
    }


    @Override
    public Boolean updateBoardAndCheckWinner(Board board, Player lastMovedPlayer, Move lastMove) {
        char symbol = lastMovedPlayer.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        rowSymbolCount.get(row).put(symbol, rowSymbolCount.get(row).getOrDefault(symbol, 0)+ 1);
        colSymbolCount.get(col).put(symbol, colSymbolCount.get(col).getOrDefault(symbol, 0) + 1);
        if(isTopLeftDiagonal(row, col)){
            topLeftDiagonalSymbolCount.put(symbol, topLeftDiagonalSymbolCount.getOrDefault(symbol, 0) +1);
        } else if (isBottomLeftDiagonal(row, col)) {
            bottomLeftDiagonalSymbolCount.put(symbol, bottomLeftDiagonalSymbolCount.getOrDefault(symbol, 0) + 1);
        }
        return checkWinnerLogic(row, col, symbol);
    }

    private boolean checkWinnerLogic(int row, int col, char symbol){
        if(rowSymbolCount.get(row).get(symbol) == dimension){
            return true;
        }
        if(colSymbolCount.get(col).get(symbol) == dimension){
            return true;
        }
        if(isTopLeftDiagonal(row, col)){
            if(topLeftDiagonalSymbolCount.get(symbol) == dimension){
                return true;
            }
        }
        if(isBottomLeftDiagonal(row, col)){
            if(bottomLeftDiagonalSymbolCount.get(symbol) == dimension){
                return true;
            }
        }
        return false;
    }
}
