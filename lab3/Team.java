import java.util.LinkedList;

public class Team {
    
    //attributes
	protected String name;
    protected Gender gender;
    protected Country country;
    protected LinkedList <Player> players;  // lista donde cada elemento es una instancia
    protected int noMatches = 0;
    protected int noWins = 0;
    protected int noTies = 0;
    protected int noLosses = 0;
    protected int  goalsScored = 0;
    protected int goalsAgainst = 0;


    protected int counterPlayer = 0;
    

    //constructor
    public Team(String n, Country c, Gender g) {
        name = n;
        country = c;
        gender = g;

        players = new LinkedList<Player>();
    }

    //getters
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry(){
        return country;
    }

    public int getSizeListPlayers(){
        return players.size();
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

    public int getNumPlayers(){
        return counterPlayer;
    }


    //methods
    public void addPlayer(Player p){
        if (p.isFemale() == false && gender == Gender.HOMBRE) {  
            players.add(counterPlayer,p);
            counterPlayer++;
            System.out.println(p.getName() + " added sucessfully");
            

        } else if(p.isFemale() == true && gender == Gender.MUJER){
            players.add(counterPlayer,p);
            counterPlayer++;
            System.out.println(p.getName() + " added sucessfully");

        }
        else if((p.isFemale() == true || p.isFemale() == false) && gender == Gender.MIXTO){
            players.add(counterPlayer,p);
            counterPlayer++;
            System.out.println(p.getName() + " added sucessfully");

        } else {
            System.out.println(p.getName() + " can not be added due to their gender.");
        }
    }

    public void removePlayer(Player p){
        if (p.isFemale() == false && gender == Gender.HOMBRE) {  
            
            for(int i = 0; i < counterPlayer; i++){ 
                
                if( p.getName() == players.get(i).getName()){
                    players.remove(i);
                    counterPlayer--;
                    System.out.println(p.getName() + " removed sucessfully");
                }
            }
            

        } else if(p.isFemale() == true && gender == Gender.MUJER){
            for(int i = 0; i < counterPlayer; i++){ 
                
                if( p.getName() == players.get(i).getName()){
                    players.remove(i);
                    counterPlayer--;
                    System.out.println(p.getName() + " removed sucessfully");
                }  
            }

        } else if(gender == Gender.MIXTO) {
            for(int i = 0; i < counterPlayer; i++){ 
                
                if( p.getName() == players.get(i).getName()){
                    players.remove(i);
                    counterPlayer--;
                    System.out.println(p.getName() + " removed sucessfully");
                }
            }
        } else {
            System.out.println("This player doesn't belong to the team.");
        }
    }

    
    public void updateStats(Match m){

        if(m.getHomeTeam().name == getName()){

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

        else if(m.getAwayTeam().name == getName()){

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
        System.out.println(getName() + ": Matches: " + noMatches + ", " + "Wins: " + noWins + ", " + "Ties: " + noTies + ", " + "Losses: " 
        + noLosses + ", " + "Goals scored: " + goalsScored + ", " + "Goals against: " + goalsAgainst + "\n");
    }

    

}

