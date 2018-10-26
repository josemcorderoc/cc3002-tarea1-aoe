package test;

import ageofempires.buildings.*;
import ageofempires.units.*;

/**
 * Test the implementations of IAttackable interface (creates attacker entities of all attacker classes for testing)
 */
public abstract class AbstractAttackableTest {

    Archer attackerArcher;
    Archer attackerArcherNoAP;
    Archer attackerArcherDead;

    Infantry attackerInfantry;
    Infantry attackerInfantryNoAP;
    Infantry attackerInfantryDead;

    Cavalry attackerCavalry;
    Cavalry attackerCavalryNoAP;
    Cavalry attackerCavalryDead;

    Monk attackerMonk;
    Monk attackerMonkNoAP;
    Monk attackerMonkDead;

    Siege attackerSiege;
    Siege attackerSiegeNoAP;
    Siege attackerSiegeDead;

    Villager attackerVillager;
    Villager attackerVillagerNoAP;
    Villager attackerVillagerDead;

    Castle attackerCastle;
    Castle attackerCastleNoAP;
    Castle attackerCastleDead;

    Archer[] attackerArcherList = new Archer[3];
    Cavalry[] attackerCavalryList = new Cavalry[3];
    Infantry[] attackerInfantryList = new Infantry[3];
    Monk[] attackerMonkList = new Monk[3];
    Siege[] attackerSiegeList = new Siege[3];
    Villager[] attackerVillagerList = new Villager[3];
    Castle[] attackerCastleList = new Castle[3];


    final float epsilon = 0.0001f;

    /**
     * Initialize attacker entities and arrays
     *
     * Entities follow this structure:
     * -attackerENTITY = new ENTITY(100, 100)
     * -attackerENTITYNoAP = new ENTITY(100, 0)
     * -attackerENTITYDead = new ENTITY(0, 100)
     */
    public void setUp(){

        attackerArcher = new Archer(100, 100);
        attackerArcherNoAP = new Archer(100, 0);
        attackerArcherDead = new Archer(0, 100);

        attackerCavalry = new Cavalry(100,100);
        attackerCavalryNoAP = new Cavalry(100,0);
        attackerCavalryDead = new Cavalry(0,100);

        attackerInfantry = new Infantry(100,100);
        attackerInfantryNoAP = new Infantry(100,0);
        attackerInfantryDead = new Infantry(0,100);

        attackerMonk = new Monk(100,100);
        attackerMonkNoAP = new Monk(100,0);
        attackerMonkDead = new Monk(0,100);

        attackerSiege = new Siege(100,100);
        attackerSiegeNoAP = new Siege(100,0);
        attackerSiegeDead = new Siege(0,100);

        attackerVillager = new Villager(100,100);
        attackerVillagerNoAP = new Villager(100,0);
        attackerVillagerDead = new Villager(0,100);

        attackerCastle = new Castle(100,100);
        attackerCastleNoAP = new Castle(100,0);
        attackerCastleDead = new Castle(0,100);

        attackerArcherList[0] = attackerArcher;
        attackerArcherList[1] = attackerArcherNoAP;
        attackerArcherList[2] = attackerArcherDead;

        attackerCavalryList[0] = attackerCavalry;
        attackerCavalryList[1] = attackerCavalryNoAP;
        attackerCavalryList[2] = attackerCavalryDead;

        attackerInfantryList[0] = attackerInfantry;
        attackerInfantryList[1] = attackerInfantryNoAP;
        attackerInfantryList[2] = attackerInfantryDead;

        attackerMonkList[0] = attackerMonk;
        attackerMonkList[1] = attackerMonkNoAP;
        attackerMonkList[2] = attackerMonkDead;

        attackerSiegeList[0] = attackerSiege;
        attackerSiegeList[1] = attackerSiegeNoAP;
        attackerSiegeList[2] = attackerSiegeDead;

        attackerVillagerList[0] = attackerVillager;
        attackerVillagerList[1] = attackerVillagerNoAP;
        attackerVillagerList[2] = attackerVillagerDead;

        attackerCastleList[0] = attackerCastle;
        attackerCastleList[1] = attackerCastleNoAP;
        attackerCastleList[2] = attackerCastleDead;
    }

    /**
     * Test equals method
     */
    public abstract void testEquals();

    /**
     * Test isAlive method
     */
    public abstract void testIsAlive();

    /**
     * Test setCurrentHP method
     */
    public abstract void testGetCurrentHP();

    /**
     * Test getCurrentHP method
     */
    public abstract void testSetCurrentHP();

    /**
     * Test getMaxHP method
     */
    public abstract void testGetMaxHP();

    /**
     * Test setMaxHP method
     */
    public abstract void testSetMaxHP();

    /**
     * Test getAttackPoints method
     */
    public abstract void testGetAttackPoints();

    /**
     * Test setAttackPoints method
     */
    public abstract void testSetAttackPoints();

    /**
     * Test the attackedByArcher method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testAttackedByArcher();

    /**
     * Test the attackedByCavalry method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testAttackedByCavalry();

    /**
     * Test the attackedByInfantry method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testAttackedByInfantry();

    /**
     * Test the attackedBySiege method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testAttackedBySiege();

    /**
     * Test the curedByMonk method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testCuredByMonk();

    /**
     * Test the attackedByCastle method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testAttackedByCastle();

    /**
     * Test the handledByVillager method in 3 cases: normal attacked entity,
     * dead attacked entity and no attack points entity
     */
    public abstract void testHandledByVillager();
}
