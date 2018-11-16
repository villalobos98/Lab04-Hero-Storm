package test;

import java.util.LinkedList;
import java.util.List;

import game.Team;
import heroes.Hero;
import heroes.Heroes.Role;
import heroes.Party;

/**
 * This is a party used only for testing.  It is incomplete in that it only
 * creates the party of heroes (without shuffling) and it gives access to the
 * collection of members.
 *
 * @author Sean Strout @ RIT CS
 */
public class TestParty implements Party {
    private List<Hero> heroes;
    private Team team;

    public TestParty(Team team) {
        this.team = team;
        this.heroes = new LinkedList<>();
        this.heroes.add(Hero.create(Role.BERSERKER, team, this));
        this.heroes.add(Hero.create(Role.HEALER, team, this));
        this.heroes.add(Hero.create(Role.TANK, team, this));
    }

    @Override
    public void addHero(Hero hero) {
        this.heroes.add(hero);
    }

    @Override
    public Hero removeHero() {
        // not implemented
        return this.heroes.remove(0);
    }

    @Override
    public int numHeroes() {
        // not implemented
        return this.heroes.size();
    }

    @Override
    public Team getTeam() {
        // not implemented
        return this.team;
    }

    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }
}
