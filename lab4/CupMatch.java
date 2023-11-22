import java.util.LinkedList;

public class CupMatch extends Match {
    //constructor
    public CupMatch(Team h,Team a){
        super(h,a);
    }
    
    //methods
    @Override
    public void simulateMatch(){
        
        //Generamos los goles de cada equipo
        int n = 6;
        int m = 6;
        homeGoals = random.nextInt(n);
        awayGoals = random.nextInt(m);

        //Comprobamos que no queden empate
        
        System.out.println("Home goals: " + homeGoals + "      Away goals: " + awayGoals);
        if(homeGoals == awayGoals){
            
            System.out.println("Tie, extra time begins: ");
            homeGoals += random.nextInt(3);
            awayGoals += random.nextInt(3);
            System.out.println("Home goals: " + homeGoals + "      Away goals: " + awayGoals);
            if(homeGoals == awayGoals){
                System.out.println("Tie, penalties: ");

                while(homeGoals == awayGoals){
                    homeGoals += random.nextInt(n);
                    awayGoals += random.nextInt(m);
                }
                System.out.println("Home goals: " + homeGoals + "      Away goals: " + awayGoals);
            }
        }

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
}
