package test;

import ageofempires.buildings.Barracks;
import ageofempires.buildings.Castle;
import ageofempires.units.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Monk class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class MonkTest extends AbstractAttackerTest {

    private Monk monk;
    private Monk monk2;
    private Monk monkNoAP;
    private Monk monkDead;

    /**
     * Initializes monk for testing
     */
    @Before
    public void setUp(){
        super.setUp();
        monk = new Monk(100,100);
        monk2 = new Monk(200,100);
        monkNoAP = new Monk(100,0);
        monkDead = new Monk(0,100);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    @Override
    public void testEquals(){
        assertEquals(monk, monk);
        assertEquals(monk, new Monk(100,100));
        assertEquals(monk, victimMonkToCompare);

        assertNotEquals(monk, new Monk(250, 200));
        assertNotEquals(monk, monkNoAP);
        assertNotEquals(monk, victimArcher1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(monk.isAlive());
        assertFalse(monkDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, monk.getCurrentHP(),epsilon);
        assertEquals(100, monkNoAP.getCurrentHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        monk.setCurrentHP(56.9f);
        assertEquals(56.9, monk.getCurrentHP(),epsilon);
        monk.setCurrentHP(245);
        assertEquals(245, monk.getCurrentHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(200, monk.getMaxHP(), epsilon);
        assertEquals(200, monkNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        monk.setMaxHP(134.6f);
        assertEquals(134.6f, monk.getMaxHP(),epsilon);
        monk.setMaxHP(54);
        assertEquals(54, monk.getMaxHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, monk.getAttackPoints(),epsilon);
        assertEquals(0, monkNoAP.getAttackPoints(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        monk.setAttackPoints(45.7f);
        assertEquals(45.7f, monk.getAttackPoints(), epsilon);
        monk.setAttackPoints(66);
        assertEquals(66,monk.getAttackPoints(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        monk.attackedByArcher(attackerArcherNoAP);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByArcher(attackerArcherDead);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByArcher(attackerArcher);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk2.attackedByArcher(attackerArcher);
        assertEquals(0, monk.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        monk.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByCavalry(attackerCavalryDead);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByCavalry(attackerCavalry);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk2.attackedByCavalry(attackerCavalry);
        assertEquals(0, monk2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        monk.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByInfantry(attackerInfantryDead);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByInfantry(attackerInfantry);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk2.attackedByInfantry(attackerInfantry);
        assertEquals(0, monk2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        monk.attackedBySiege(attackerSiegeNoAP);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedBySiege(attackerSiegeDead);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedBySiege(attackerSiege);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk2.attackedBySiege(attackerSiege);
        assertEquals(0, monk2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        monk.curedByMonk(attackerMonkNoAP);
        assertEquals(100, monk.getCurrentHP(), epsilon);
        monk.curedByMonk(attackerMonkDead);
        assertEquals(100, monk.getCurrentHP(), epsilon);
        monk.curedByMonk(attackerMonk);
        assertEquals(150, monk.getCurrentHP(), epsilon);
        monk.curedByMonk(attackerMonk);
        monk.curedByMonk(attackerMonk);
        assertEquals(200, monk.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        monk.attackedByCastle(attackerCastleNoAP);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByCastle(attackerCastleDead);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk.attackedByCastle(attackerCastle);
        assertEquals(0, monk.getCurrentHP(), epsilon);
        monk2.attackedByCastle(attackerCastle);
        assertEquals(0, monk2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        monk.handledByVillager(attackerVillagerNoAP);
        assertEquals(100, monk.getCurrentHP(), epsilon);
        monk.handledByVillager(attackerVillagerDead);
        assertEquals(100, monk.getCurrentHP(), epsilon);
        monk.handledByVillager(attackerVillager);
        assertEquals(100, monk.getCurrentHP(), epsilon);
        monk2.handledByVillager(attackerVillager);
        assertEquals(200, monk2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            monk.interactWith(victimArcher);
        }
        assertEquals(150, victimArcher1.getCurrentHP(), epsilon);
        assertEquals(250, victimArcher2.getCurrentHP(), epsilon);
        assertEquals(100, victimArcher3.getCurrentHP(), epsilon);
        assertEquals(150, victimArcherNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimArcherDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCavalry() {
        for (Cavalry victimCavalry : victimCavalryList) {
            monk.interactWith(victimCavalry);
        }
        assertEquals(150, victimCavalry1.getCurrentHP(), epsilon);
        assertEquals(250, victimCavalry2.getCurrentHP(), epsilon);
        assertEquals(100, victimCavalry3.getCurrentHP(), epsilon);
        assertEquals(150, victimCavalryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimCavalryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithInfantry() {
        for (Infantry victimInfantry : victimInfantryList) {
            monk.interactWith(victimInfantry);
        }
        assertEquals(150, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(250, victimInfantry2.getCurrentHP(), epsilon);
        assertEquals(100, victimInfantry3.getCurrentHP(), epsilon);
        assertEquals(150, victimInfantryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryDead.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithMonk() {
        for (Monk victimMonk : victimMonkList) {
            monk.interactWith(victimMonk);
        }
        assertEquals(150, victimMonk1.getCurrentHP(), epsilon);
        assertEquals(250, victimMonk2.getCurrentHP(), epsilon);
        assertEquals(100, victimMonk3.getCurrentHP(), epsilon);
        assertEquals(150, victimMonkNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimMonkDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithSiege() {
        for (Siege victimSiege : victimSiegeList) {
            monk.interactWith(victimSiege);
        }
        assertEquals(100, victimSiege1.getCurrentHP(), epsilon);
        assertEquals(200, victimSiege2.getCurrentHP(), epsilon);
        assertEquals(50, victimSiege3.getCurrentHP(), epsilon);
        assertEquals(100, victimSiegeNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimSiegeDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithVillager() {
        for (Villager victimVillager : victimVillagerList) {
            monk.interactWith(victimVillager);
        }
        assertEquals(150, victimVillager1.getCurrentHP(), epsilon);
        assertEquals(250, victimVillager2.getCurrentHP(), epsilon);
        assertEquals(100, victimVillager3.getCurrentHP(), epsilon);
        assertEquals(150, victimVillagerNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimVillagerDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithBarracks() {
        for (Barracks victimBarracks : victimBarracksList) {
            monk.interactWith(victimBarracks);
        }
        assertEquals(100, victimBarracks1.getCurrentHP(), epsilon);
        assertEquals(200, victimBarracks2.getCurrentHP(), epsilon);
        assertEquals(50, victimBarracks3.getCurrentHP(), epsilon);
        assertEquals(100, victimBarracksNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracksDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCastle() {
        for (Castle victimCastle : victimCastleList) {
            monk.interactWith(victimCastle);
        }
        assertEquals(100, victimCastle1.getCurrentHP(), epsilon);
        assertEquals(200, victimCastle2.getCurrentHP(), epsilon);
        assertEquals(50, victimCastle3.getCurrentHP(), epsilon);
        assertEquals(100, victimCastleNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimCastleDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            monkNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            monkDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }


}
