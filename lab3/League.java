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

    }
}
