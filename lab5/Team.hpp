
#ifndef _TEAM_
#define _TEAM_

#include "Country.hpp"
#include "Player.hpp"

class Team {
	
public:

	enum Gender { MALE, FEMALE, MIXED };

private:

	std::string name;
    Country * country;
    Gender gender;
    std::list<Player *> players;
	
public:

	Team(std::string n, Country * c, Gender g) {
		name = n;
		country = c;
		gender = g;
	}
	
	std::string getName() {
        return name;
    }

    Country * getCountry() {
        return country;
    }

    Gender getGender() {
        return gender;
    }

    std::list<Player *> & getPlayers() {
        return players;
    }

    int getSizeTeam(){
        return players.size();
    }

    Player *getPlayer(int index) {
        if (index >= 0 && index < players.size()) {
            auto it = std::next(players.begin(), index);
            return *it;
        }
        return nullptr;  // O lanzar una excepción, dependiendo de tus requisitos
    }

    void addPlayer(Player * p) {
        if ((gender == Gender::MALE && !p->isFemale()) ||
            (gender == Gender::FEMALE && p->isFemale()) ||
            gender == Gender::MIXED)
            players.push_back(p);
    }
    
};

#endif

