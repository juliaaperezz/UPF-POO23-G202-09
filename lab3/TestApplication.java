import java.util.Scanner;

public class TestApplication {
    public static void main(String[] args){

        // Create countries
        Country spain = new Country("Spain");
        Country germany = new Country("Geramny");
        

        // Create teams
        Team barcelona = new Team("FC Barcelona", spain, Gender.HOMBRE);
        Team realMadrid = new Team("Real Madrid", spain, Gender.HOMBRE);
        Team barcelonafem = new Team("FC Barcelona Femenino", spain, Gender.MUJER);
        NationalTeam upfFem = new NationalTeam("UPF Femenino", germany, Gender.MUJER);
        NationalTeam upc = new NationalTeam("UPC", spain, Gender.MUJER);

        // Create players
        Player messi = new Outfielder(false, "Lionel Messi", 34, spain);
        Player bartra = new Outfielder(false, "Marc Bartra", 29, spain);
        Player suarez = new GoalKeeper(false, "Luis Suárez", 35, spain);
        Player ramos = new Outfielder(false, "Sergio Ramos", 35, spain);
        Player ronaldo = new Outfielder(false, "Cristiano Ronaldo", 37, spain);
        Player benzema = new GoalKeeper(false, "Karim Benzema", 34, spain);
        Player engen = new Outfielder(true, "Ingrid Engen",25, spain);
        Player putellas = new Outfielder(true, "Alexia Putellas", 30, spain);
        Player paredes = new GoalKeeper(true, "Irene Paredes", 32, spain);

        Player perez = new Outfielder(true, "Julia Pérez",19, germany);
        Player carot = new Outfielder(true, "Cinta Carot", 20, germany);
        Player nunez = new GoalKeeper(true, "Carla Núñez", 19, germany);
        
        Player mas = new Outfielder(true, "Arnau Mas", 20, spain);
        Player aPerez = new Outfielder(true, "Albert Pérez", 20, spain);


        // Add players to teams
        barcelona.addPlayer(messi);
        barcelona.addPlayer(bartra);
        barcelona.addPlayer(suarez);

        realMadrid.addPlayer(ramos);
        realMadrid.addPlayer(ronaldo);
        realMadrid.addPlayer(benzema);

        barcelonafem.addPlayer(engen);
        barcelonafem.addPlayer(putellas);
        barcelonafem.addPlayer(paredes);

        upfFem.addPlayer(perez);
        upfFem.addPlayer(carot);
        upfFem.addPlayer(nunez);

        upc.addPlayer(mas);
        upc.addPlayer(aPerez);
        

        
        System.out.println ("\n Introduce the number of the competition you would like to play\n1. Cup\n2. League\n3. Group Play\n4. Exit");
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();

        while(num != 4){
            
            switch (num) { 
                case 1:
                    // Create a cup
                    Cup laCopa = new Cup("La Copa", spain, Gender.MIXTO, false);
                    laCopa.addTeam(barcelona);
                    laCopa.addTeam(realMadrid);
                    laCopa.addTeam(barcelonafem);
                    //laCopa.addTeam(upfFem);

                    //jugamos cup
                    laCopa.simulateMatches();
                    

                    // Imprimimos los resultados finales de cada team y sus players
                    System.out.println("___________________________________________________________________________________");
                    System.out.println("\n\nFINAL STATS OF THE CUP:\n");
                    System.out.println("WINNER: " + laCopa.getRoundTeams(laCopa.getNumRounds()).get(0).getName() + "\n");

                    for (int i = 0; i < laCopa.getNumTeams(); i++) {
                        Team t = laCopa.getTeam(i);
                        t.printStats();

                        for(int j = 0; j < t.getNumPlayers(); j++){
                            Player p = t.getPlayer(j);
                            p.printStatsPlayer();
                        }
                    System.out.println("\n");

                    }
                    break;
                case 2:
                    // Create a league
                    League laLiga = new League("La Liga", spain, Gender.MIXTO, false);
                    laLiga.addTeam(barcelona);
                    laLiga.addTeam(realMadrid);
                    laLiga.addTeam(barcelonafem);

                    //jugamos liga
                    laLiga.generateMatches();
                    laLiga.simulateMatches();

                    // Imprimimos los resultados finales de cada team y sus players
                    System.out.println("___________________________________________________________________________________");
                    System.out.println("\n\nFINAL STATS THE LEAGUE:\n");

                    for (int i = 0; i < laLiga.getNumTeams(); i++) {
                        Team t = laLiga.getTeam(i);
                        t.printStats();

                        for(int j = 0; j < t.getNumPlayers(); j++){
                            Player p = t.getPlayer(j);
                            p.printStatsPlayer();
                        }
                        System.out.println("\n");

                    }
                    break;

                case 3:
                    // Create a group play
                    GroupPlay elGrupo = new GroupPlay("Juego en equipo", spain, Gender.MIXTO, true);
                    League liga1 = new League("Liga 1", spain, Gender.MIXTO, false);
                    League liga2 = new League("Liga 2", spain, Gender.MIXTO, true);

                    //creamos ligas
                    liga1.addTeam(barcelona);
                    liga1.addTeam(realMadrid);
                    liga1.addTeam(barcelonafem);
                    
                    liga2.addTeam(upfFem);
                    liga2.addTeam(upc);

                    //añadimos ligas al grup
                    elGrupo.addLeague(liga1);
                    elGrupo.addLeague(liga2);
                    

                    //jugamos group play
                    elGrupo.simulateMatches();
                    

                    // Imprimimos los resultados finales de cada team y sus players
                    System.out.println("___________________________________________________________________________________");
                    System.out.println("\n\nFINAL STATS THE GROUP PLAY:\n");

                    //liga
                    for (int i = 0; i < elGrupo.getNoGroups(); i++) {
                        League l = elGrupo.getLeague(i);
                        System.out.println(elGrupo.getLeague(i).getName() +": ");

                        //equipos en la liga
                        for(int j = 0; j < l.getNumTeams(); j++){
                            Team t = l.getTeam(j);
                            t.printStats();

                            //jugadores de cada equipo
                            for(int k = 0; k < t.getNumPlayers(); k++){
                                Player p = t.getPlayer(k);
                                p.printStatsPlayer();
                            }
                            System.out.println("\n");
                        }


                    }
                    break;
                default:
                    System.out.println("You must introduce a number between [1-3].");
            }
            
            System.out.println ("\n Introduce the numberof the competition you would like to play\n1. Cup\n2. League\n3. Group Play\n4. Exit");
            entrada = new Scanner(System.in);
            num = entrada.nextInt();
        }
    }
}
