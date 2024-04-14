package footballleague;


import java.util.Objects;

// Class for representing a day. Contains two games and temperature.
public class Day {
    private int temperature;
    private Game firstGame;
    private Game secondGame;

    Day(int temperature, Game firstGame, Game secondGame)
    {
        this.temperature = temperature;
        this.firstGame = firstGame;
        this.secondGame = secondGame;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public Game getFirstGame()
    {
        return firstGame;
    }

    public Game getSecondGame()
    {
        return secondGame;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return temperature == day.temperature && Objects.equals(firstGame, day.firstGame) && Objects.equals(secondGame, day.secondGame);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(temperature, firstGame, secondGame);
    }

    @Override
    public String toString()
    {
        return "Day{" +
                "temperature=" + temperature +
                ", firstGame=" + firstGame +
                ", secondGame=" + secondGame +
                '}';
    }
}
