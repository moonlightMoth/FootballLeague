package footballleague;

import java.util.Objects;

public class Game {
    private int id;
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamResult;
    private int awayTeamResult;

    Game(int id, Team homeTeam, Team awayTeam, int homeTeamResult, int awayTeamResult)
    {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamResult = homeTeamResult;
        this.awayTeamResult = awayTeamResult;
    }

    public void setHomeTeamResult(int homeTeamResult)
    {
        this.homeTeamResult = homeTeamResult;
    }

    public void setAwayTeamResult(int awayTeamResult)
    {
        this.awayTeamResult = awayTeamResult;
    }

    public Team getHomeTeam()
    {
        return homeTeam;
    }

    public Team getAwayTeam()
    {
        return awayTeam;
    }

    public int getHomeTeamResult()
    {
        return homeTeamResult;
    }

    public int getAwayTeamResult()
    {
        return awayTeamResult;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && homeTeamResult == game.homeTeamResult && awayTeamResult == game.awayTeamResult && Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, homeTeam, awayTeam, homeTeamResult, awayTeamResult);
    }

    @Override
    public String toString()
    {
        return "Game{" +
                "id=" + id +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", homeTeamResult=" + homeTeamResult +
                ", awayTeamResult=" + awayTeamResult +
                '}';
    }
}
