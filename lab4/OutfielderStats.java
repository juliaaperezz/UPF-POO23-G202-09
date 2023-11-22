public class OutfielderStats extends PlayerStats implements Comparable<OutfielderStats>{
    //attributes
    private int noTackles = 0;
    private int noPasses = 0;
    private int noShots = 0;
    private int noAssists = 0;
    private int noGoals = 0;

    //constructor
    public OutfielderStats(Player p){
        super(p);
    }


    //methods
    @Override
    public void updateStats(Match m){

        //actualizamos los goles
        for(int i = 0; i < m.getSizeListHomeScorers(); i++){

            if(m.getHomeScorer(i) == player.getName()){
                noGoals += 1;
            }        
        }
        
        for(int i = 0; i < m.getSizeListAwayScorers(); i++){

            if(m.getAwayScorer(i) == player.getName()){
                noGoals += 1;
            }
        }
        
        //generamos aleatoriamente stats generales
        noTackles += player.random.nextInt(7);
        noPasses += player.random.nextInt(10);
        noShots += player.random.nextInt(4);
        noAssists += player.random.nextInt(3);

        noMatches += 1;

    }

    @Override
    public void printStatsPlayer(){
        System.out.println( player.getName() + "--> " + "Matches: " + noMatches + ", Tackles: " + noTackles + ", Passes: " + noPasses 
        + ", " + "Shots: " + noShots + ", " + "Assists: " + noAssists + ", " + "Goals: " + noGoals);
    }


    @Override
    public int compareTo(OutfielderStats other) {

        //miramos quien a maracado más goles
        if(noGoals < other.noGoals) return 1;     //menos goles
        else if (noGoals > other.noGoals)return -1;  //mas goles
        else return 0;    //mismos goles
    }

}
