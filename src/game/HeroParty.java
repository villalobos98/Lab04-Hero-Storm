package game;
/**
 * @author: Isaias Villalobos
 * Description: A party is a collection of non-fallen allies that represent a team.
 * The behavior of this collection is FIFO (a queue). The hero at the front of the queue is next up for a battle round.
 * If a hero is not defeated when battling in a round, they will be added to the back of the queue so they may combat again in the future.
 */
import heroes.Hero;
import heroes.Heroes;
import heroes.Party;
import java.util.*;

public class HeroParty implements Party {
    private Team team;
    private List<Hero> heroes;

    /**
     * @param team Type is Team
     * @param seed integer seed
     * Constructor: creates team, heroes, and adds them to the list.
     */
    public HeroParty(Team team, int seed) {

        this.team = team;
        this.heroes = new LinkedList<>();
        this.heroes.add(Hero.create(Heroes.Role.BERSERKER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.HEALER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.TANK, team, this));
        Collections.shuffle(this.heroes, new Random(seed));
    }

    /**
     * @param hero Add a hero to the back of the collection.
     */
    @Override
    public void addHero(Hero hero) {
        this.heroes.add(hero);
    }

    /**
     * @return Get all the undefeated heroes in the party.
     */
    @Override
    public Hero removeHero() {
        return this.heroes.remove(0);
    }

    /**
     * @return The team which this party is affiliated with.
     */
    @Override
    public int numHeroes() {
        return this.heroes.size();
    }

    /**
     * @return Get the number of non-fallen heroes.
     */
    @Override
    public Team getTeam() {
        return this.team;
    }

    /**
     * @return Remove the hero at the front of the collection.
     */
    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }

    /**
     * @return Returns a string representation of the party.
     */
    @Override
    public String toString()
    {
        String hero_string = team.name() + "\n";
        for(int i = 0; i<heroes.size(); i++) {
            Hero Hero = heroes.get(i);
            hero_string += Hero.toString() + "\n";
        }
            return hero_string;

    }

}
