package generics;

public class FootballTeam extends Team implements Comparable<Team>{

    public FootballTeam(String teamName, Integer position) {
        super(teamName, position);
    }
}
