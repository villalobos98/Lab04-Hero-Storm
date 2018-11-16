package heroes;
/**
 * @author Isaias Villalobos
 * Description: Represents a virtuous hero in the venerable game of storms.
 */

import game.Team;

public abstract class Hero {
    protected int health, maxHealth;
    protected String name;

    /**
     * @param name String
     * @param hitPoints number of hitpoints.
     */
    protected Hero(String name, int hitPoints) {
        this.name = name;
        this.health = hitPoints;
        this.maxHealth = hitPoints;
    }

    /**
     * @param enemy abstract method.
     */
    public abstract void attack(Hero enemy);

    public static Hero create(Heroes.Role role, Team team,
                              Party party) {
        switch (role) {
            case BERSERKER:
                return new Berserker(team);
            case HEALER:
                return new Healer(team, party);
            case TANK:
                return new Tank(team);
        }
        return null;
    }

    /**
     * @return the name for a hero
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return role of the specified hero
     */
    public abstract Heroes.Role getRole();

    /**
     * @return boolean if the hero is head.
     */
    public boolean hasFallen() {
        return health <= 0;
    }

    /**
     * @param amount integer hitpoints.
     */
    public void heal(int amount) {
        if (health + amount < maxHealth) {
            this.health += amount;
            System.out.println(getName() + " heals " + amount + " points");
        } else {
            this.health = maxHealth;
            System.out.println(getName() + " heals " + amount + " points");

        }
    }

    /**
     * @param amount amount that health will be affected.
     */
    public void takeDamage(int amount) {
        if (health - amount >= 0) {
            this.health -= amount;
            System.out.println(getName() + " takes " + amount + " damage");
        } else {
            this.health = 0;
            System.out.println(getName() + " takes " + amount + " damage");

        }
    }

    /**
     * @return to string representation of name role and health.
     */
    public String toString() {
        return (getName() + ", " + getRole() + ", " +
                health + "/" + maxHealth);
    }


}
