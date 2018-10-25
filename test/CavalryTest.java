package test;

import ageofempires.AbstractEntity;
import ageofempires.units.Cavalry;

import org.junit.*;
import static org.junit.Assert.*;

public class CavalryTest extends AbstractAttackerTest {

    private Cavalry attackerCavalry;
    private Cavalry attackerCavalryNoAP;
    private Cavalry attackerCavalryDead;

    @Before
    public void setUp(){
        super.setUp();
        // initializations
        attackerCavalry = new Cavalry(100,200);
        attackerCavalryNoAP = new Cavalry(100,0);
        attackerCavalryDead = new Cavalry(0,100);
        }

    /**
     * Test how does this entity interact with archer units
     */
    @Override
    void testInteractWithArcher() {

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

