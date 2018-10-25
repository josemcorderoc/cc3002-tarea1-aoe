package test;

import ageofempires.buildings.Barracks;
import ageofempires.units.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the Cavalry class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class CavalryTest extends AbstractAttackerTest {

    private Cavalry cavalry;
    private Cavalry cavalry2;
    private Cavalry cavalryNoAP;
    private Cavalry cavalryDead;

    /**
     * Initializes cavalry for testing
     */
    @Before
    void setUp(){
            super.setUp();
            cavalry = new Cavalry(100,100);
            cavalry2 = new Cavalry(200,100);
            cavalryNoAP = new Cavalry(100,0);
            cavalryDead = new Cavalry(0,100);
        }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testEquals(){
        assertEquals(cavalry, cavalry);
        assertEquals(cavalry, new Cavalry(100,100));
        assertEquals(cavalry, victimCavalryToCompare);

        assertNotEquals(cavalry, new Cavalry(250, 200));
        assertNotEquals(cavalry, cavalryNoAP);
        assertNotEquals(cavalry, victimMonk1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(cavalry.isAlive());
        assertFalse(cavalryDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, cavalry.getCurrentHP(),0.0);
        assertEquals(200, cavalryNoAP.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        cavalry.setCurrentHP(56.9f);
        assertEquals(56.9, cavalry.getCurrentHP(),0.0);
        cavalry.setCurrentHP(245);
        assertEquals(245, cavalry.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(200, cavalry.getMaxHP(), epsilon);
        assertEquals(400, cavalryNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        cavalry.setMaxHP(134.6f);
        assertEquals(134.6f, cavalry.getMaxHP(),0.0);
        cavalry.setMaxHP(54);
        assertEquals(54, cavalry.getMaxHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, cavalry.getAttackPoints(),0.0);
        assertEquals(0, cavalryNoAP.getAttackPoints(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        cavalry.setAttackPoints(45.7f);
        assertEquals(45.7f, cavalry.getAttackPoints(), 0.0);
        cavalry.setAttackPoints(66);
        assertEquals(66,cavalry.getAttackPoints(), 0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        cavalry.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByArcher(attackerArcherDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByArcher(attackerArcher);
        assertEquals(0, cavalry.getCurrentHP(), epsilon);
        cavalry2.attackedByArcher(attackerArcher);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        cavalry.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByCavalry(attackerCavalry);
        assertEquals(0, cavalry.getCurrentHP(), epsilon);
        cavalry2.attackedByCavalry(attackerCavalry);
        assertEquals(100, cavalry2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        cavalry.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByInfantry(attackerInfantry);
        assertEquals(0, cavalry.getCurrentHP(), epsilon);
        cavalry2.attackedByInfantry(attackerInfantry);
        assertEquals(80, cavalry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        cavalry.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedBySiege(attackerSiegeDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedBySiege(attackerSiege);
        assertEquals(0, cavalry.getCurrentHP(), epsilon);
        cavalry2.attackedBySiege(attackerSiege);
        assertEquals(100, cavalry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        cavalry.curedByMonk(attackerMonkNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.curedByMonk(attackerMonkDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.curedByMonk(attackerMonk);
        assertEquals(150, cavalry.getCurrentHP(), epsilon);
        cavalry.curedByMonk(attackerMonk);
        cavalry.curedByMonk(attackerMonk);
        assertEquals(200, cavalry.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        cavalry.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByCastle(attackerCastleDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.attackedByCastle(attackerCastle);
        assertEquals(0, cavalry.getCurrentHP(), epsilon);
        cavalry2.attackedByCastle(attackerCastle);
        assertEquals(80, cavalry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        cavalry.handledByVillager(attackerVillagerNoAP);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.handledByVillager(attackerVillagerDead);
        assertEquals(100, cavalry.getCurrentHP(), epsilon);
        cavalry.handledByVillager(attackerVillager);
        assertEquals(50, cavalry.getCurrentHP(), epsilon);
        cavalry2.handledByVillager(attackerVillager);
        assertEquals(150, cavalry2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            cavalry.interactWith(victimArcher);
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
            cavalry.interactWith(victimCavalry);
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
            cavalry.interactWith(victimInfantry);
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
            cavalry.interactWith(victimMonk);
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
            cavalry.interactWith(victimSiege);
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
            cavalry.interactWith(victimVillager);
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
            cavalry.interactWith(victimBarracks);
        }
        assertEquals(30, victimBarracks1.getCurrentHP(), epsilon);
        assertEquals(130, victimBarracks2.getCurrentHP(), epsilon);
        assertEquals(00, victimBarracks3.getCurrentHP(), epsilon);
        assertEquals(30, victimBarracksNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracksDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCastle() {
        for (Infantry victimInfantry : victimInfantryList) {
            cavalry.interactWith(victimInfantry);
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
            cavalryNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            cavalryDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }


}

