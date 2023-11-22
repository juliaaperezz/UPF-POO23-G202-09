import java.util.LinkedList;
import java.util.HashMap;

public class Team {
    
    //attributes
	protected String name;
    protected Gender gender;
    protected Country country;
    protected LinkedList <Player> players;  // lista donde cada elemento es una instancia

    protected int counterPlayer = 0;
    
    protected HashMap< Competition, TeamStats> statsTeam;

    //constructor
    public Team(String n, Country c, Gender g) {
        name = n;
        country = c;
        gender = g;

        players = new LinkedList<Player>();

        statsTeam = new HashMap<Competition, TeamStats>();
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

    public TeamStats getStats( Competition c){
        return statsTeam.get(c);
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

    
    public void updateStatsTeam(Match m, Competition c){
        
        //miramos si hay estadisticas asociadas a la competición
        if (statsTeam.containsKey(c) == false){

            // utilizamos this para coger este team
            TeamStats teamSt = new TeamStats(this);

            statsTeam.put(c, teamSt);
        }

        //actualizamos las estadisticas del equipo
        statsTeam.get(c).updateStats(m);
        
        //actualizamos estadisticas de cada jugador del equipo
        for(int i = 0;  i < getNumPlayers() ; i++){
            Player p = getPlayer(i);
            p.updateStatsPlayer(m,c);
        }

    }

}