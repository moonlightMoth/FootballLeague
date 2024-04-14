package footballleague;

public class TeamResult {
    private int wins;
    private int losses;
    private int ties;
    private int pointsScored;
    private int pointsAllowed;
    
    TeamResult()
    {
        wins = 0;
        losses = 0;
        ties = 0;
        pointsAllowed = 0;
        pointsScored = 0;
    }

    public void addLoss()
    {
        losses++;
    }

    public void addWin()
    {
        wins++;
    }
    public void addTies()
    {
        ties++;
    }

    public void addPointsScored(int val)
    {
        pointsScored += val;
    }

    public void addPointsAllowed(int val)
    {
        pointsAllowed += val;
    }

    public int getWins()
    {
        return wins;
    }

    public int getLosses()
    {
        return losses;
    }

    public int getTies()
    {
        return ties;
    }

    public int getPointsScored()
    {
        return pointsScored;
    }

    public int getPointsAllowed()
    {
        return pointsAllowed;
    }
}
