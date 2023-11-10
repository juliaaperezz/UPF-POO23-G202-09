import java.util.LinkedList;
import java.util.Random;


public class Match {
    
    //attributes
    protected Team homeTeam;
    protected Team awayTeam;
    protected int homeGoals = 0;
    protected int awayGoals = 0;
    protected LinkedList <String> homeScorers;
    protected LinkedList <String> awayScorers;
    protected Random random;


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

    public String getNameHome(){
        return homeTeam.getName();
    }

    public String getNameAway(){
        return awayTeam.getName();
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

        //Cogemos los outfilders de los teams para asiganr los goles
        LinkedList<Player> homeOutfilders = new LinkedList<Player>();
        LinkedList<Player> awayOutfilders = new LinkedList<Player>();

        //HomeTeam:
        for(int i = 0; i < homeTeam.getSizeListPlayers(); i++){
            Player p = homeTeam.getPlayer(i);
            int index = 0;
            if(p  instanceof Outfielder){
                homeOutfilders.add(index, p);
                index++;
            }
        }
        //AwayTeam:
        for(int i = 0; i < awayTeam .getSizeListPlayers(); i++){
            Player p = awayTeam.getPlayer(i);
            int index = 0;
            if(p  instanceof Outfielder){
                awayOutfilders.add(index, p);
                index++;
            }
        }

        //Distribuimos de manera aleatoria los goles en los jugadores outfilder
        for(int i = 0; i < homeGoals; i++){
            int randomindex = random.nextInt(homeOutfilders.size());
            Player p = homeOutfilders.get(randomindex);

            homeScorers.add(i, p.getName());
        }

        for(int i = 0; i < awayGoals; i++){
            int randomindex = random.nextInt(awayOutfilders.size());            
            Player p = awayOutfilders.get(randomindex);

            awayScorers.add(i, p.getName());
        }

    } 


    public void printMatch(){
        System.out.println(getHomeTeam().getName() + " --> Home team: " + getGoalsHome() + "\n" 
        + getAwayTeam().getName() + " --> Away team: " + getGoalsAway() + "\n");
        System.out.println("Home scorers: " + getListHomeScorers() + "\n" + "Away scorers: " + getListAwayScorers() + "\n\n");

    }
}
