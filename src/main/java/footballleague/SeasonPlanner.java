package footballleague;

public interface SeasonPlanner {

    boolean push(Day day);
    boolean isOver();

    static SeasonPlanner getNewInstance()
    {
        return SeasonPlannerBuilder.build();
    }

    String toString();
}
