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


    //methods
    public void addTeam(Team t){
        //si clubs es international competitions y team es un nationalTeam(jugadores son del mismo pais)
        if(clubs == true && t instanceof NationalTeam){     
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
        
        //si clubs es club competitions y team no es nationalTeam(nos da igual de que país son los jugadores))
        else if(clubs == false && !(t instanceof NationalTeam)){
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
        else{
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

    //hay que cambiarla
    public void printMatches(){
        System.out.println("The matches in these league are: " + matches);

    }

    public void printTable(){

    }

    public void printGoalsScorers(int k){

    }
}
