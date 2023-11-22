public class GoalKeeper extends Player {
    

    //methods
    public GoalKeeper(boolean f , String n, int a, Country nat){
        super(f, n, a, nat);
    }

    @Override
    public void updateStatsPlayer(Match m, Competition c){
        //miramos si hay estadisticas del jugador asociadas a la competición
        if (statsPlayer.containsKey(c) == false){
        
            // y añadimos los nuevos stats asociados a la competición en el diccionario
            GoalkeeperStats playerSt = new GoalkeeperStats(this);
            statsPlayer.put(c, playerSt);
        }

        //actualizamos las estadisticas
        statsPlayer.get(c).updateStats(m);
    }
    
}
