package generics;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    public String leagueName;

    public League(String leagueName) {
        this.leagueName = leagueName;
    }
    public ArrayList<T> teams = new ArrayList<>();

    public void addTeam(T team){
        this.teams.add(team);
    }

    public void getTeams() {
        for(T team : teams){
            System.out.println(team.getTeamName());
        }
    }

    public void showLeagueTable(){
        Collections.sort(teams);
        System.out.println("League table : "+leagueName);
        for (T team : teams){
            System.out.println(team.getTeamName());
        }
    }

}
