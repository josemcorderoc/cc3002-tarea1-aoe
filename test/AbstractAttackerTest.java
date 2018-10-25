package test;

import ageofempires.AbstractEntity;
import ageofempires.buildings.*;
import ageofempires.units.*;

public abstract class AbstractAttackerTest extends AbstractAttackableTest {

    Archer victimArcherToCompare;

    Archer victimArcher1;
    Archer victimArcher2;
    Archer victimArcher3;
    Archer victimArcherNoAP;
    Archer victimArcherDead;

    Infantry victimInfantryToCompare;

    Infantry victimInfantry1;
    Infantry victimInfantry2;
    Infantry victimInfantry3;
    Infantry victimInfantryNoAP;
    Infantry victimInfantryDead;

    Cavalry victimCavalryToCompare;

    Cavalry victimCavalry1;
    Cavalry victimCavalry2;
    Cavalry victimCavalry3;
    Cavalry victimCavalryNoAP;
    Cavalry victimCavalryDead;

    Monk victimMonkToCompare;

    Monk victimMonk1;
    Monk victimMonk2;
    Monk victimMonk3;
    Monk victimMonkNoAP;
    Monk victimMonkDead;

    Siege victimSiegeToCompare;

    Siege victimSiege1;
    Siege victimSiege2;
    Siege victimSiege3;
    Siege victimSiegeNoAP;
    Siege victimSiegeDead;

    Villager victimVillagerToCompare;

    Villager victimVillager1;
    Villager victimVillager2;
    Villager victimVillager3;
    Villager victimVillagerNoAP;
    Villager victimVillagerDead;

    Castle victimCastleToCompare;

    Castle victimCastle1;
    Castle victimCastle2;
    Castle victimCastle3;
    Castle victimCastleNoAP;
    Castle victimCastleDead;

    Barracks victimBarracksToCompare;

    Barracks victimBarracks1;
    Barracks victimBarracks2;
    Barracks victimBarracks3;
    Barracks victimBarracksNoAP;
    Barracks victimBarracksDead;


    Archer[] victimArcherList = new Archer[5];
    Cavalry[] victimCavalryList = new Cavalry[5];
    Infantry[] victimInfantryList = new Infantry[5];
    Monk[] victimMonkList = new Monk[5];
    Siege[] victimSiegeList = new Siege[5];
    Villager[] victimVillagerList = new Villager[5];
    Barracks[] victimBarracksList = new Barracks[5];
    Castle[] victimCastleList = new Castle[5];

    AbstractEntity[] victimEntityList = new AbstractEntity[8];
    AbstractEntity[] entityListToCompare = new AbstractEntity[8];


    @Override
    void setUp() {
        super.setUp();
        
        victimArcherToCompare = new Archer(100,100);
        victimCavalryToCompare = new Cavalry(100,100);
        victimInfantryToCompare = new Infantry(100,100);
        victimMonkToCompare = new Monk(100,100);
        victimSiegeToCompare = new Siege(100,100);
        victimVillagerToCompare = new Villager(100,100);
        victimBarracksToCompare = new Barracks(100);
        victimCastleToCompare = new Castle(100,100);

        victimArcher1 = new Archer(200, 100);
        victimArcher2 = new Archer(100, 100);
        victimArcher3 = new Archer(50, 100);
        victimArcherNoAP = new Archer(100, 0);
        victimArcherDead = new Archer(0, 100);

        victimCavalry1 = new Cavalry(200, 100); 
        victimCavalry2 = new Cavalry(100, 100); 
        victimCavalry3 = new Cavalry(50, 100);  
        victimCavalryNoAP = new Cavalry(100, 0);
        victimCavalryDead = new Cavalry(0, 100);

        victimInfantry1 = new Infantry(200, 100);
        victimInfantry2 = new Infantry(100, 100);
        victimInfantry3 = new Infantry(50, 100);
        victimInfantryNoAP = new Infantry(100, 0);
        victimInfantryDead = new Infantry(0, 100);

        victimMonk1 = new Monk(200, 100);
        victimMonk2 = new Monk(100, 100);
        victimMonk3 = new Monk(50, 100);
        victimMonkNoAP = new Monk(100, 0);
        victimMonkDead = new Monk(0, 100);

        victimSiege1 = new Siege(200, 100);
        victimSiege2 = new Siege(100, 100);
        victimSiege3 = new Siege(50, 100);
        victimSiegeNoAP = new Siege(100, 0);
        victimSiegeDead = new Siege(0, 100);

        victimVillager1 = new Villager(200, 100);
        victimVillager2 = new Villager(100, 100);
        victimVillager3 = new Villager(50, 100);
        victimVillagerNoAP = new Villager(100, 0);
        victimVillagerDead = new Villager(0, 100);

        victimBarracks1 = new Barracks(200);
        victimBarracks2 = new Barracks(100);
        victimBarracks3 = new Barracks(50);
        victimBarracksNoAP = new Barracks(100);
        victimBarracksDead = new Barracks(0);

        victimCastle1 = new Castle(200, 100);
        victimCastle2 = new Castle(100, 100);
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

        victimSiegeList[0] = victimSiege1 ;
        victimSiegeList[1] = victimSiege2 ;
        victimSiegeList[2] = victimSiege3 ;
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
        victimEntityList[3] = victimMonk1;
        victimEntityList[4] = victimSiege1;
        victimEntityList[5] = victimVillager1;
        victimEntityList[6] = victimBarracks1;
        victimEntityList[7] = victimCastle1;

        entityListToCompare[0] = victimArcherToCompare;
        entityListToCompare[1] = victimCavalryToCompare;
        entityListToCompare[2] = victimInfantryToCompare;
        entityListToCompare[3] = victimMonkToCompare;
        entityListToCompare[4] = victimSiegeToCompare;
        entityListToCompare[5] = victimVillagerToCompare;
        entityListToCompare[6] = victimBarracksToCompare;
        entityListToCompare[7] = victimCastleToCompare;
    }

    public abstract void testInteractWithArcher();
    public abstract void testInteractWithCavalry();
    public abstract void testInteractWithInfantry();
    public abstract void testInteractWithMonk();
    public abstract void testInteractWithSiege();
    public abstract void testInteractWithVillager();
    public abstract void testInteractWithBarracks();
    public abstract void testInteractWithCastle();
    public abstract void testNoAPInteraction();
    public abstract void testDeadInteraction();
}
