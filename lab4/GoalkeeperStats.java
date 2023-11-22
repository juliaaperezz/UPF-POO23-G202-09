public class GoalkeeperStats extends PlayerStats implements Comparable<GoalkeeperStats> {
    //attributes
    private int noSaves = 0;
    private int noGoalsLet = 0;

    //constructor
    public GoalkeeperStats(Player p){
        super(p);
    }


    //methods
    @Override
    public void updateStats(Match m){

        //actualizamos stats
        for(int i = 0; i <  m.getHomeTeam().getSizeListPlayers(); i++){
            Player p = m.getHomeTeam().getPlayer(i);
            if(p.getName() == player.getName()){
                noGoalsLet += m.awayGoals;
                noSaves += player.random.nextInt(7); 
            }

        }
        
        for(int i = 0; i <  m.getAwayTeam().getSizeListPlayers(); i++){
            Player p = m.getAwayTeam().getPlayer(i);
            if(p.getName() == player.getName()){
                noGoalsLet += m.homeGoals;
                noSaves += player.random.nextInt(7); 
            }

        }

        noMatches += 1;

    }
    
    @Override
    public void printStatsPlayer(){
        System.out.println( player.getName() + "--> " + "Matches: " + noMatches + ", Goals let: " + noGoalsLet + ", Saves: " + noSaves);
    }


    @Override
    public int compareTo(GoalkeeperStats other) {

        //miramos quien a salvado más balones
        if(noSaves < other.noSaves) return 1;     //menos salvadas
        else if (noSaves > other.noSaves)return -1;  //mas salvadas
        else return 0;    //mismas salvadas
        
    }
}
