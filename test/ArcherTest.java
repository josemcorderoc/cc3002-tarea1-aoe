package test;

import ageofempires.units.Archer;

import org.junit.*;
import static org.junit.Assert.*;

public class ArcherTest extends AttackTest implements IEntityTest {

    private Archer attackerArcher;
    private Archer attackerArcherNoAP;
    private Archer attackerArcherDead;

    @Before
    public void setUp(){
        super.setUp();
        // initializations
        attackerArcher = new Archer(100,200);
        attackerArcherNoAP = new Archer(100,0);
        attackerArcherDead = new Archer(0,100);

        // interactions
        attackerArcher.interactWith(victimArcher1);
        attackerArcher.interactWith(victimCavalry1);
        attackerArcher.interactWith(victimInfantry1);
        attackerArcher.interactWith(victimMonk1);
        attackerArcher.interactWith(victimSiege1);
        attackerArcher.interactWith(victimVillager1);
        attackerArcher.interactWith(victimBarracks1);
    }

    @Test
    public void testEquals(){
        assertTrue(attackerArcher.equals(new Archer(500, 200)));
        assertFalse(attackerArcher.equals(attackerArcherNoAP));
        assertFalse(attackerArcher.equals(victimMonk1));
    }

    @Test
    public void testAttack(){
    }

    @Test
    public void killingTest(){
        // killed
        // not killed

    }
}
