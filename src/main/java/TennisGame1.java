import java.util.Arrays;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2 && Arrays.asList(0, 1, 2).contains(m_score1))
            return basicScore(m_score1) + "-All";

        if (m_score1 == m_score2)
            return "Deuce";

        if (m_score1 < 4 && m_score2 < 4)
            return basicScore(m_score1) + "-" + basicScore(m_score2);

        return faceOff();
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

        throw new IllegalArgumentException("bang: cannot be higher than 3 but is " + score );
    }

    private String faceOff() {
        int difference = m_score1 - m_score2;
        if (difference == 1) return "Advantage player1";
        if (difference >= 2) return "Win for player1";
        if (difference == -1) return "Advantage player2";
        if (difference <= -2) return "Win for player2";

        throw new IllegalArgumentException("bang " + m_score1 + " - " + m_score2);
    }
}
