#ifndef _OUTFIELDER_
#define _OUTFIELDER_

#include "Player.hpp"
#include "Match.hpp"

class Outfielder : public Player{

private:
    int noTackles;
    int noPasses;
    int noShots;
    int noAssists;
    int noGoals; 

public:
    Outfielder(bool g, std::string n, int a, Country  *nat) : Player(g, n, a, nat) {
		female = g;
        name = n;
        age = a;
		nationality = nat;

        // inicializar atributos
        noMatches = 0;
        noTackles = 0;
        noPasses = 0;
        noShots = 0;
        noAssists = 0;
        noGoals = 0;
	}

    //getters
    int getnoGoals() {
        return noGoals;
    }

    //methods
    void updateStats(Match* m) override {
        
        // actualizamos los goles
        for (Player *scorer : m->getScorersOne()) {
            Outfielder *outfielderScorer = dynamic_cast<Outfielder*>(scorer);
            if (outfielderScorer != nullptr && outfielderScorer->getName() == getName()) {
                noGoals += 1;
            }
        }

        for (Player *scorer : m->getScorersTwo()) {
            Outfielder *outfielderScorer = dynamic_cast<Outfielder*>(scorer);
            if (outfielderScorer != nullptr && outfielderScorer->getName() == getName()) {
                noGoals += 1;
            }
        }

        // generamos aleatoriamente estadísticas generales
        noTackles += rand() % 7;
        noPasses += rand() % 10;
        noShots += rand() % 4;
        noAssists += rand() % 3;

        noMatches += 1;
    }
    
    void printStats() override{
        std::cout << getName() << "--> Matches: " << noMatches << ", Tackles: " << noTackles << ", Passes: " << noPasses
            << ", Shots: " << noShots << ", Assists: " << noAssists << ", Goals: " << noGoals << std::endl;
    }

};
#endif
