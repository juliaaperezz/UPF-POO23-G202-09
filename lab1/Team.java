import java.util.LinkedList;

public class Team {
    

    //Attributes
	private String name;
    private Gender gender;
    private Country country;
    private LinkedList <Player> players;  // lista donde cada elemento es una instancia
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;

    private static int counterPlayer = 0;



    //Constructor
    public Team(String n, Country c, Gender g) {
        name = n;
        country = c;
        gender = g;

        players = new LinkedList<Player>();
    }

    //Methods
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry(){
        return country;
    }

    public void addPlayer(Player p){
        if (p.isFemale() == false && gender == Gender.HOMBRE) {  
            players.add(counterPlayer,p);
            Team.counterPlayer ++;
            System.out.println(p.getName() + " added sucessfully");
            

        } else if(p.isFemale() == true && gender == Gender.MUJER){
            players.add(counterPlayer,p);
            Team.counterPlayer ++;
            System.out.println(p.getName() + " added sucessfully");

        }
        else if((p.isFemale() == true || p.isFemale() == false) && gender == Gender.MIXTO){
            players.add(counterPlayer,p);
            Team.counterPlayer ++;
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
                    Team.counterPlayer --;
                    System.out.println(p.getName() + " removed sucessfully");
                }
            }
            

        } else if(p.isFemale() == true && gender == Gender.MUJER){
            for(int i = 0; i < counterPlayer; i++){ 
                
                if( p.getName() == players.get(i).getName()){
                    players.remove(i);
                    Team.counterPlayer --;
                    System.out.println(p.getName() + " removed sucessfully");
                }  
            }

        } else if(gender == Gender.MIXTO) {
            for(int i = 0; i < counterPlayer; i++){ 
                
                if( p.getName() == players.get(i).getName()){
                    players.remove(i);
                    Team.counterPlayer --;
                    System.out.println(p.getName() + " removed sucessfully");
                }
            }
        } else {
            System.out.println("This player doesn't belong to the team.");
        }
    }

    public void playMatch(int scored, int against){
        goalsScored += scored;
        goalsAgainst += against;

        if(scored > against){
            noWins +=1;
        } 
        else if (scored < against){
            noLosses +=1;
        }
        else {
            noTies +=1;
        }
        noMatches +=1;
    }

    public void printStats(){
        System.out.println("Matches: " + noMatches + "\n" + "Wins: " + noWins + "\n" + "Ties: " + noTies + "\n" + "Losses: " + noLosses + "\n" + "Goals scored: " + goalsScored + "\n" + "Goals against: " + goalsAgainst);
    }

    

}
