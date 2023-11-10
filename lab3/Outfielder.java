public class Outfielder extends Player{
    //attributes
    private int noTackles = 0;
    private int noPasses = 0;
    private int noShots = 0;
    private int noAssists = 0;
    private int noGoals = 0;


    //methods
    public Outfielder(boolean f , String n, int a, Country nat){
        super(f, n, a, nat);
    }

    @Override
    public void updateStatsPlayer( Match m){
    
        //actualizamos los goles
        for(int i = 0; i < m.getSizeListHomeScorers(); i++){

            if(m.getHomeScorer(i) == getName()){
                noGoals += 1;
            }        
        }
        
        for(int i = 0; i < m.getSizeListAwayScorers(); i++){

            if(m.getAwayScorer(i) == getName()){
                noGoals += 1;
            }
        }
        
        //generamos aleatoriamente stats generales
        noTackles += random.nextInt(7);
        noPasses += random.nextInt(10);
        noShots += random.nextInt(4);
        noAssists += random.nextInt(3);

        noMatches += 1;

    }

    @Override
    public void printStatsPlayer(){
        System.out.println( getName() + "--> " + "Matches: " + noMatches + ", Tackles: " + noTackles + ", Passes: " + noPasses 
        + ", " + "Shots: " + noShots + ", " + "Assists: " + noAssists + ", " + "Goals: " + noGoals);
    }
}
