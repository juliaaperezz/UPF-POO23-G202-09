#include <iostream>
#include <cstdlib>  // para la función rand()
#include <ctime>    // para inicializar la semilla de rand()
#include "Goalkeeper.hpp"
#include "Outfielder.hpp"

int main(){


    // creamos países
    Country spain("Spain");
    Country brazil("Brazil");
    
    // creamos jugadores
    Outfielder *messi = new Outfielder(false, "Lionel Messi", 34, &brazil);
    Outfielder *benzema = new Outfielder(false, "Karim Benzema", 34, &brazil);
    Outfielder *engen = new Outfielder(true, "Ingrid Engen",25, &spain);
    Outfielder *paredes = new Outfielder(true, "Irene Paredes", 32, &spain);


    // crear equipos
    Team barcelona("FC Barcelona", &spain, Team::Gender::MALE);
    barcelona.addPlayer(messi);
    barcelona.addPlayer(benzema);


    Team barcelonafem("Barcelona Fem", &spain, Team::Gender::FEMALE);
    barcelonafem.addPlayer(engen);
    barcelonafem.addPlayer(paredes);

    
    // Crear un partido
    Match match(&barcelona, &barcelonafem);

    // Simular el partido
    match.simulateMatch();

    //hacemos update de los stats de los jugadores de cada equipo
    for(int i = 0; i <  barcelona.getSizeTeam(); i++){
        Player *p = barcelona.getPlayer(i);
        p->updateStats(&match);
    }

    for(int i = 0; i <  barcelonafem.getSizeTeam(); i++){
        Player *p = barcelonafem.getPlayer(i);
        p->updateStats(&match);
    }

    // Imprimir el resultado del partido
    std::cout << "Match Result:" << std::endl;
    match.printMatch();

    // Imprimir las estadísticas de cada jugador
    std::cout << "Player Statistics:" << std::endl;

    std::cout << "\nStats Team " << barcelona.getName() << ":\n";
    for (int i = 0; i < barcelona.getSizeTeam(); ++i) {
        Player *player = barcelona.getPlayer(i);
        if (player) {
            Outfielder *outfielder = dynamic_cast<Outfielder*>(player);
            if (outfielder) {
                outfielder->printStats();
            }
        }
    }

    std::cout << "\nStats team " << barcelonafem.getName() << ":\n";
    for (int i = 0; i < barcelonafem.getSizeTeam(); ++i) {
        Player *player = barcelonafem.getPlayer(i);
        if (player) {
            Outfielder *outfielder = dynamic_cast<Outfielder*>(player);
            if (outfielder) {
                outfielder->printStats();
            }
        }
    }

    //liberamos la memoria de los jugadores
    delete messi;
    delete benzema;
    delete engen;
    delete paredes;
    
    return 0;
}