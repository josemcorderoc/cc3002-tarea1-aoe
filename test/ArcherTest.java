package test;

import ageofempires.units.Archer;

import org.junit.*;
import static org.junit.Assert.*;

public class ArcherTest extends AbstractAttackerTest {

    private Archer attackerArcher;
    private Archer attackerArcherNoAP;
    private Archer attackerArcherDead;

    @Before
    public void setUp(){
        super.setUp();
        attackerArcher = new Archer(100,200);
        attackerArcherNoAP = new Archer(100,0);
        attackerArcherDead = new Archer(0,100);
    }

    @Test
    public void testEquals(){
        assertFalse(attackerArcher.equals(new Archer(500, 200)));
        assertFalse(attackerArcher.equals(attackerArcherNoAP));
        assertFalse(attackerArcher.equals(victimMonk1));
    }

    /**
     * Test how does this entity interact with archer units
     */
    @Override
    void testInteractWithArcher() {
        for (Archer archer : archerList) {
            attackerArcher.interactWith(archer);
        }
        assertTrue(victimArcher1.isAlive());
        assertFalse(victimArcher2.isAlive());
        assertFalse(victimArcher3.isAlive());
        assertFalse(victimArcherDead.isAlive());
    }

    /**
     * Test how does this entity interact with cavalry units
     */
    @Override
    void testInteractWithCavalry() {


    }

    /**
     * Test how does this entity interact with infantry units
     */
    @Override
    void testInteractWithInfantry() {

    }

    /**
     * Test how does this entity interact with monk units
     */
    @Override
    void testInteractWithMonk() {

    }

    /**
     * Test how does this entity interact with siege units
     */
    @Override
    void testInteractWithSiege() {

    }

    /**
     * Test how does this entity interact with villager units
     */
    @Override
    void testInteractWithVillager() {

    }

    /**
     * Test how does this entity interact with barracks buildings
     */
    @Override
    void testInteractWithBarracks() {

    }

    /**
     * Test how does this entity interact with castle buildings
     */
    @Override
    void testInteractWithCastle() {

    }

}
