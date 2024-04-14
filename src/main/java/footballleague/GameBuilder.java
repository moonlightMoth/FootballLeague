package footballleague;

public class GameBuilder {
    private static int gameCounter = 0;

    public static Game build(Team team0, Team team1, int homeScore, int awayScore) throws IllegalArgumentException
    {
        if (team0 == null || team1 == null)
            throw new IllegalArgumentException("Teams cannot be null");
        if (homeScore < 0 || awayScore < 0)
            throw new IllegalArgumentException("Score cannot be less than 0");

        gameCounter++;

        return new Game(gameCounter, team0, team1, homeScore, awayScore);
    }
}
