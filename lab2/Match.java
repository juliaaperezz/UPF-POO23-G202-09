import java.util.LinkedList;
import java.util.Random;


public class Match {
    
    //attributes
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals = 0;
    private int awayGoals = 0;
    private LinkedList <String> homeScorers;
    private LinkedList <String> awayScorers;
    private Random random;


    //constructor 
    public Match(Team h,Team a){
        homeTeam = h;
        awayTeam = a;

        random = new Random();

        homeScorers = new LinkedList<String>();
        awayScorers = new LinkedList<String>();
    }

    //getters
    public Team getHomeTeam(){
        return homeTeam;
    }
    public Team getAwayTeam(){
        return awayTeam;
    }

    public int getGoalsHome(){
        return homeGoals;
    }

    public int getGoalsAway(){
        return awayGoals;
    }

    public int getSizeListHomeScorers(){
        return homeScorers.size();
    }

    public int getSizeListAwayScorers(){
        return awayScorers.size();
    }

    public  String getHomeScorer(int index){
        return homeScorers.get(index);
    }

    public  String getAwayScorer(int index){
        return awayScorers.get(index);
    }

    public LinkedList<String> getListHomeScorers(){
        return homeScorers;
    }

    public LinkedList<String> getListAwayScorers(){
        return awayScorers;
    }


    //methods
    public void simulateMatch(){
        
        //Generamos los goles de cada equipo
        int n = 6;
        int m = 6;
        homeGoals = random.nextInt(n);
        awayGoals = random.nextInt(m);


        //Distribuimos de manera aleatoria los goles
        for(int i = 0; i < homeGoals; i++){
            int randomindex = random.nextInt(homeTeam.getSizeListPlayers());
            Player p = homeTeam.getPlayer(randomindex);

            homeScorers.add(i, p.getName());
        }

        for(int i = 0; i < awayGoals; i++){
            int randomindex = random.nextInt(awayTeam.getSizeListPlayers());            
            Player p = awayTeam.getPlayer(randomindex);

            awayScorers.add(i, p.getName());
        }

    } 


    public void printMatch(){
        System.out.println(getHomeTeam().getName() + " --> Home team: " + getGoalsHome() + "\n" 
        + getAwayTeam().getName() + " --> Away team: " + getGoalsAway() + "\n");
        System.out.println("Home scorers: " + getListHomeScorers() + "\n" + "Away scorers: " + getListAwayScorers() + "\n\n");

    }
}
