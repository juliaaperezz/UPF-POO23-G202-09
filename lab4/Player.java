import java.util.Random;
import java.util.HashMap;

public class Player {

    //attributes
	protected boolean female;  // men = FALSE , female = TRUE
    protected String name;
    protected int age;
    protected Country nationality;
    
    protected Random random;

    protected HashMap< Competition, PlayerStats> statsPlayer;

    
    //constructor
    public Player( boolean f , String n, int a, Country nat) {
        female = f;
        name = n;
        age = a;
        nationality = nat;

        random = new Random();

        statsPlayer = new HashMap<Competition, PlayerStats>();

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
    public void updateStatsPlayer( Match m, Competition c){
        
    }

    public PlayerStats getStats( Competition c){
        return statsPlayer.get(c);
    }

}
