package test;

import ageofempires.buildings.Barracks;
import ageofempires.buildings.Castle;
import ageofempires.units.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Test the Villager class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class VillagerTest extends AbstractAttackerTest {

    private Villager villager;
    private Villager villager2;
    private Villager villagerNoAP;
    private Villager villagerDead;

    /**
     * Initializes villager for testing
     */
    @Before
    public void setUp(){
        super.setUp();
        villager = new Villager(100,100);
        villager2 = new Villager(200,100);
        villagerNoAP = new Villager(100,0);
        villagerDead = new Villager(0,100);
    }

    /**
     * {@inheritDoc}
     */
    @Test
    @Override
    public void testEquals(){
        assertEquals(villager, villager);
        assertEquals(villager, new Villager(100,100));
        assertEquals(villager, victimVillagerToCompare);

        assertNotEquals(villager, new Villager(250, 200));
        assertNotEquals(villager, villagerNoAP);
        assertNotEquals(villager, victimMonk1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(villager.isAlive());
        assertFalse(villagerDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, villager.getCurrentHP(),epsilon);
        assertEquals(100, villagerNoAP.getCurrentHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        villager.setCurrentHP(56.9f);
        assertEquals(56.9, villager.getCurrentHP(),epsilon);
        villager.setCurrentHP(245);
        assertEquals(245, villager.getCurrentHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(200, villager.getMaxHP(), epsilon);
        assertEquals(200, villagerNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        villager.setMaxHP(134.6f);
        assertEquals(134.6f, villager.getMaxHP(),epsilon);
        villager.setMaxHP(54);
        assertEquals(54, villager.getMaxHP(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, villager.getAttackPoints(),epsilon);
        assertEquals(0, villagerNoAP.getAttackPoints(),epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        villager.setAttackPoints(45.7f);
        assertEquals(45.7f, villager.getAttackPoints(), epsilon);
        villager.setAttackPoints(66);
        assertEquals(66,villager.getAttackPoints(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        villager.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByArcher(attackerArcherDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByArcher(attackerArcher);
        assertEquals(0, villager.getCurrentHP(), epsilon);
        villager2.attackedByArcher(attackerArcher);
        assertEquals(50, villager2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        villager.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByCavalry(attackerCavalry);
        assertEquals(0, villager.getCurrentHP(), epsilon);
        villager2.attackedByCavalry(attackerCavalry);
        assertEquals(50, villager2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        villager.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByInfantry(attackerInfantry);
        assertEquals(0, villager.getCurrentHP(), epsilon);
        villager2.attackedByInfantry(attackerInfantry);
        assertEquals(50, villager2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        villager.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedBySiege(attackerSiegeDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedBySiege(attackerSiege);
        assertEquals(0, villager.getCurrentHP(), epsilon);
        villager2.attackedBySiege(attackerSiege);
        assertEquals(50, villager2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        villager.curedByMonk(attackerMonkNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.curedByMonk(attackerMonkDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.curedByMonk(attackerMonk);
        assertEquals(150, villager.getCurrentHP(), epsilon);
        villager.curedByMonk(attackerMonk);
        villager.curedByMonk(attackerMonk);
        assertEquals(200, villager.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        villager.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByCastle(attackerCastleDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.attackedByCastle(attackerCastle);
        assertEquals(0, villager.getCurrentHP(), epsilon);
        villager2.attackedByCastle(attackerCastle);
        assertEquals(80, villager2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        villager.handledByVillager(attackerVillagerNoAP);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.handledByVillager(attackerVillagerDead);
        assertEquals(100, villager.getCurrentHP(), epsilon);
        villager.handledByVillager(attackerVillager);
        assertEquals(0, villager.getCurrentHP(), epsilon);
        villager2.handledByVillager(attackerVillager);
        assertEquals(100, villager2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            villager.interactWith(victimArcher);
        }
        assertEquals(0, victimArcher1.getCurrentHP(), epsilon);
        assertEquals(100, victimArcher2.getCurrentHP(), epsilon);
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
            villager.interactWith(victimCavalry);
        }
        assertEquals(50, victimCavalry1.getCurrentHP(), epsilon);
        assertEquals(150, victimCavalry2.getCurrentHP(), epsilon);
        assertEquals(0, victimCavalry3.getCurrentHP(), epsilon);
        assertEquals(50, victimCavalryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimCavalryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithInfantry() {
        for (Infantry victimInfantry : victimInfantryList) {
            villager.interactWith(victimInfantry);
        }
        assertEquals(20, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(120, victimInfantry2.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantry3.getCurrentHP(), epsilon);
        assertEquals(20, victimInfantryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryDead.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithMonk() {
        for (Monk victimMonk : victimMonkList) {
            villager.interactWith(victimMonk);
        }
        assertEquals(100, victimMonk1.getCurrentHP(), epsilon);
        assertEquals(200, victimMonk2.getCurrentHP(), epsilon);
        assertEquals(50, victimMonk3.getCurrentHP(), epsilon);
        assertEquals(100, victimMonkNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimMonkDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithSiege() {
        victimSiege1.setCurrentHP(20);
        victimSiege2.setCurrentHP(199);
        for (Siege victimSiege : victimSiegeList) {
            villager.interactWith(victimSiege);
        }
        assertEquals(70, victimSiege1.getCurrentHP(), epsilon);
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
            villager.interactWith(victimVillager);
        }
        assertEquals(0, victimVillager1.getCurrentHP(), epsilon);
        assertEquals(100, victimVillager2.getCurrentHP(), epsilon);
        assertEquals(0, victimVillager3.getCurrentHP(), epsilon);
        assertEquals(0, victimVillagerNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimVillagerDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithBarracks() {
        victimBarracks1.setCurrentHP(20);
        victimBarracks2.setCurrentHP(199);
        for (Barracks victimBarracks : victimBarracksList) {
            villager.interactWith(victimBarracks);
        }
        assertEquals(90, victimBarracks1.getCurrentHP(), epsilon);
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
        victimCastle1.setCurrentHP(20);
        victimCastle2.setCurrentHP(199);
        for (Castle victimCastle : victimCastleList) {
            villager.interactWith(victimCastle);
        }

        assertEquals(50, victimCastle1.getCurrentHP(), epsilon);
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
            villagerNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            villagerDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }

}
