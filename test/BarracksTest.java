package test;

import ageofempires.buildings.Barracks;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the Barracks class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class BarracksTest extends AbstractAttackableTest {

    private Barracks barracks1;
    private Barracks barracks2;
    private Barracks barracksDead;

    @Before
    public void setUp(){
        super.setUp();
        barracks1 = new Barracks(100);
        barracks2 = new Barracks(200);
        barracksDead = new Barracks(0);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testEquals() {
        assertEquals(barracks1, barracks1);
        assertEquals(barracks1, new Barracks(100));
        assertNotEquals(barracks1, barracks2);
        assertNotEquals(barracks1, attackerArcher);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testIsAlive() {
        assertTrue(barracks1.isAlive());
        assertFalse(barracksDead.isAlive());
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetCurrentHP() {
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        assertEquals(200, barracks2.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetCurrentHP() {
        barracks1.setCurrentHP(77);
        assertEquals(77, barracks1.getCurrentHP(), epsilon);
        barracks1.setCurrentHP(20.3f);
        assertEquals(20.3f, barracks1.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetMaxHP() {
        assertEquals(100, barracks1.getMaxHP(), epsilon);
        assertEquals(200, barracks2.getMaxHP(), epsilon);
    }

    @Test @Override
    public void testSetMaxHP() {
        barracks1.setMaxHP(40);
        assertEquals(40, barracks1.getMaxHP(), epsilon);
        barracks1.setMaxHP(945.76f);
        assertEquals(945.76f, barracks1.getMaxHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testGetAttackPoints() {
        assertEquals(barracks1.getAttackPoints(), 0, epsilon);
        assertEquals(barracks2.getAttackPoints(), 0, epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testSetAttackPoints() {
        barracks1.setAttackPoints(45);
        assertEquals(45, barracks1.getAttackPoints(), epsilon);
        barracks1.setAttackPoints(64.8f);
        assertEquals(64.8f, barracks1.getAttackPoints(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByArcher() {
        barracks1.attackedByArcher(attackerArcherNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByArcher(attackerArcherDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByArcher(attackerArcher);
        assertEquals(30, barracks1.getCurrentHP(), epsilon);
    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCavalry() {
        barracks1.attackedByCavalry(attackerCavalryNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByCavalry(attackerCavalryDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByCavalry(attackerCavalry);
        assertEquals(30, barracks1.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByInfantry() {
        barracks1.attackedByInfantry(attackerInfantryNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByInfantry(attackerInfantryDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByInfantry(attackerInfantry);
        assertEquals(30, barracks1.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedBySiege() {
        barracks1.attackedBySiege(attackerSiegeNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedBySiege(attackerSiegeDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedBySiege(attackerSiege);
        assertEquals(0, barracks1.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testCuredByMonk() {
        barracks1.curedByMonk(attackerMonkNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.curedByMonk(attackerMonkDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.curedByMonk(attackerMonk);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testAttackedByCastle() {
        barracks1.attackedByCastle(attackerCastleNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByCastle(attackerCastleDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.attackedByCastle(attackerCastle);
        assertEquals(30, barracks1.getCurrentHP(), epsilon);

    }

    /**
     * {@inheritDoc}
     */
    @Test @Override
    public void testHandledByVillager() {
        barracks1.handledByVillager(attackerVillagerNoAP);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.handledByVillager(attackerVillagerDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.handledByVillager(attackerVillagerDead);
        assertEquals(100, barracks1.getCurrentHP(), epsilon);
        barracks1.setCurrentHP(1);
        barracks1.handledByVillager(attackerVillager);
        assertEquals(71, barracks1.getCurrentHP(), epsilon);

    }
}
