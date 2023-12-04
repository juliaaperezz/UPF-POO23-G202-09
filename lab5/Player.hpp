#ifndef _PLAYER_
#define _PLAYER_

#include "Country.hpp"
class Match;

class Player{

protected:
    std::string name;
    Country * nationality;
    int age;
    bool female;
    int noMatches = 0;

public:
    Player(bool g, std::string n, int a, Country * nat) {
		female = g;
        name = n;
        age = a;
		nationality = nat;
    }

    //virtual ~Player() {} // destructor virtual para permitir la destrucción polimórfica

    //getter methods

    bool isFemale() {
        return female;
    }

    std::string getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    Country * getNationality() {
        return nationality;
    }

    // abstract methods
    virtual void updateStats(Match * m) = 0;
    virtual void printStats() = 0;

};

#endif
