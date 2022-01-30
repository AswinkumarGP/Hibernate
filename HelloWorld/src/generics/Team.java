package generics;

public abstract class Team implements Comparable<Team>{

    public String teamName;
    public Integer position;

    public Team(String teamName, Integer position) {
        this.teamName = teamName;
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public int compareTo(Team t) {
        if (this.getPosition() > t.getPosition()){
            return 1;
        } else if (this.getPosition() < t.getPosition()){
            return -1;
        }
        return 0;
    }
}
