public class TennisGame1 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int scoreOne = 0;
    private int scoreTwo = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            scoreOne += 1;
        else
            scoreTwo += 1;
    }

    public String getScore() {
        if (Math.max(scoreOne, scoreTwo) >= 4) {
            String winningPlayer = scoreOne > scoreTwo ? player1Name : player2Name;
            if (Math.abs(scoreOne - scoreTwo) >= 2) return "Win for " + winningPlayer;
            if (Math.abs(scoreOne - scoreTwo) == 1) return "Advantage " + winningPlayer;
        }

        if (scoreOne == scoreTwo && scoreOne >= 3)
            return "Deuce";
        if (scoreOne == scoreTwo)
            return basicScore(scoreOne) + "-All";

        return basicScore(scoreOne) + "-" + basicScore(scoreTwo);
    }

    private String basicScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }

        throw new IllegalArgumentException("bang: cannot be higher than 3 but is " + scoreOne + " - " + scoreTwo);
    }

}
