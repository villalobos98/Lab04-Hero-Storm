package heroes;
/**
 * @author Isaias Villalobos
 * Our glass cannon damage class, the berserker. Berserkers have a low amount of hit points
 * but deal the most amount of damage (in comparison to the other roles).
 */
import game.Team;

public class Berserker extends Hero {
    protected static int BERSERKER_HIT_POINTS = 30;
    protected static int DAMAGE_AMOUNT = 20;

    /**
     * @param team team of heroes.
     */
    protected Berserker(Team team) {
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BERSERKER_HIT_POINTS);
    }
    /**
     * @param enemy hero that is enemy.
     */
    public void attack(Hero enemy) {
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * @return role of the hero, berserker.
     */
    @Override
    public Heroes.Role getRole() {
        return Heroes.Role.BERSERKER;
    }


}
