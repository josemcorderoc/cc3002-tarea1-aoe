package test;

import ageofempires.buildings.Barracks;
import ageofempires.units.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Test the Siege class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class SiegeTest extends AbstractAttackerTest {

    private Siege siege;
    private Siege siege2;
    private Siege siegeNoAP;
    private Siege siegeDead;

    /**
     * Initializes siege for testing
     */
    @Before
    void setUp(){
        super.setUp();
        siege = new Siege(100,100);
        siege2 = new Siege(200,100);
        siegeNoAP = new Siege(100,0);
        siegeDead = new Siege(0,100);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    @Override
    public void testEquals(){
        assertEquals(siege, siege);
        assertEquals(siege, new Siege(100,100));
        assertEquals(siege, victimSiegeToCompare);

        assertNotEquals(siege, new Siege(250, 200));
        assertNotEquals(siege, siegeNoAP);
        assertNotEquals(siege, victimMonk1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(siege.isAlive());
        assertFalse(siegeDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, siege.getCurrentHP(),0.0);
        assertEquals(200, siegeNoAP.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        siege.setCurrentHP(56.9f);
        assertEquals(56.9, siege.getCurrentHP(),0.0);
        siege.setCurrentHP(245);
        assertEquals(245, siege.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(200, siege.getMaxHP(), epsilon);
        assertEquals(400, siegeNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        siege.setMaxHP(134.6f);
        assertEquals(134.6f, siege.getMaxHP(),0.0);
        siege.setMaxHP(54);
        assertEquals(54, siege.getMaxHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, siege.getAttackPoints(),0.0);
        assertEquals(0, siegeNoAP.getAttackPoints(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        siege.setAttackPoints(45.7f);
        assertEquals(45.7f, siege.getAttackPoints(), 0.0);
        siege.setAttackPoints(66);
        assertEquals(66,siege.getAttackPoints(), 0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        siege.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByArcher(attackerArcherDead);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByArcher(attackerArcher);
        assertEquals(20, siege.getCurrentHP(), epsilon);
        siege2.attackedByArcher(attackerArcher);
        assertEquals(120, siege.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        siege.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByCavalry(attackerCavalry);
        assertEquals(0, siege.getCurrentHP(), epsilon);
        siege2.attackedByCavalry(attackerCavalry);
        assertEquals(80, siege2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        siege.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByInfantry(attackerInfantry);
        assertEquals(0, siege.getCurrentHP(), epsilon);
        siege2.attackedByInfantry(attackerInfantry);
        assertEquals(80, siege2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        siege.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedBySiege(attackerSiegeDead);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedBySiege(attackerSiege);
        assertEquals(0, siege.getCurrentHP(), epsilon);
        siege2.attackedBySiege(attackerSiege);
        assertEquals(50, siege2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        siege.curedByMonk(attackerMonkNoAP);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.curedByMonk(attackerMonkDead);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.curedByMonk(attackerMonk);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.curedByMonk(attackerMonk);
        siege.curedByMonk(attackerMonk);
        assertEquals(100, siege.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        siege.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByCastle(attackerCastleDead);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege.attackedByCastle(attackerCastle);
        assertEquals(50, siege.getCurrentHP(), epsilon);
        siege2.attackedByCastle(attackerCastle);
        assertEquals(150, siege2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        siege.setCurrentHP(50);
        siege.handledByVillager(attackerVillagerNoAP);
        assertEquals(50, siege.getCurrentHP(), epsilon);
        siege.handledByVillager(attackerVillagerDead);
        assertEquals(50, siege.getCurrentHP(), epsilon);
        siege.handledByVillager(attackerVillager);
        assertEquals(100, siege.getCurrentHP(), epsilon);
        siege2.handledByVillager(attackerVillager);
        assertEquals(200, siege2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {
        for (Archer victimArcher : victimArcherList) {
            siege.interactWith(victimArcher);
        }
        assertEquals(0, victimArcher1.getCurrentHP(), epsilon);
        assertEquals(50, victimArcher2.getCurrentHP(), epsilon);
        assertEquals(0, victimArcher3.getCurrentHP(), epsilon);
        assertEquals(0, victimArcherNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimArcherDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCavalry() {
        for (Cavalry victimCavalry : victimCavalryList) {
            siege.interactWith(victimCavalry);
        }
        assertEquals(0, victimCavalry1.getCurrentHP(), epsilon);
        assertEquals(100, victimCavalry2.getCurrentHP(), epsilon);
        assertEquals(0, victimCavalry3.getCurrentHP(), epsilon);
        assertEquals(0, victimCavalryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimCavalryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithInfantry() {
        for (Infantry victimInfantry : victimInfantryList) {
            siege.interactWith(victimInfantry);
        }
        assertEquals(0, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(100, victimInfantry2.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantry3.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithMonk() {
        for (Monk victimMonk : victimMonkList) {
            siege.interactWith(victimMonk);
        }
        assertEquals(0, victimMonk1.getCurrentHP(), epsilon);
        assertEquals(0, victimMonk2.getCurrentHP(), epsilon);
        assertEquals(0, victimMonk3.getCurrentHP(), epsilon);
        assertEquals(0, victimMonkNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimMonkDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithSiege() {
        for (Siege victimSiege : victimSiegeList) {
            siege.interactWith(victimSiege);
        }
        assertEquals(0, victimSiege1.getCurrentHP(), epsilon);
        assertEquals(50, victimSiege2.getCurrentHP(), epsilon);
        assertEquals(0, victimSiege3.getCurrentHP(), epsilon);
        assertEquals(0, victimSiegeNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimSiegeDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithVillager() {
        for (Villager victimVillager : victimVillagerList) {
            siege.interactWith(victimVillager);
        }
        assertEquals(0, victimVillager1.getCurrentHP(), epsilon);
        assertEquals(50, victimVillager2.getCurrentHP(), epsilon);
        assertEquals(0, victimVillager3.getCurrentHP(), epsilon);
        assertEquals(0, victimVillagerNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimVillagerDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithBarracks() {
        for (Barracks victimBarracks : victimBarracksList) {
            siege.interactWith(victimBarracks);
        }
        assertEquals(0, victimBarracks1.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracks2.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracks3.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracksNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracksDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCastle() {
        for (Infantry victimInfantry : victimInfantryList) {
            siege.interactWith(victimInfantry);
        }
        assertEquals(0, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantry2.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantry3.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            siegeNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            siegeDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }


}
