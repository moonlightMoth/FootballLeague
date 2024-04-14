package test;

import footballleague.Day;
import footballleague.SeasonPlanner;
import footballleague.Team;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int i = 1;

        Team[] teams = TeamArrayBuilder.build();
        SeasonPlanner seasonPlanner = SeasonPlanner.getNewInstance();

        while (!seasonPlanner.isOver())
        {
            System.out.println("Enter day " + i + " temperature:");
            int tmp = 0;

            try
            {
                tmp = Integer.parseInt(sc.next());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid temperature, try another value.");
                continue;
            }

            if (tmp < 0)
                System.out.println("Too cold to play");

            Day day;
            try
            {
                day = DayRandomBuilder.build(teams, tmp);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                continue;
            }

            seasonPlanner.push(day);
            i++;
        }

        System.out.println(seasonPlanner);
    }
}