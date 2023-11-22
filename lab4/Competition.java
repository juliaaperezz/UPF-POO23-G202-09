import java.util.Collections;
import java.util.LinkedList;

public class Competition {
    
    //attributes
    protected String name;
    protected Gender gender;
    protected Country country;
    protected LinkedList <Team> teams;
    protected LinkedList <Match> matches;
    protected boolean clubs;  // 0 = club competitions ; 1 = international competitions

    protected int counterTeams = 0;
    protected int counterMatches = 0;


    //constructor 
    public Competition(String n, Country c, Gender g, boolean cl){
        name = n;
        country = c;
        gender = g;
        clubs = cl;

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

    public LinkedList<Team> getListTeams(){
        return teams;
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

    public LinkedList<OutfielderStats> getOutfielderStats(){

        LinkedList<OutfielderStats> listOutfilderstStats = new LinkedList<OutfielderStats>();
        int counter = 0;

        for(int i = 0; i < getNumTeams(); i++){
            Team t = getTeam(i);
            
            for(int j = 0; j < t.getNumPlayers(); j++){
                Player p = t.getPlayer(j);

                if(p instanceof Outfielder){
                    OutfielderStats o = (OutfielderStats)p.getStats(this);
                    listOutfilderstStats.add(counter, o);
                    counter++;
                }
            }
        }
        return listOutfilderstStats;
    }


    //methods
    public void addTeam(Team t){
        //si clubs es international competitions y team es un nationalTeam(jugadores son del mismo pais)
        if(clubs == true && t instanceof NationalTeam){     
             if (t.getGender() == Gender.HOMBRE && gender == Gender.HOMBRE) {  
                teams.add(counterTeams, t);
                counterTeams++;
                System.out.println(t.getName() + " added sucessfully");
            } 
            else if(t.getGender() == Gender.MUJER && gender == Gender.MUJER){
                teams.add(counterTeams, t);
                counterTeams++;
                System.out.println(t.getName() + " added sucessfully");
            }
            else if((t.getGender() == Gender.HOMBRE || t.getGender() == Gender.MUJER) && gender == Gender.MIXTO){
                teams.add(counterTeams, t);
                counterTeams++;
                System.out.println(t.getName() + " added sucessfully");
            }
            else {
                System.out.println(t.getName() + " can not be added due to their gender type.");
            }
        }
        
        //si clubs es club competitions y team no es nationalTeam(nos da igual de que país son los jugadores))
        else if(clubs == false && !(t instanceof NationalTeam)){
            if (t.getGender() == Gender.HOMBRE && gender == Gender.HOMBRE) {  
                teams.add(counterTeams, t);
                counterTeams++;
                System.out.println(t.getName() + " added sucessfully");
            } 
            else if(t.getGender() == Gender.MUJER && gender == Gender.MUJER){
                teams.add(counterTeams, t);
                counterTeams++;
                System.out.println(t.getName() + " added sucessfully");
            }
            else if((t.getGender() == Gender.HOMBRE || t.getGender() == Gender.MUJER) && gender == Gender.MIXTO){
                teams.add(counterTeams, t);
                counterTeams++;
                System.out.println(t.getName() + " added sucessfully");
            } 
            else {
                System.out.println(t.getName() + " can not be added due to their gender type.");
            }
        }
        else {
            System.out.println(t.getName() + " can not be added due to the type of competition.\n");
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
        
    }

    public void simulateMatches(){
        for(int i = 0; i < counterMatches; i++){

            //simulamos partido
            Match m = getMatch(i);
            m.simulateMatch();

            //actualizamos stats de los equipos
            m.getHomeTeam().updateStatsTeam(m, this);
            m.getAwayTeam().updateStatsTeam(m, this);

            
            //imprimimos las stats del partido jugado
            System.out.println("\n _________________________________________________________" );
            System.out.println("\nMatch " + (i + 1));
            m.printMatch();
            m.getHomeTeam().getStats(this).printStats();
            m.getAwayTeam().getStats(this).printStats();;


            //imprimimos stats de los jugadores
            System.out.println("\nStats match " + (i + 1));
            System.out.println(m.getHomeTeam().getName() + " players:");
            for (int j = 0; j < m.getHomeTeam().getSizeListPlayers(); j++) {
                Player player = m.getHomeTeam().getPlayer(j);
                player.getStats(this).printStatsPlayer();
                
            }

            System.out.println("\n" + m.getAwayTeam().getName() + " players:");
            for (int j = 0; j < m.getAwayTeam().getSizeListPlayers(); j++) {
                Player player = m.getAwayTeam().getPlayer(j);
                player.getStats(this).printStatsPlayer();
            }

        }
    }

    public void printMatches(){
        System.out.println("The matches in this league are: \n");
        for(int i = 0; i < matches.size(); i++){
            Match m = matches.get(i);
            System.out.println((i+1) + ": " + m.getHomeTeam().getName() + " --> Home team: " + m.getGoalsHome() + "   " 
            + m.getAwayTeam().getName() + " --> Away team: " + m.getGoalsAway() );
        }
        System.out.println();
    }

    public void printGoalsScorers(int k){
        LinkedList<OutfielderStats> outfielders = getOutfielderStats();

        //ordenamos los jugadores
        Collections.sort(outfielders);
        
        if( k > outfielders.size()){
            System.out.println( "Not enough players, this is the current list: \n");
            //imprimimos la lista
            for(int i = 0; i < outfielders.size(); i++){
                outfielders.get(i).printStatsPlayer();
            }
        }
        else{
            //imprimimos las stats de los k jugadores
            System.out.println( "The best "+ k +" goal scorers of this competition are: \n");
            for(int i = 0; i < k; i++){
                outfielders.get(i).printStatsPlayer();
            }
        }
    }
}
