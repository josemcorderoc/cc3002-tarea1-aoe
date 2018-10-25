package test;

import ageofempires.buildings.Barracks;
import ageofempires.units.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the Archer class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class ArcherTest extends AbstractAttackerTest {

    private Archer archer;
    private Archer archer2;
    private Archer archerNoAP;
    private Archer archerDead;

    /**
     * Initializes archers for testing
     */
    @Before
    public void setUp(){
        super.setUp();
        archer = new Archer(100,100);
        archer2 = new Archer(200,100);
        archerNoAP = new Archer(200,0);
        archerDead = new Archer(0,100);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testEquals(){
        assertEquals(archer, archer);
        assertEquals(archer, new Archer(100,100));
        assertEquals(archer, victimArcherToCompare);

        assertNotEquals(archer, new Archer(500, 200));
        assertNotEquals(archer, archerNoAP);
        assertNotEquals(archer, victimMonk1);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(archer.isAlive());
        assertFalse(archerDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, archer.getCurrentHP(),0.0);
        assertEquals(200, archerNoAP.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        archer.setCurrentHP(56.9f);
        assertEquals(56.9, archer.getCurrentHP(),0.0);
        archer.setCurrentHP(245);
        assertEquals(245, archer.getCurrentHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(200, archer.getMaxHP(), epsilon);
        assertEquals(400, archerNoAP.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetMaxHP() {
        archer.setMaxHP(134.6f);
        assertEquals(134.6f, archer.getMaxHP(),0.0);
        archer.setMaxHP(54);
        assertEquals(54, archer.getMaxHP(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(100, archer.getAttackPoints(),0.0);
        assertEquals(0, archerNoAP.getAttackPoints(),0.0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        archer.setAttackPoints(45.7f);
        assertEquals(45.7f, archer.getAttackPoints(), 0.0);
        archer.setAttackPoints(66);
        assertEquals(66,archer.getAttackPoints(), 0.0);
    }

    //aaaaaaaaaaaaaaaaaaa

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        archer.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByArcher(attackerArcherDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByArcher(attackerArcher);
        assertEquals(0, archer.getCurrentHP(), epsilon);
        archer2.attackedByArcher(attackerArcher);
        assertEquals(80, archer.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        archer.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByCavalry(attackerCavalry);
        assertEquals(0, archer.getCurrentHP(), epsilon);
        archer2.attackedByCavalry(attackerCavalry);
        assertEquals(50, archer2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        archer.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByInfantry(attackerInfantry);
        assertEquals(0, archer.getCurrentHP(), epsilon);
        archer2.attackedByInfantry(attackerInfantry);
        assertEquals(80, archer2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        archer.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedBySiege(attackerSiegeDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedBySiege(attackerSiege);
        assertEquals(0, archer.getCurrentHP(), epsilon);
        archer2.attackedBySiege(attackerSiege);
        assertEquals(50, archer2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        archer.curedByMonk(attackerMonkNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.curedByMonk(attackerMonkDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.curedByMonk(attackerMonk);
        assertEquals(150, archer.getCurrentHP(), epsilon);
        archer.curedByMonk(attackerMonk);
        archer.curedByMonk(attackerMonk);
        assertEquals(200, archer.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        archer.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByCastle(attackerCastleDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByCastle(attackerCastle);
        assertEquals(0, archer.getCurrentHP(), epsilon);
        archer2.attackedByCastle(attackerCastle);
        assertEquals(20, archer2.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        archer.handledByVillager(attackerVillagerNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.handledByVillager(attackerVillagerDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.handledByVillager(attackerVillager);
        assertEquals(0, archer.getCurrentHP(), epsilon);
        archer2.handledByVillager(attackerVillager);
        assertEquals(100, archer2.getCurrentHP(), epsilon);

    }

    //aaaaaaaaaaaa
    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            archer.interactWith(victimArcher);
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
            archer.interactWith(victimCavalry);
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
            archer.interactWith(victimInfantry);
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
            archer.interactWith(victimMonk);
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
            archer.interactWith(victimSiege);
        }
        assertEquals(20, victimSiege1.getCurrentHP(), epsilon);
        assertEquals(120, victimSiege2.getCurrentHP(), epsilon);
        assertEquals(0, victimSiege3.getCurrentHP(), epsilon);
        assertEquals(20, victimSiegeNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimSiegeDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithVillager() {
        for (Villager victimVillager : victimVillagerList) {
            archer.interactWith(victimVillager);
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
            archer.interactWith(victimBarracks);
        }
        assertEquals(30, victimBarracks1.getCurrentHP(), epsilon);
        assertEquals(130, victimBarracks2.getCurrentHP(), epsilon);
        assertEquals(30, victimBarracks3.getCurrentHP(), epsilon);
        assertEquals(30, victimBarracksNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimBarracksDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testInteractWithCastle() {
        for (Infantry victimInfantry : victimInfantryList) {
            archer.interactWith(victimInfantry);
        }
        assertEquals(90, victimInfantry1.getCurrentHP(), epsilon);
        assertEquals(190, victimInfantry2.getCurrentHP(), epsilon);
        assertEquals(40, victimInfantry3.getCurrentHP(), epsilon);
        assertEquals(90, victimInfantryNoAP.getCurrentHP(), epsilon);
        assertEquals(0, victimInfantryDead.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            archerNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            archerDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }

}
