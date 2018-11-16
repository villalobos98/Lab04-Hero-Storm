package game;
/**
 * @author: Isaias Villalobos
 * Description: A party is a collection of non-fallen allies that represent a team.
 * The behavior of this collection is FIFO (a queue). The hero at the front of the
 * queue is next up for a battle round. If a hero is not defeated when battling in a round,
 * they will be added to the back of the queue so they may combat again in the future.
 */

import heroes.Hero;
import heroes.Party;

/**
 * Constructor: Create dragon and lion hero party.
 */
public class HeroStorm {
    private static HeroParty dragon;
    private HeroParty lion;
    private int roundCounter = 1;

    public HeroStorm(int dragonSeed, int lionSeed) {
        HeroParty Dragon = new HeroParty(Team.DRAGON, dragonSeed);
        this.dragon = Dragon;
        HeroParty Lion = new HeroParty(Team.LION, lionSeed);
        this.lion = Lion;
    }

    public void play() {
        while (dragon.numHeroes() > 0 && lion.numHeroes() > 0) {
            System.out.println();
            System.out.println("Battle #" + roundCounter);
            System.out.println("=========");
            System.out.println(dragon.toString());
            System.out.println(lion.toString());

            Party attackerParty;
            Party defenderParty;

            if (roundCounter % 2 == 0) {
                attackerParty = lion;
                defenderParty = dragon;
            } else {
                attackerParty = dragon;
                defenderParty = lion;
            }

            Hero attacking_hero = attackerParty.removeHero();
            Hero defending_hero = defenderParty.removeHero();
            System.out.println("** " + attacking_hero.getName() + " vs " + defending_hero.getName());

            attacking_hero.attack(defending_hero);
            if (!defending_hero.hasFallen()) {
                defending_hero.attack(attacking_hero);
            }

            roundCounter += 1;

            if (!attacking_hero.hasFallen()) {
                attackerParty.addHero(attacking_hero);
            } else {
                System.out.println(attacking_hero.getName() + " has fallen.");
            }

            if (!defending_hero.hasFallen()) {
                defenderParty.addHero(defending_hero);
            } else {
                System.out.println(defending_hero.getName() + " has fallen.");
            }

        }
        if (dragon.numHeroes() == 0) {
            System.out.println("Lion team wins.");
        } else {
            System.out.println("Dragon team wins.");
        }
    }

    /**
     * @param args command line arguments.
     * Only valid if there are two command line arguments and then runs the game.
     */
    public static void main(String[] args) {
        if (args.length >= 2) {
            HeroStorm game = new HeroStorm(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]));
            game.play();
        }

    }
}
