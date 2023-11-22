public class TeamStats implements Comparable<TeamStats>{
    
    //attributes
    protected Team team;
    protected int noMatches = 0;
    protected int noWins = 0;
    protected int noTies = 0;
    protected int noLosses = 0;
    protected int  goalsScored = 0;
    protected int goalsAgainst = 0;

    //constructor
    public TeamStats(Team t){
        team = t;
    }

    //methods
    public void updateStats(Match m){

        if(m.getHomeTeam().name == team.getName()){

            //actualizamos goles marcados
            goalsScored += m.getGoalsHome();
            goalsAgainst += m.getGoalsAway();

            if(m.getGoalsHome() > m.getGoalsAway()){
                noWins += 1;

            } 
            else if (m.getGoalsHome() < m.getGoalsAway()){
                noLosses += 1;

            }
            else {
                noTies += 1;
                
            }

        }

        else if(m.getAwayTeam().name == team.getName()){

            //actualizamos goles marcados
            goalsScored += m.getGoalsAway();
            goalsAgainst += m.getGoalsHome();

            if(m.getGoalsHome() > m.getGoalsAway()){
                noLosses += 1;

            } 
            else if (m.getGoalsHome() < m.getGoalsAway()){
                noWins += 1;

            }
            else {
                noTies += 1;
                
            }  
        }

        noMatches += 1;
    }

    public void printStats(){
        System.out.println(team.getName() + ": Matches: " + noMatches + ", " + "Wins: " + noWins + ", " + "Ties: " + noTies + ", " + "Losses: " 
        + noLosses + ", " + "Goals scored: " + goalsScored + ", " + "Goals against: " + goalsAgainst + "\n");
    }


    public void printStatsTable(){
        System.out.printf("%-25s | %-8d | %-4d | %-4d | %-6d | %-13d | %-15d%n\n",
            team.getName(), noMatches, noWins, noTies, noLosses, goalsScored, goalsAgainst);
    }

    @Override
    public int compareTo(TeamStats other){
    
        //miramos que equipo tiene más puntos con la formula 3*noWins +noTies
        int pointsTeam = 3*noWins +noTies;
        int pointsOther = 3*other.noWins + other.noTies;
    
        if(pointsTeam < pointsOther) return 1;     //menos puntos
        else if (pointsTeam > pointsOther)return -1;  //mas puntos
        else {     //mismos puntos

            //miramos que equipo tiene la better goal difference
            int goalDifferenceTeam = goalsScored - goalsAgainst;
            int goalDifferenceOther = other.goalsScored - other.goalsAgainst;

            if(goalDifferenceTeam < goalDifferenceOther) return 1;     //diferencia menor
            else if (goalDifferenceTeam > goalDifferenceOther)return -1;  //diferencia mayor
            else { //misma diferencia

                //miramos los goles metidos
                if(goalsScored < other.goalsScored) return 1;     //diferencia menor
                else if (goalsScored > other.goalsScored)return -1;  //diferencia mayor
                else return 0;   //el único caso en el que devolverá 0, ya que en los tres escenarios las stats son iguales

            }
        }    
    }
}
