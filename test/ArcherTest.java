package test;

import ageofempires.units.Archer;

import ageofempires.units.Cavalry;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the Archer class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class ArcherTest extends AbstractAttackerTest {

    private Archer archer;
    private Archer archerNoAP;
    private Archer archerDead;

    /**
     * Initializes archers for testing
     */
    @Before
    public void setUp(){
        super.setUp();
        archer = new Archer(100,100);
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

    @Test @Override
    public void testAttackedByArcher() {
        archer.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByArcher(attackerArcherDead);
        assertEquals(100, archer.getCurrentHP(), epsilon);
        archer.attackedByArcher(attackerArcher);

    }

    @Test @Override
    public void testAttackedByCavalry() {

    }

    @Test @Override
    public void testAttackedByInfantry() {

    }

    @Test @Override
    public void testAttackedBySiege() {

    }

    @Test @Override
    public void testCuredByMonk() {

    }

    @Test @Override
    public void testAttackedByCastle() {

    }

    @Test @Override
    public void testHandledByVillager() {

    }

    @Test @Override
    public void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            archer.interactWith(victimArcher);
        }
        assertTrue(victimArcher1.isAlive());
        assertFalse(victimArcher2.isAlive());
        assertFalse(victimArcher3.isAlive());
        assertTrue(victimArcherDead.getCurrentHP() == 0);
    }
    @Test @Override
    public void testInteractWithCavalry() {
        for (Cavalry victimCavalry : victimCavalryList) {
            archer.interactWith(victimCavalry);
        }
    }

    @Test @Override
    public void testInteractWithInfantry() {

    }

    @Test @Override
    public void testInteractWithMonk() {

    }

    @Test @Override
    public void testInteractWithSiege() {

    }

    @Test @Override
    public void testInteractWithVillager() {

    }

    @Test @Override
    public void testInteractWithBarracks() {

    }

    @Test @Override
    public void testInteractWithCastle() {

    }

    @Test @Override
    public void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            archerNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    @Test @Override
    public void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            archerDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }

}
