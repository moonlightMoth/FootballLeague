package footballleague;

import java.util.ArrayList;
import java.util.HashMap;

class SeasonPlannerImpl implements SeasonPlanner{

    private final ArrayList<Day> season = new ArrayList<>();
    private final HashMap<Team, TeamResult> teamResults = new HashMap<>();

    private boolean isOver = false;

    SeasonPlannerImpl()
    {

    }

    // returns false if season is over and do not add another day to list
    @Override
    public boolean push(Day day)
    {
        if (isOver)
            return false;

        season.add(day);
        isOver = checkIfSeasonIsOver();

        if (day.getTemperature() >= 0)
            processPush(day);

        return true;
    }

    private void processPush(Day day)
    {
        Game game = day.getFirstGame();

        TeamResult awayTeamResult = teamResults.getOrDefault(game.getAwayTeam(), new TeamResult());
        TeamResult homeTeamResult = teamResults.getOrDefault(game.getHomeTeam(), new TeamResult());

        if (game.getAwayTeamResult() > game.getHomeTeamResult())
        {
            homeTeamResult.addLoss();
            awayTeamResult.addWin();
            awayTeamResult.addPointsScored(game.getAwayTeamResult());
            homeTeamResult.addPointsScored(game.getHomeTeamResult());
            awayTeamResult.addPointsAllowed(game.getAwayTeamResult());
            homeTeamResult.addPointsAllowed(game.getHomeTeamResult());
        }
        else if (game.getAwayTeamResult() == game.getHomeTeamResult())
        {
            homeTeamResult.addTies();
            awayTeamResult.addTies();
            awayTeamResult.addPointsScored(game.getAwayTeamResult());
            homeTeamResult.addPointsScored(game.getHomeTeamResult());
            awayTeamResult.addPointsAllowed(game.getAwayTeamResult());
            homeTeamResult.addPointsAllowed(game.getHomeTeamResult());
        }
        else
        {
            homeTeamResult.addWin();
            awayTeamResult.addLoss();
            awayTeamResult.addPointsScored(game.getAwayTeamResult());
            homeTeamResult.addPointsScored(game.getHomeTeamResult());
            awayTeamResult.addPointsAllowed(game.getAwayTeamResult());
            homeTeamResult.addPointsAllowed(game.getHomeTeamResult());
        }

        teamResults.put(game.getHomeTeam(), homeTeamResult);
        teamResults.put(game.getAwayTeam(), awayTeamResult);

        game = day.getSecondGame();

        awayTeamResult = teamResults.getOrDefault(game.getAwayTeam(), new TeamResult());
        homeTeamResult = teamResults.getOrDefault(game.getHomeTeam(), new TeamResult());

        if (game.getAwayTeamResult() > game.getHomeTeamResult())
        {
            homeTeamResult.addLoss();
            awayTeamResult.addWin();
            awayTeamResult.addPointsScored(game.getAwayTeamResult());
            homeTeamResult.addPointsScored(game.getHomeTeamResult());
            awayTeamResult.addPointsAllowed(game.getAwayTeamResult());
            homeTeamResult.addPointsAllowed(game.getHomeTeamResult());
        }
        else if (game.getAwayTeamResult() == game.getHomeTeamResult())
        {
            homeTeamResult.addTies();
            awayTeamResult.addTies();
            awayTeamResult.addPointsScored(game.getAwayTeamResult());
            homeTeamResult.addPointsScored(game.getHomeTeamResult());
            awayTeamResult.addPointsAllowed(game.getAwayTeamResult());
            homeTeamResult.addPointsAllowed(game.getHomeTeamResult());
        }
        else
        {
            homeTeamResult.addWin();
            awayTeamResult.addLoss();
            awayTeamResult.addPointsScored(game.getAwayTeamResult());
            homeTeamResult.addPointsScored(game.getHomeTeamResult());
            awayTeamResult.addPointsAllowed(game.getAwayTeamResult());
            homeTeamResult.addPointsAllowed(game.getHomeTeamResult());
        }

        teamResults.put(game.getHomeTeam(), homeTeamResult);
        teamResults.put(game.getAwayTeam(), awayTeamResult);
    }

    private boolean checkIfSeasonIsOver()
    {
        if (season.size() < 3)
            return false;

        return season.get(season.size()-1).getTemperature() < 0 &&
                season.get(season.size()-2).getTemperature() < 0 &&
                season.get(season.size()-3).getTemperature() < 0;
    }

    @Override
    public boolean isOver()
    {
        return isOver;
    }

    @Override
    public String toString()
    {
        if (season.isEmpty())
            return "No games hold yet";

        final StringBuilder sb = new StringBuilder();

        sb.append("***********************TEAMS***********************\n\n");


        teamResults.forEach((team, teamResult) -> {
            sb.append(team).append("\n");
            sb.append("Wins: ").append(teamResult.getWins())
                    .append(", Losses: ").append(teamResult.getLosses())
                    .append(", Ties: ").append(teamResult.getTies())
                    .append("\n");
            sb.append("Points Scored: ").append(teamResult.getPointsAllowed())
                    .append(", Points Allowed: ").append(teamResult.getPointsAllowed())
                    .append("\n");
        });

        sb.append("\n\n\n");

        sb.append("***********************GAMES***********************\n\n");

        int tempSum = 0;
        int maxTemp = 0;

        for (Day day : season)
        {
            if (day.getTemperature() < 0)
                continue;

            tempSum += day.getTemperature();
            maxTemp = Math.max(maxTemp, day.getTemperature());

            Game game = day.getFirstGame();

            sb.append("Game #").append(game.getId()).append("\n");
            sb.append("Temperature: ").append(day.getTemperature()).append("\n");
            sb.append("Away Team: ").append(game.getAwayTeam()).append(", ").append(game.getAwayTeamResult()).append("\n");
            sb.append("Home Team: ").append(game.getHomeTeam()).append(", ").append(game.getHomeTeamResult());

            sb.append("\n\n");

            game = day.getSecondGame();

            sb.append("Game #").append(game.getId()).append("\n");
            sb.append("Temperature: ").append(day.getTemperature()).append("\n");
            sb.append("Away Team: ").append(game.getAwayTeam()).append(", ").append(game.getAwayTeamResult()).append("\n");
            sb.append("Home Team: ").append(game.getHomeTeam()).append(", ").append(game.getHomeTeamResult());

            sb.append("\n\n");
        }

        sb.append("Hottest Temperature: ").append(maxTemp).append("\n");
        sb.append("Average Temperature: ").append(tempSum/season.stream().filter(day -> day.getTemperature() > -1).count());

        return sb.toString();
    }
}
