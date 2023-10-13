public class TestApplication {
    public static void main(String[] args){
        Country country1 = new Country("Argentina");
        Country country2 = new Country("Spain");
        Country country3 = new Country("Colombia");
        
        Team team = new Team("FCB", country3, Gender.MUJER);
        
       
        
        Player player1 = new Player(true, "Maria", 20, country1);
        Player player2 = new Player(true, "Ana", 21, country3);
        Player player3 = new Player(true, "Claudia", 19, country2);
        Player player4 = new Player(false, "MarcB", 30, country2);

        

        //team

        team.addPlayer(player1);
        team.addPlayer(player3);
        team.addPlayer(player4);
        
    
        team.removePlayer(player1);
        
        team.addPlayer(player2);
        

        team.playMatch(3, 2);
        team.printStats();
        player3.update(2, 15, 2, 1, 1);
        player3.printStats();
        
        

    }

	
}
