package footballleague;

public class DayBuilder {

    public static Day build(int temperature, Game game0, Game game1) throws IllegalArgumentException
    {
        if (temperature > 50)
            throw new IllegalArgumentException("Too hot");

        if (temperature > 0 && (game0 == null || game1 == null))
            throw new IllegalArgumentException("Games cannot be null if temp greater than -1");

        return new Day(temperature, game0, game1);
    }

    public static Day buildLowTempDay(int temp)
    {
        return new Day(temp, null, null);
    }
}
