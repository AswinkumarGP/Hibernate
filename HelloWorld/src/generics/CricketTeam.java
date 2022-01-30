package generics;

public class CricketTeam extends Team implements Comparable<Team>{

    public CricketTeam(String teamName, Integer position) {
        super(teamName, position);
    }
}
