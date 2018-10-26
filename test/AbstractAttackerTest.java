package test;

import ageofempires.AbstractEntity;
import ageofempires.buildings.*;
import ageofempires.units.*;

/**
 * Test the implementations of IAttacker interface (creates victim entities of all attackable classes for testing)
 */
public abstract class AbstractAttackerTest extends AbstractAttackableTest {

    Archer victimArcherToCompare;
    Infantry victimInfantryToCompare;
    Cavalry victimCavalryToCompare;
    Monk victimMonkToCompare;
    Siege victimSiegeToCompare;
    Villager victimVillagerToCompare;
    Castle victimCastleToCompare;
    Barracks victimBarracksToCompare;


    Archer victimArcher1;
    Archer victimArcher2;
    Archer victimArcher3;
    Archer victimArcherNoAP;
    Archer victimArcherDead;

    Infantry victimInfantry1;
    Infantry victimInfantry2;
    Infantry victimInfantry3;
    Infantry victimInfantryNoAP;
    Infantry victimInfantryDead;

    Cavalry victimCavalry1;
    Cavalry victimCavalry2;
    Cavalry victimCavalry3;
    Cavalry victimCavalryNoAP;
    Cavalry victimCavalryDead;

    Monk victimMonk1;
    Monk victimMonk2;
    Monk victimMonk3;
    Monk victimMonkNoAP;
    Monk victimMonkDead;

    Siege victimSiege1;
    Siege victimSiege2;
    Siege victimSiege3;
    Siege victimSiegeNoAP;
    Siege victimSiegeDead;

    Villager victimVillager1;
    Villager victimVillager2;
    Villager victimVillager3;
    Villager victimVillagerNoAP;
    Villager victimVillagerDead;

    Castle victimCastle1;
    Castle victimCastle2;
    Castle victimCastle3;
    Castle victimCastleNoAP;
    Castle victimCastleDead;

    Barracks victimBarracks1;
    Barracks victimBarracks2;
    Barracks victimBarracks3;
    Barracks victimBarracksNoAP;
    Barracks victimBarracksDead;

    Archer[] victimArcherList = new Archer[5];
    Cavalry[] victimCavalryList = new Cavalry[5];
    Infantry[] victimInfantryList;
    Monk[] victimMonkList = new Monk[5];
    Siege[] victimSiegeList = new Siege[5];
    Villager[] victimVillagerList = new Villager[5];
    Barracks[] victimBarracksList = new Barracks[5];
    Castle[] victimCastleList = new Castle[5];

    AbstractEntity[] victimEntityList = new AbstractEntity[7];
    AbstractEntity[] entityListToCompare = new AbstractEntity[7];



