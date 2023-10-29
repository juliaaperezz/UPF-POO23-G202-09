import java.util.Random;

public class Player {

    //attributes
	private boolean female;  // men = FALSE , female = TRUE
    private String name;
    private int age;
    private Country nationality;
    private int noMatches = 0;
    private int noTackles = 0;
    private int noPasses = 0;
    private int noShots = 0;
    private int noAssists = 0;
    private int noGoals = 0;
    private Random random;

    
    //constructor
    public Player( boolean f , String n, int a, Country nat) {
        female = f;
        name = n;
        age = a;
        nationality = nat;

        random = new Random();
    }

    //getters
    public boolean isFemale(){
        return female;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Country getNationality(){
        return nationality;
    }


    //methods
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


    public void printStatsPlayer(){
        System.out.println( getName() + "--> " + "Matches: " + noMatches + ", Tackles: " + noTackles + ", Passes: " + noPasses 
        + ", " + "Shots: " + noShots + ", " + "Assists: " + noAssists + ", " + "Goals: " + noGoals);
    }

}
