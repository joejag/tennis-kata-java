import java.util.Arrays;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) return normalScore();
        else if (m_score1 >= 4 || m_score2 >= 4) return faceOff();
        else return basicScore(m_score1) + "-" + basicScore(m_score2);
    }

    private String normalScore() {
        if (Arrays.asList(0, 1, 2).contains(m_score1))
            return basicScore(m_score1) + "-All";

        return "Deuce";
    }

    private String faceOff() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
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

        return "BUST";
    }
}
