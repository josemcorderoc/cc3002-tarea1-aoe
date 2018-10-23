package test;

import ageofempires.AbstractEntity;
import ageofempires.units.Cavalry;

import org.junit.*;
import static org.junit.Assert.*;

public class CavalryTest extends AttackTest {

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

        // interactions
        for (AbstractEntity entity1 : entitiesList1) {
            attackerCavalry.interactWith(entity1);
        }

        for (AbstractEntity entity2 : entitiesList1) {
            attackerCavalryNoAP.interactWith(entity2);
        }

        for (AbstractEntity entity3 : entitiesList1) {
            attackerCavalryDead.interactWith(entity3);
        }
    }

    @Test
    public void killingTest(){

        // killed
        assertFalse(entitiesList1[0].isAlive());

        // not killed
    }
}

