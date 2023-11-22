import java.util.Collections;
import java.util.LinkedList;


public class League extends Competition {
    //attributes 
    

    //constructor
    public League(String n, Country c, Gender g, boolean cl){
        super(n,c,g, cl);
    }
    
    //getters

    //methods
    @Override
    public void generateMatches(){
        for (int i = 0; i < counterTeams; i++){
            for(int j = 0; j < counterTeams; j++){
                if (i != j) {
                    Match m = new Match(getTeam(i), getTeam(j));
                    matches.add(i, m);
                    counterMatches++;
                }
                
            }

        }

    }

    
    public void printTable(){

        LinkedList<TeamStats> teamsStats = new LinkedList<TeamStats>();

        //añadimos las stats de cada team a la lista
        for(int i = 0; i < getNumTeams(); i++){

            TeamStats ts = getTeam(i).getStats(this);
            teamsStats.add(i, ts);
        }

        //ordenamos las stats
        Collections.sort(teamsStats);

        //imprimimos stats
        System.out.println();
        System.out.println(" TABLE LEAGUE: " + getName() + "\n");
        System.out.printf("%-25s | %-8s | %-4s | %-4s | %-4s | %-13s | %-15s%n",
            "Team", "Matches", "Wins", "Ties", "Losses", "Goals Scored", "Goals Against" + "\n");
        
        for(int i = 0; i < teamsStats.size(); i++){
            teamsStats.get(i).printStatsTable();
            
        }
        System.out.println();  //linea en blanco (separa)

    }
}
