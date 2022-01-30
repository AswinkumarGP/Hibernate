package generics;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        FootballTeam manCity = new FootballTeam("ManCity", 2);
        FootballTeam liverpool = new FootballTeam("Liverpool", 1);
        League<FootballTeam> premierLeague = new League<>("Premier League");
        premierLeague.addTeam(manCity);
        premierLeague.addTeam(liverpool);

        CricketTeam csk = new CricketTeam("CSK", 2);
        CricketTeam mi = new CricketTeam("MI", 1);
        League<CricketTeam> ipl = new League<>("IPL");
        ipl.addTeam(csk);
        ipl.addTeam(mi);

        premierLeague.getTeams();
        ipl.getTeams();

        premierLeague.showLeagueTable();
        ipl.showLeagueTable();

    }
}
