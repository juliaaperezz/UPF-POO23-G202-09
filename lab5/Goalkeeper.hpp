#ifndef _GOALKEEPER_
#define _GOALKEEPER_

#include "Player.hpp"
#include "Match.hpp"

class Goalkeeper : public Player{

private:
    int noSaves;
    int noGoalsLet;

public:
    Goalkeeper(bool g, std::string n, int a, Country * nat) : Player(g, n, a, nat) {
		female = g;
        name = n;
        age = a;
		nationality = nat;

        // inicializar atributos
        noSaves = 0;
        noGoalsLet = 0;
	}

    void updateStats(Match *m) override {
    // Actualizamos estadísticas
    for (int i = 0; i < m->getTeamOne()->getPlayers().size(); i++) {
        Player *p = m->getTeamOne()->getPlayer(i);
        if (p->getName() == getName()) {
            noGoalsLet += m->getGoalTwo();
            noSaves += rand() % 7;
        }
    }

    for (int i = 0; i < m->getTeamTwo()->getPlayers().size(); i++) {
        Player *p = m->getTeamTwo()->getPlayer(i);
        if (p->getName() == getName()) {
            noGoalsLet += m->getGoalOne();
            noSaves += rand() % 7;
        }
    }

    noMatches += 1;
}

void printStats() override {
    std::cout << getName() << "--> Matches: " << noMatches << ", Goals let: " << noGoalsLet << ", Saves: " << noSaves << std::endl;
}



};
#endif
