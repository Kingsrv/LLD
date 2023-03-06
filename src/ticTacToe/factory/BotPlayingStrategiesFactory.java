package ticTacToe.factory;

import ticTacToe.model.BotDifficultyLevel;
import ticTacToe.strategy.botPlayingStrategy.BotPlayingStrategy;
import ticTacToe.strategy.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategiesFactory {

    public static BotPlayingStrategy getPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        return new RandomBotPlayingStrategy();
    }
}
