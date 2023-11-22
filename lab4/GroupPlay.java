import java.util.LinkedList;
import java.util.Random;

public class GroupPlay extends Competition{
    
    // attributes
    private int noGroups = 0;
    private LinkedList<League> leagues;
    protected Random random;

    // constructor
    public GroupPlay(String n, Country c, Gender g, boolean cl){
        super(n, c, g, cl);
        random = new Random();
        leagues = new LinkedList<League>();
    }

    //getters
    public int getNoGroups(){
        return noGroups;
    }

    public LinkedList<League> getListLeagues(){
        return leagues;
    }
    
    public int getSizeLeagues(){
        return leagues.size();
    }

    public League getLeague(int index){
        return leagues.get(index);
    }

    //methods
    public void addLeague (League league){

        leagues.add(noGroups, league);
        noGroups++;
    }


    @Override
    public void simulateMatches(){
        
        //para cada liga dentro del grupo de ligas
        for(int i = 0; i < noGroups; i++){
            System.out.println("_______________________________________________________________________________________________________________________________________________________");
            System.out.println("\n" + getLeague(i).getName() + "\n");
            //selecionamos liga
            League l = getLeague(i);
            
            //generamos y jugamos losspartidos
            l.generateMatches();
            l.simulateMatches();

            
            //imprimimos final stats de esta liga
            System.out.println("___________________________________________________________________________________");
            System.out.println("\n\nFINAL STATS THE LEAGUE:\n");

            for (int j = 0; j < l.getNumTeams(); j++) {
                Team t = l.getTeam(j);
                t.getStats(l).printStats();

                for(int k = 0; k < t.getNumPlayers(); k++){
                    Player p = t.getPlayer(k);
                    p.getStats(l).printStatsPlayer();
                }
                System.out.println("\n");

            }
        }

    }


    public void printTables(){
        for(int i = 0; i < leagues.size(); i++){
            League l = leagues.get(i);
            l.printTable();
            l.printMatches();
            l.printGoalsScorers(2);
        }
    }


}
