public class GoalKeeper extends Player {
    //attributes
    private int noSaves = 0;
    private int noGoalsLet = 0;

    //methods
    public GoalKeeper(boolean f , String n, int a, Country nat){
        super(f, n, a, nat);
    }

    @Override
    public void updateStatsPlayer(Match m){
        
        //actualizamos stats
        for(int i = 0; i <  m.getHomeTeam().getSizeListPlayers(); i++){
            Player p = m.getHomeTeam().getPlayer(i);
            if(p.getName() == name){
                noGoalsLet += m.awayGoals;
                noSaves += random.nextInt(7); 
            }

        }
        
        for(int i = 0; i <  m.getAwayTeam().getSizeListPlayers(); i++){
            Player p = m.getAwayTeam().getPlayer(i);
            if(p.getName() == name){
                noGoalsLet += m.homeGoals;
                noSaves += random.nextInt(7); 
            }

        }

        noMatches += 1;

    }
    
    @Override
    public void printStatsPlayer(){
        System.out.println( getName() + "--> " + "Matches: " + noMatches + ", Goals let: " + noGoalsLet + ", Saves: " + noSaves);
    }


}
