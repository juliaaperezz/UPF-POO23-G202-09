public class Player {
    //Attributes
	private boolean female;  // men = FALSE , female = TRUE
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;

    //Constructor
    public Player( boolean f , String n, int a, Country nat) {
        female = f;
        name = n;
        age = a;
        nationality = nat;
    }

    //Methods
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

    public void update( int t, int p, int s, int a, int g){
        noTackles += t;
        noPasses += p;
        noShots += s;
        noAssists += a;
        noGoals += g;
        noMatches += 1;
    }


    public void printStats(){
        System.out.println("Matches: " + noMatches + "\n" + "Tackles: " + noTackles + "\n" + "Passes: " + noPasses 
        + "\n" + "Shots: " + noShots + "\n" + "Assists: " + noAssists + "\n" + "Goals: " + noGoals);
    }

}
