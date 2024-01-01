package Models;

import Design_Pattern.BotPlayerStrategy.BotPlayingStrategy;
import Design_Pattern.BotPlayerStrategy.EasyBotPlayingStrategy;

public class bot extends Player{
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficultyLevel botDifficultyLevel;

    public bot( String name, Symbol symbol,PlayerType playertype,
                BotPlayingStrategy botPlayingStrategy, BotDifficultyLevel botDifficultyLevel) {

        super(name,symbol,playertype);
        this.botPlayingStrategy = botPlayingStrategy;
        this.botDifficultyLevel = botDifficultyLevel;

    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
//        How bot will make a move
//        bot will make a move based on difficulty level
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
