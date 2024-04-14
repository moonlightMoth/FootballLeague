package test;

import footballleague.Day;
import footballleague.DayBuilder;
import footballleague.GameBuilder;
import footballleague.Team;
import footballleague.controller.*;

import java.util.Random;

public class DayRandomBuilder {
    private static Random rand = new Random();
    private static int gameCounter = 0;
    private static final int NOISE = 4;

    public static Day build(Team[] teams, int temp)
    {
        if (temp < 0)
            return DayBuilder.buildLowTempDay(temp);

        int rotation = rand.nextInt(teams.length);
        Team team0 = teams[(rotation) % teams.length];
        Team team1 = teams[(rotation + 1) % teams.length];
        Team team2 = teams[(rotation + 2) % teams.length];
        Team team3 = teams[(rotation + 3) % teams.length];


        int homeScoreNoise0 = rand.nextInt(NOISE);
        int awayScoreNoise0 = rand.nextInt(NOISE);

        int base = temp/10;

        homeScoreNoise0 = rand.nextInt(2) == 0 ? homeScoreNoise0 : -homeScoreNoise0;
        awayScoreNoise0 = rand.nextInt(2) == 0 ? awayScoreNoise0 : -awayScoreNoise0;

        int homeScore0 = base + homeScoreNoise0;
        int awayScore0 = base + awayScoreNoise0;

        homeScore0 = Math.max(homeScore0, 0);
        awayScore0 = Math.max(awayScore0, 0);


        int homeScoreNoise1 = rand.nextInt(NOISE);
        int awayScoreNoise1 = rand.nextInt(NOISE);


        homeScoreNoise1 = rand.nextInt(2) == 0 ? homeScoreNoise1 : -homeScoreNoise1;
        awayScoreNoise1 = rand.nextInt(2) == 0 ? awayScoreNoise1 : -awayScoreNoise1;

        int homeScore1 = base + homeScoreNoise1;
        int awayScore1 = base + awayScoreNoise1;

        homeScore1 = Math.max(homeScore1, 0);
        awayScore1 = Math.max(awayScore1, 0);


        return DayBuilder.build(temp, GameBuilder.build(team0, team1, homeScore0, awayScore0), GameBuilder.build(team2, team3, homeScore1, awayScore1));
    }
}
