import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Cup extends Competition{

    //attributes

    private LinkedList<Team>[] tr;
    private LinkedList<Match>[] mr;

    private int noRounds = 0;

    //Constructor
    public Cup(String n, Country c, Gender g, boolean cl){
        super(n,c,g, cl);

        //inicializamos matrices
        tr = (LinkedList<Team>[]) new LinkedList<?>[20];  
        mr = (LinkedList<Match>[]) new LinkedList<?>[20];

    }
    
    //getters
    public LinkedList<Team> getRoundTeams(int index){
        return tr[index];
    }
    
    public LinkedList<Match> getRoundMatches(int index){
        return mr[index];
    }
    
    public int getTeamsSize(int index){
        return tr[index].size();
    }

    public int getMatchesSize(int index){
        return mr[index].size();
    }

    public int getNumRounds(){
        return noRounds;
    }


    //methods
    @Override
    public void generateMatches(){
        
        int numTeams = getTeamsSize(noRounds);
        LinkedList<Team> winners = new LinkedList<>();
        LinkedList<Match> matches = new LinkedList<>();

        int numMatches = 1;

        System.out.println("\n ____________________________________________________________________" );
        System.out.println("\n\nRound " + (noRounds + 1)  + ":");

        
        //creamos y simulamos los partidos de la ronda
        //--------------------------------------------------------------------------
        //falta arreglar en el caso que haya equipos impares
        for (int i = 0; i < numTeams; i += 2) {
            
            //caso en que el número de equipos sea impar
            //miramos si en el siguiente indice que intentará acceder es más grande que la lista de teams
            if((i+1) == numTeams){
                //añadimos el equipo a la siguiente ronda pero no generamos stats ya que no ha jugado
                winners.add(tr[noRounds].get(i));
            }

            //sino jugamos el partido
            else{
                Team homeTeam = tr[noRounds].get(i);
                Team awayTeam = tr[noRounds].get(i + 1);

                CupMatch match = new CupMatch(homeTeam, awayTeam);
                matches.add(match);

                // simulamos partido
                System.out.println("Match " + numMatches );
                match.simulateMatch();

                // añadimos ganador a la lista de ganadores
                if (match.getGoalsHome() > match.getGoalsAway()) {
                    winners.add(homeTeam);
                } else {
                    winners.add(awayTeam);
                }

                //actualizamos stats clases
                //actualizamos stats de los equipos
                match.getHomeTeam().updateStats(match);
                match.getAwayTeam().updateStats(match);

                //actualizamos stats jugadores
                for(int j = 0;  j < match.getHomeTeam().getNumPlayers() ; j++){
                    Player p = match.getHomeTeam().getPlayer(j);
                    p.updateStatsPlayer(match);
                }
                for(int j = 0; j < match.getAwayTeam().getNumPlayers(); j++){
                    Player p = match.getAwayTeam().getPlayer(j);
                    p.updateStatsPlayer(match);
                }

                //imprimimos las stats del partido jugado
                System.out.println("\n ______________________________________" );
                System.out.println("\nMatch " + (numMatches));
                match.printMatch();
                match.getHomeTeam().printStats();
                match.getAwayTeam().printStats();

                //imprimimos stats de los jugadores
                System.out.println("\nStats match " + (numMatches));
                System.out.println(match.getHomeTeam().getName() + " players:");
                for (int j = 0; j < match.getHomeTeam().getSizeListPlayers(); j++) {
                    Player player = match.getHomeTeam().getPlayer(j);
                    player.printStatsPlayer();
                    
                }

                System.out.println("\n" + match.getAwayTeam().getName() + " players:");
                for (int j = 0; j < match.getAwayTeam().getSizeListPlayers(); j++) {
                    Player player = match.getAwayTeam().getPlayer(j);
                    player.printStatsPlayer();
                }

                //actualizamos el numero de matches
                numMatches++;
            }
            
        }

        //añadimos los partidos de la ronda a la matriz de matches
        mr[noRounds] = matches;

        //actualizamo las rondas
        noRounds++;
    
        // añadimos los teams que han ganado a la siguiente ronda de la matriz de teams
        tr[noRounds] = winners;

    }




    @Override
    public void simulateMatches(){
        
        //si es la primera ronda 
        if (noRounds == 0) {
            // mezclamos la lista de teams para la primera ronda
            Collections.shuffle(teams);
            //añadimos todos los equipos en la matriz de equipos
            tr[noRounds] = teams;
        }

        while (getTeamsSize(noRounds) > 1) {

            //generamos y simulamos partidos de la ronda
            generateMatches(); 
            
        }

    }


    public void printBracket(){

    }



}
