public class NationalTeam extends Team {
    //constructor
    public NationalTeam(String n, Country c, Gender g){
        super(n, c, g);

    }
    
    //methods
    public void addPlayer(Player p){
        if (p.getNationality() == country){
            if (p.isFemale() == false && gender == Gender.HOMBRE) {  
                players.add(counterPlayer,p);
                counterPlayer++;
                System.out.println(p.getName() + " added sucessfully");

            } else if(p.isFemale() == true && gender == Gender.MUJER){
                players.add(counterPlayer,p);
                counterPlayer++;
                System.out.println(p.getName() + " added sucessfully");

            }
            else if((p.isFemale() == true || p.isFemale() == false) && gender == Gender.MIXTO){
                players.add(counterPlayer,p);
                counterPlayer++;
                System.out.println(p.getName() + " added sucessfully");

            } else {
                System.out.println(p.getName() + " can not be added due to their gender.");
            }
            
        } else {
            System.out.println(p.getName() + "can not be added due to their nationality.\n");
        }
       
    }

}
