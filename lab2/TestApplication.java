public class TestApplication {
    public static void main(String[] args){

        // Create countries
        Country spain = new Country("Spain");

        // Create teams
        Team barcelona = new Team("FC Barcelona", spain, Gender.HOMBRE);
        Team realMadrid = new Team("Real Madrid", spain, Gender.HOMBRE);
        Team barcelonafem = new Team("FC Barcelona Femenino", spain, Gender.MUJER);

        // Create players
        Player messi = new Player(false, "Lionel Messi", 34, spain);
        Player suarez = new Player(false, "Luis Suárez", 35, spain);
        Player ramos = new Player(false, "Sergio Ramos", 35, spain);
        Player benzema = new Player(false, "Karim Benzema", 34, spain);
        Player engen = new Player(true, "Ingrid Engen",25, spain);
        Player paredes = new Player(true, "Irene Paredes", 32, spain);

        // Add players to teams
        barcelona.addPlayer(messi);
        barcelona.addPlayer(suarez);

        realMadrid.addPlayer(ramos);
        realMadrid.addPlayer(benzema);

        barcelonafem.addPlayer(engen);
        barcelonafem.addPlayer(paredes);

        // Create a league
        League laLiga = new League("La Liga", spain, Gender.MIXTO);
        laLiga.addTeam(barcelona);
        laLiga.addTeam(realMadrid);
        laLiga.addTeam(barcelonafem);
        
        
        // Generate and simulate matches in the league
        laLiga.generateMatches();
        laLiga.simulateMatches();
       

        // Imprimimos los resultados finales de cada team y sus players
        System.out.println("\n\nFINAL STATS OF TEAMS:\n");

        for (int i = 0; i < laLiga.getNumTeams(); i++) {
            Team t = laLiga.getTeam(i);
            t.printStats();

            for(int j = 0; j < t.getNumPlayers(); j++){
                Player p = t.getPlayer(j);
                p.printStatsPlayer();
            }
            System.out.println("\n");

        }
    }
}
