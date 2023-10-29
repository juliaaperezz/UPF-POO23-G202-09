import java.util.LinkedList;

public class League {
    
    //attributes
    private String name;
    private Gender gender;
    private Country country;
    private LinkedList <Team> teams;
    private LinkedList <Match> matches;

    private int counterTeams = 0;
    private int counterMatches = 0;


    //constructor 
    public League(String n, Country c, Gender g){
        name = n;
        country = c;
        gender = g;

        teams = new LinkedList<Team>();
        matches = new LinkedList<Match>();
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

    public Team getTeam(int index){
        return teams.get(index);
    }

    public int getNumTeams(){
        return teams.size();
    }

    public Match getMatch(int index){
        return matches.get(index);
    }

    public int getNumMatches(){
        return counterMatches;
    }


    //methods
    public void addTeam(Team t){
        if (t.getGender() == Gender.HOMBRE && gender == Gender.HOMBRE) {  
            teams.add(counterTeams, t);
            counterTeams++;
            System.out.println(t.getName() + " added sucessfully");
            

        } else if(t.getGender() == Gender.MUJER && gender == Gender.MUJER){
            teams.add(counterTeams, t);
            counterTeams++;
            System.out.println(t.getName() + " added sucessfully");

        }
        else if((t.getGender() == Gender.HOMBRE || t.getGender() == Gender.MUJER) && gender == Gender.MIXTO){
            teams.add(counterTeams, t);
            counterTeams++;
            System.out.println(t.getName() + " added sucessfully");

        } else {
            System.out.println(t.getName() + " can not be added due to their gender type.");
        }

    }
    
    public void removeTeam(Team t){
        if (t.getGender() == Gender.HOMBRE && gender == Gender.HOMBRE) {  
            
            for(int i = 0; i < counterTeams; i++){ 
                
                if( t.getName() == teams.get(i).getName()){
                    teams.remove(i);
                    counterTeams--;
                    System.out.println(t.getName() + " removed sucessfully");
                }
            }
            
        } else if(t.getGender() == Gender.MUJER && gender == Gender.MUJER){
            for(int i = 0; i < counterTeams; i++){ 
                
                if( t.getName() == teams.get(i).getName()){
                    teams.remove(i);
                    counterTeams--;
                    System.out.println(t.getName() + " removed sucessfully");
                }  
            }

        } else if(gender == Gender.MIXTO) {
            for(int i = 0; i < counterTeams; i++){ 
                
                if( t.getName() == teams.get(i).getName()){
                    teams.remove(i);
                    counterTeams--;
                    System.out.println(t.getName() + " removed sucessfully");
                }
            }
        } else {
            System.out.println("This team doesn't belong to the team.");
        }
    } 

    
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

    public void simulateMatches(){
        
        for(int i = 0; i < counterMatches; i++){

            //simulamos partido
            Match m = getMatch(i);
            m.simulateMatch();

            //actualizamos stats de los equipos
            m.getHomeTeam().updateStats(m);
            m.getAwayTeam().updateStats(m);

            //actualizamos stats jugadores
            for(int j = 0;  j < m.getHomeTeam().getNumPlayers() ; j++){
                Player p = m.getHomeTeam().getPlayer(j);
                p.updateStatsPlayer(m);
            }
            for(int j = 0; j < m.getAwayTeam().getNumPlayers(); j++){
                Player p = m.getAwayTeam().getPlayer(j);
                p.updateStatsPlayer(m);
            }

            //imprimimos las stats del partido jugado
            System.out.println("\n _________________________________________________________" );
            System.out.println("\nMatch " + (i + 1));
            m.printMatch();
            m.getHomeTeam().printStats();
            m.getAwayTeam().printStats();

            //imprimimos stats de los jugadores
            System.out.println("\nStats match " + (i + 1));
            System.out.println(m.getHomeTeam().getName() + " players:");
            for (int j = 0; j < m.getHomeTeam().getSizeListPlayers(); j++) {
                Player player = m.getHomeTeam().getPlayer(j);
                player.printStatsPlayer();
            }

            System.out.println("\n" + m.getAwayTeam().getName() + " players:");
            for (int j = 0; j < m.getAwayTeam().getSizeListPlayers(); j++) {
                Player player = m.getAwayTeam().getPlayer(j);
                player.printStatsPlayer();
            }

        }
    }

    public void printMatches(){
        System.out.println("The matches in these league are: " + matches);

    }

    public void printTable(){

    }

    public void printGoalsScorers(int k){

    }
}
