package test;

import ageofempires.buildings.Barracks;
import ageofempires.units.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Test the Infantry class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class InfantryTest extends AbstractAttackerTest {

    private Infantry infantry;
    private Infantry infantry2;
    private Infantry infantryNoAP;
    private Infantry infantryDead;

    /**
     * Initializes infantry for testing
     */
    @Before
    void setUp(){
        super.setUp();
        infantry = new Infantry(100,100);
        infantry2 = new Infantry(200,100);
        infantryNoAP = new Infantry(100,0);
        infantryDead = new Infantry(0,100);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testEquals(){
        assertEquals(infantry, infantry);
        assertEquals(infantry, new Infantry(100,100));
        assertEquals(infantry, victimInfantryToCompare);

        assertNotEquals(infantry, new Infantry(250, 200));
        assertNotEquals(infantry, infantryNoAP);
        assertNotEquals(infantry, victimMonk1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(infantry.isAlive());
        assertFalse(infantryDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, infantry.getCurrentHP(),0.0);
        assertEquals(200, infantryNoAP.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        infantry.setCurrentHP(56.9f);
        assertEquals(56.9, infantry.getCurrentHP(),0.0);
        infantry.setCurrentHP(245);
        assertEquals(245, infantry.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(200, infantry.getMaxHP(), epsilon);
        assertEquals(400, infantryNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        infantry.setMaxHP(134.6f);
        assertEquals(134.6f, infantry.getMaxHP(),0.0);
        infantry.setMaxHP(54);
        assertEquals(54, infantry.getMaxHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, infantry.getAttackPoints(),0.0);
        assertEquals(0, infantryNoAP.getAttackPoints(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        infantry.setAttackPoints(45.7f);
        assertEquals(45.7f, infantry.getAttackPoints(), 0.0);
        infantry.setAttackPoints(66);
        assertEquals(66,infantry.getAttackPoints(), 0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        infantry.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByArcher(attackerArcherDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByArcher(attackerArcher);
        assertEquals(0, infantry.getCurrentHP(), epsilon);
        infantry2.attackedByArcher(attackerArcher);
        assertEquals(80, infantry.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        infantry.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByCavalry(attackerCavalry);
        assertEquals(0, infantry.getCurrentHP(), epsilon);
        infantry2.attackedByCavalry(attackerCavalry);
        assertEquals(100, infantry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        infantry.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByInfantry(attackerInfantry);
        assertEquals(0, infantry.getCurrentHP(), epsilon);
        infantry2.attackedByInfantry(attackerInfantry);
        assertEquals(100, infantry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        infantry.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedBySiege(attackerSiegeDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedBySiege(attackerSiege);
        assertEquals(0, infantry.getCurrentHP(), epsilon);
        infantry2.attackedBySiege(attackerSiege);
        assertEquals(50, infantry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        infantry.curedByMonk(attackerMonkNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.curedByMonk(attackerMonkDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.curedByMonk(attackerMonk);
        assertEquals(150, infantry.getCurrentHP(), epsilon);
        infantry.curedByMonk(attackerMonk);
        infantry.curedByMonk(attackerMonk);
        assertEquals(200, infantry.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        infantry.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByCastle(attackerCastleDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.attackedByCastle(attackerCastle);
        assertEquals(0, infantry.getCurrentHP(), epsilon);
        infantry2.attackedByCastle(attackerCastle);
        assertEquals(80, infantry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        infantry.handledByVillager(attackerVillagerNoAP);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.handledByVillager(attackerVillagerDead);
        assertEquals(100, infantry.getCurrentHP(), epsilon);
        infantry.handledByVillager(attackerVillager);
        assertEquals(20, infantry.getCurrentHP(), epsilon);
        infantry2.handledByVillager(attackerVillager);
        assertEquals(120, infantry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {
        for (Archer victimArcher : victimArcherList) {
            infantry.interactWith(victimArcher);
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
            infantry.interactWith(victimCavalry);
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
            infantry.interactWith(victimInfantry);
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
            infantry.interactWith(victimMonk);
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
            infantry.interactWith(victimSiege);
        }
        assertEquals(0, victimSiege1.getCurrentHP(), epsilon);
        assertEquals(80, victimSiege2.getCurrentHP(), epsilon);
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
            infantry.interactWith(victimVillager);
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
            infantry.interactWith(victimBarracks);
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
        for (Infantry victimInfantry : victimInfantryList) {
            infantry.interactWith(victimInfantry);
        }
        assertEquals(70, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(170, victimInfantry2.getCurrentHP(), epsilon);
        assertEquals(20, victimInfantry3.getCurrentHP(), epsilon);
        assertEquals(70, victimInfantryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            infantryNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            infantryDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }


}
