package heroes;
/**
 * @author Isaias Villalobos
 * Our dependable medic healing class. Healers have a moderate amount of hit points, but do the least amount of damage.
 * When attacking, however, the healer will heal all non-defeated party members for a decent amount (including themselves).
 */

import game.Team;

public class Healer extends Hero{
    protected static int DAMAGE_AMOUNT = 10;
    protected static final int HEAL_AMOUNT = 10;
    protected static final int HEALER_HIT_POINTS = 35;
    private Party party;

    /**
     * @param team the type team
     * @param party the party of heroes
     */
    protected Healer(Team team, Party party){
        super(Heroes.getName(team, Heroes.Role.HEALER), HEALER_HIT_POINTS);
        this.party = party;
    }

    /**
     * @param enemy hero enemy.
     * Heals the healer first and then the team.
     */
    @Override
    public void attack(Hero enemy) {
        this.heal(HEAL_AMOUNT);
        for(Hero i: party.getHeroes())
            i.heal(HEAL_AMOUNT);
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * @return returns the role of healer.
     */
    @Override
    public Heroes.Role getRole() {
        return Heroes.Role.HEALER;
    }
}
