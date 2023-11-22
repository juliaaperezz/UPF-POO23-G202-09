public abstract class PlayerStats {
    //attributes
    protected Player player;
    protected int noMatches = 0;

    //constructor
    public PlayerStats(Player p){
        player = p;
    }

    //methods
    public void updateStats(Match m){

    }

    abstract void printStatsPlayer();
    
}
