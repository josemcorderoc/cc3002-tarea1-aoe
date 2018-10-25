package test;

import ageofempires.units.Archer;

import ageofempires.units.Cavalry;
import org.junit.*;
import static org.junit.Assert.*;

public class ArcherTest extends AbstractAttackerTest {

    private Archer archer;
    private Archer archerNoAP;
    private Archer archerDead;

    @Before
    public void setUp(){
        super.setUp();
        archer = new Archer(100,100);
        archerNoAP = new Archer(100,0);
        archerDead = new Archer(0,100);
    }

    @Test @Override
    void testEquals(){
        assertEquals(archer, archer);
        assertEquals(archer, new Archer(100,100));
        assertEquals(archer, victimArcherToCompare);

        assertNotEquals(archer, new Archer(500, 200));
        assertNotEquals(archer, archerNoAP);
        assertNotEquals(archer, victimMonk1);
    }

    @Test @Override
    void testIsAlive() {

    }

    @Test @Override
    void testGetCurrentHP() {

    }

    @Test @Override
    void testSetCurrentHP() {

    }

    @Test @Override
    void testGetMaxHP() {

    }

    @Test @Override
    void testSetMaxHP() {

    }

    @Test @Override
    void testGetAttackPoints() {

    }

    @Test @Override
    void testSetAttackPoints() {

    }

    @Test @Override
    void testAttackedByArcher() {

    }

    @Test @Override
    void testAttackedByCavalry() {

    }

    @Test @Override
    void testAttackedByInfantry() {

    }

    @Test @Override
    void testAttackedBySiege() {

    }

    @Test @Override
    void testCuredByMonk() {

    }

    @Test @Override
    void testAttackedByCastle() {

    }

    @Test @Override
    void testHandledByVillager() {

    }

    @Test @Override
    void testInteractWithArcher() {

        for (Archer victimArcher : victimArcherList) {
            archer.interactWith(victimArcher);
        }
        assertTrue(victimArcher1.isAlive());
        assertFalse(victimArcher2.isAlive());
        assertFalse(victimArcher3.isAlive());
        assertTrue(victimArcherDead.getCurrentHP() == 0);
    }
    @Test @Override
    void testInteractWithCavalry() {
        for (Cavalry victimCavalry : victimCavalryList) {
            archer.interactWith(victimCavalry);
        }
    }

    @Test @Override
    void testInteractWithInfantry() {

    }

    @Test @Override
    void testInteractWithMonk() {

    }

    @Test @Override
    void testInteractWithSiege() {

    }

    @Test @Override
    void testInteractWithVillager() {

    }

    @Test @Override
    void testInteractWithBarracks() {

    }

    @Test @Override
    void testInteractWithCastle() {

    }

    @Test @Override
    void testNoAPInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            archerNoAP.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }
    }

    @Test @Override
    void testDeadInteraction() {
        for (int i = 0; i < victimEntityList.length; i++){
            archerDead.interactWith(victimEntityList[i]);
            assertEquals(victimEntityList[i], entityListToCompare[i]);
        }

    }

}
