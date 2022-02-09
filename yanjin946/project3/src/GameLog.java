public class GameLog {
    private int winningPlayer;
    private int losingPlayerHits;
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;

    public GameLog(int winningPlayer, int losingPlayerHits, int numTurns,
                   String boardPatternTwo, String boardPatterOne) {
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternTwo = boardPatternTwo;
        this.boardPatternOne = boardPatternOne;
    }

    public String toString() {
        if (winningPlayer == 1) {
            String format = "Battleship Game Log:\n " +
                    "Winning Player: Player %d \n Hits: 17 - %d \n" +
                    " Number of Turns To Win: " + "%d \n Player 1 Board Pattern: %s \n" +
                    " Player 2 Board Pattern: %s \n";

            return String.format(format, winningPlayer, losingPlayerHits, numTurns, boardPatternOne, boardPatternTwo);
        } else {
            String format = "Battleship Game Log:\n " +
                    "Winning Player: Player %d \n Hits: %d - 17 \n" +
                    " Number of Turns To Win: " +
                    "%d \n Player 1 Board Pattern: %s \n Player 2 Board Pattern: %s \n";
            return String.format(format, winningPlayer, losingPlayerHits, numTurns, boardPatternOne, boardPatternTwo);
        }


    }

}
