package test;

import ageofempires.buildings.Barracks;
import ageofempires.buildings.Castle;
import ageofempires.units.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Test the Castle class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class CastleTest extends AbstractAttackerTest {

    private Castle castle;
    private Castle castle2;
    private Castle castleNoAP;
    private Castle castleDead;

    /**
     * Initializes castle for testing
     */
    @Before
    public void setUp(){
        super.setUp();
        castle = new Castle(100,100);
        castle2 = new Castle(200,100);
        castleNoAP = new Castle(100,0);
        castleDead = new Castle(0,100);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    @Override
    public void testEquals(){
        assertEquals(castle, castle);
        assertEquals(castle, new Castle(100,100));
        assertEquals(castle, victimCastleToCompare);

        assertNotEquals(castle, new Castle(250, 200));
        assertNotEquals(castle, castleNoAP);
        assertNotEquals(castle, victimMonk1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(castle.isAlive());
        assertFalse(castleDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, castle.getCurrentHP(),epsilon);
        assertEquals(100, castleNoAP.getCurrentHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        castle.setCurrentHP(56.9f);
        assertEquals(56.9, castle.getCurrentHP(),epsilon);
        castle.setCurrentHP(245);
        assertEquals(245, castle.getCurrentHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(100, castle.getMaxHP(), epsilon);
        assertEquals(100, castleNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        castle.setMaxHP(134.6f);
        assertEquals(134.6f, castle.getMaxHP(),epsilon);
        castle.setMaxHP(54);
        assertEquals(54, castle.getMaxHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, castle.getAttackPoints(),epsilon);
        assertEquals(0, castleNoAP.getAttackPoints(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        castle.setAttackPoints(45.7f);
        assertEquals(45.7f, castle.getAttackPoints(), epsilon);
        castle.setAttackPoints(66);
        assertEquals(66,castle.getAttackPoints(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        castle.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByArcher(attackerArcherDead);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByArcher(attackerArcher);
        assertEquals(90, castle.getCurrentHP(), epsilon);
        castle2.attackedByArcher(attackerArcher);
        assertEquals(190, castle2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        castle.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByCavalry(attackerCavalry);
        assertEquals(70, castle.getCurrentHP(), epsilon);
        castle2.attackedByCavalry(attackerCavalry);
        assertEquals(170, castle2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        castle.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByInfantry(attackerInfantry);
        assertEquals(70, castle.getCurrentHP(), epsilon);
        castle2.attackedByInfantry(attackerInfantry);
        assertEquals(170, castle2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        castle.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedBySiege(attackerSiegeDead);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedBySiege(attackerSiege);
        assertEquals(0, castle.getCurrentHP(), epsilon);
        castle2.attackedBySiege(attackerSiege);
        assertEquals(0, castle2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        castle.curedByMonk(attackerMonkNoAP);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.curedByMonk(attackerMonkDead);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.curedByMonk(attackerMonk);
        assertEquals(100, castle.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        castle.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByCastle(attackerCastleDead);
        assertEquals(100, castle.getCurrentHP(), epsilon);
        castle.attackedByCastle(attackerCastle);
        assertEquals(90, castle.getCurrentHP(), epsilon);
        castle2.attackedByCastle(attackerCastle);
        assertEquals(190, castle2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        castle.setCurrentHP(40);
        castle.handledByVillager(attackerVillagerNoAP);
        assertEquals(40, castle.getCurrentHP(), epsilon);
        castle.handledByVillager(attackerVillagerDead);
        assertEquals(40, castle.getCurrentHP(), epsilon);
        castle.handledByVillager(attackerVillager);
        assertEquals(70, castle.getCurrentHP(), epsilon);
        castle2.handledByVillager(attackerVillager);
        assertEquals(200, castle2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            castle.interactWith(victimArcher);
        }
        assertEquals(0, victimArcher1.getCurrentHP(), epsilon);
        assertEquals(80, victimArcher2.getCurrentHP(), epsilon);
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
            castle.interactWith(victimCavalry);
        }
        assertEquals(0, victimCavalry1.getCurrentHP(), epsilon);
        assertEquals(80, victimCavalry2.getCurrentHP(), epsilon);
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
            castle.interactWith(victimInfantry);
        }
        assertEquals(0, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(80, victimInfantry2.getCurrentHP(), epsilon);
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
            castle.interactWith(victimMonk);
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
            castle.interactWith(victimSiege);
        }
        assertEquals(50, victimSiege1.getCurrentHP(), epsilon);
        assertEquals(150, victimSiege2.getCurrentHP(), epsilon);
        assertEquals(0, victimSiege3.getCurrentHP(), epsilon);
        assertEquals(50, victimSiegeNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimSiegeDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithVillager() {
        for (Villager victimVillager : victimVillagerList) {
            castle.interactWith(victimVillager);
        }
        assertEquals(0, victimVillager1.getCurrentHP(), epsilon);
        assertEquals(80, victimVillager2.getCurrentHP(), epsilon);
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
            castle.interactWith(victimBarracks);
        }
        assertEquals(30, victimBarracks1.getCurrentHP(), epsilon);
        assertEquals(130, victimBarracks2.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracks3.getCurrentHP(), epsilon);
        assertEquals(30, victimBarracksNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracksDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCastle() {
        for (Castle victimCastle : victimCastleList) {
            castle.interactWith(victimCastle);
        }
        assertEquals(90, victimCastle1.getCurrentHP(), epsilon);
        assertEquals(190, victimCastle2.getCurrentHP(), epsilon);
        assertEquals(40, victimCastle3.getCurrentHP(), epsilon);
        assertEquals(90, victimCastleNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimCastleDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            castleNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            castleDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }
}
