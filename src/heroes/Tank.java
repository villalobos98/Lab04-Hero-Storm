package heroes;
/**
 * @author Isaias Villalobos
 * Description: Our ruggedly reliable damage sponge class. A tank has the most hitpoints and deal a moderate amount of damage.
 * When a tank is damaged by an enemy, the mitigate 10% of the damage they would normally take with their shield.
 */
import game.Team;

public class Tank extends Hero {
    protected static final int TANK_HIT_POINTS = 40;
    protected static final double SHIELD_DMG_MULTIPLIER = 0.9;
    protected static final int DAMAGE_AMOUNT = 15;

    /**
     * @param team crates a tank from the abstract class.
     */
    protected Tank (Team team){
        super(Heroes.getName(team, Heroes.Role.TANK), TANK_HIT_POINTS);
    }

    /**
     * @param amount Unlike the other classes, the tank mitigates the damage the are about to
     *               take by using their shield. Once this amount is adjusted,
     *               they should take damage in the same manner as the other classes
     */
    @Override
    public void takeDamage(int amount) {
        super.takeDamage( (int) (SHIELD_DMG_MULTIPLIER * amount) );
    }

    /**
     * @param enemy How much damage the tank does to the enemy hero.
     */
    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * @return get role of the tank hero.
     */
    @Override
    public Heroes.Role getRole() {
        return Heroes.Role.TANK;
    }
}
