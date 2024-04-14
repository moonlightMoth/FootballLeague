package test;

import footballleague.Team;

public class TeamArrayBuilder {
    public static Team[] build()
    {
        Team team0 = new Team("Sockers");
        Team team1 = new Team("Dockers");
        Team team2 = new Team("Sockets");
        Team team3 = new Team("Rockers");

        return new Team[]{team0, team1, team2, team3};
    }
}
