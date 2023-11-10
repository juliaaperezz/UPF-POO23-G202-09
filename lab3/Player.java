import java.util.Random;

public class Player {

    //attributes
	protected boolean female;  // men = FALSE , female = TRUE
    protected String name;
    protected int age;
    protected Country nationality;
    protected int noMatches = 0;
    
    protected Random random;

    
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

    }

    public void printStatsPlayer(){
        
    }
    
    

}