    /**
     * Initialize victim entities and arrays
     *
     * Entities follow this structure:
     * -victimENTITY1 = new ENTITY(100, 100)
     * -victimENTITY2 = new ENTITY(200, 100)
     * -victimENTITY3 = new ENTITY(50, 100)
     * -victimENTITYNoAP = new ENTITY(100, 0)
     * -victimENTITYDead = new ENTITY(0, 100)
     */
    @Override
    public void setUp() {
        super.setUp();
        
        victimArcherToCompare = new Archer(100,100);
        victimCavalryToCompare = new Cavalry(100,100);
        victimInfantryToCompare = new Infantry(100,100);
        victimSiegeToCompare = new Siege(100,100);
        victimMonkToCompare = new Monk(100,100);
        victimVillagerToCompare = new Villager(100,100);
        victimBarracksToCompare = new Barracks(100);
        victimCastleToCompare = new Castle(100,100);

        victimArcher1 = new Archer(100, 100);
        victimArcher2 = new Archer(200, 100);
        victimArcher3 = new Archer(50, 100);
        victimArcherNoAP = new Archer(100, 0);
        victimArcherDead = new Archer(0, 100);

        victimCavalry1 = new Cavalry(100, 100);
        victimCavalry2 = new Cavalry(200, 100);
        victimCavalry3 = new Cavalry(50, 100);  
        victimCavalryNoAP = new Cavalry(100, 0);
        victimCavalryDead = new Cavalry(0, 100);

        victimInfantry1 = new Infantry(100, 100);
        victimInfantry2 = new Infantry(200, 100);
        victimInfantry3 = new Infantry(50, 100);
        victimInfantryNoAP = new Infantry(100, 0);
        victimInfantryDead = new Infantry(0, 100);

        victimMonk1 = new Monk(100, 100);
        victimMonk2 = new Monk(200, 100);
        victimMonk3 = new Monk(50, 100);
        victimMonkNoAP = new Monk(100, 0);
        victimMonkDead = new Monk(0, 100);

        victimSiege1 = new Siege(100, 100);
        victimSiege2 = new Siege(200, 100);
        victimSiege3 = new Siege(50, 100);
        victimSiegeNoAP = new Siege(100, 0);
        victimSiegeDead = new Siege(0, 100);

        victimVillager1 = new Villager(100, 100);
        victimVillager2 = new Villager(200, 100);
        victimVillager3 = new Villager(50, 100);
        victimVillagerNoAP = new Villager(100, 0);
        victimVillagerDead = new Villager(0, 100);

        victimBarracks1 = new Barracks(100);
        victimBarracks2 = new Barracks(200);
        victimBarracks3 = new Barracks(50);
        victimBarracksNoAP = new Barracks(100);
        victimBarracksDead = new Barracks(0);

        victimCastle1 = new Castle(100, 100);
        victimCastle2 = new Castle(200, 100);
        victimCastle3 = new Castle(50, 100);
        victimCastleNoAP = new Castle(100, 0);
        victimCastleDead = new Castle(0, 100);
        

        victimArcherList[0] = victimArcher1;
        victimArcherList[1] = victimArcher2;
        victimArcherList[2] = victimArcher3;
        victimArcherList[3] = victimArcherNoAP;
        victimArcherList[4] = victimArcherDead;

        victimCavalryList[0] = victimCavalry1;
        victimCavalryList[1] = victimCavalry2;
        victimCavalryList[2] = victimCavalry3;
        victimCavalryList[3] = victimCavalryNoAP;
        victimCavalryList[4] = victimCavalryDead;

        victimInfantryList = new Infantry[5];
        victimInfantryList[0] = victimInfantry1;
        victimInfantryList[1] = victimInfantry2;
        victimInfantryList[2] = victimInfantry3;
        victimInfantryList[3] = victimInfantryNoAP;
        victimInfantryList[4] = victimInfantryDead;

        victimMonkList[0] = victimMonk1;
        victimMonkList[1] = victimMonk2;
        victimMonkList[2] = victimMonk3;
        victimMonkList[3] = victimMonkNoAP;
        victimMonkList[4] = victimMonkDead;

        victimSiegeList[0] = victimSiege1;
        victimSiegeList[1] = victimSiege2;
        victimSiegeList[2] = victimSiege3;
        victimSiegeList[3] = victimSiegeNoAP;
        victimSiegeList[4] = victimSiegeDead;

        victimVillagerList[0] = victimVillager1;
        victimVillagerList[1] = victimVillager2;
        victimVillagerList[2] = victimVillager3;
        victimVillagerList[3] = victimVillagerNoAP;
        victimVillagerList[4] = victimVillagerDead;

        victimBarracksList[0] = victimBarracks1;
        victimBarracksList[1] = victimBarracks2;
        victimBarracksList[2] = victimBarracks3;
        victimBarracksList[3] = victimBarracksNoAP;
        victimBarracksList[4] = victimBarracksDead;

        victimCastleList[0] = victimCastle1;
        victimCastleList[1] = victimCastle2;
        victimCastleList[2] = victimCastle3;
        victimCastleList[3] = victimCastleNoAP;
        victimCastleList[4] = victimCastleDead;

        victimEntityList[0] = victimArcher1;
        victimEntityList[1] = victimCavalry1;
        victimEntityList[2] = victimInfantry1;
        victimEntityList[3] = victimSiege1;
        victimEntityList[4] = victimVillager1;
        victimEntityList[5] = victimBarracks1;
        victimEntityList[6] = victimCastle1;

        entityListToCompare[0] = victimArcherToCompare;
        entityListToCompare[1] = victimCavalryToCompare;
        entityListToCompare[2] = victimInfantryToCompare;
        entityListToCompare[3] = victimSiegeToCompare;
        entityListToCompare[4] = victimVillagerToCompare;
        entityListToCompare[5] = victimBarracksToCompare;
        entityListToCompare[6] = victimCastleToCompare;
    }

    /**
     * Test the interactWithArcher method in 3 cases: normal archer, dead archer and no attack points archer
     */
    public abstract void testInteractWithArcher();

    /**
     * Test the interactWithCavalry method in 3 cases: normal cavalry, dead cavalry and no attack points cavalry
     */
    public abstract void testInteractWithCavalry();

    /**
     * Test the interactWithInfantry method in 3 cases: normal infantry, dead infantry and no attack points infantry
     */
    public abstract void testInteractWithInfantry();

    /**
     * Test the interactWithMonk method in 3 cases: normal monk, dead monk and no attack points monk
     */
    public abstract void testInteractWithMonk();

    /**
     * Test the interactWithSiege method in 3 cases: normal siege, dead siege and no attack points siege
     */
    public abstract void testInteractWithSiege();

    /**
     * Test the interactWithVillager method in 3 cases: normal villager, dead villager and no attack points villager
     */
    public abstract void testInteractWithVillager();

    /**
     * Test the interactWithBarracks method in 2 cases: normal barracks and dead barracks
     */
    public abstract void testInteractWithBarracks();

    /**
     * Test the interactWithCastle method in 3 cases: normal castle, dead castle and no attack points castle
     */
    public abstract void testInteractWithCastle();

    /**
     * Test the interaction methods with a no attack points entity
     */
    public abstract void testNoAPInteraction();

    /**
     * Test the interaction methods with a dead entity
     */
    public abstract void testDeadInteraction();
}
