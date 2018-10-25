package test;

import ageofempires.AbstractEntity;
import ageofempires.buildings.*;
import ageofempires.units.*;

public abstract class AbstractAttackerTest {

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


    Archer[] archerList = new Archer[5];
    Cavalry[] cavalryList = new Cavalry[5];
    Infantry[] infantryList = new Infantry[5];
    Monk[] monkList = new Monk[5];
    Siege[] siegeList = new Siege[5];
    Villager[] villagerList = new Villager[5];
    Barracks[] barracksList = new Barracks[5];
    Castle[] castleList = new Castle[5];

    public void setUp() {
        
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
        

        archerList[0] = victimArcher1;
        archerList[1] = victimArcher2;
        archerList[2] = victimArcher3;
        archerList[3] = victimArcherNoAP;
        archerList[4] = victimArcherDead; 

        cavalryList[0] = victimCavalry1;
        cavalryList[1] = victimCavalry2;
        cavalryList[2] = victimCavalry3;
        cavalryList[3] = victimCavalryNoAP;
        cavalryList[4] = victimCavalryDead;

        infantryList[0] = victimInfantry1;
        infantryList[1] = victimInfantry2;
        infantryList[2] = victimInfantry3;
        infantryList[3] = victimInfantryNoAP;
        infantryList[4] = victimInfantryDead;

        monkList[0] = victimMonk1;
        monkList[1] = victimMonk2;
        monkList[2] = victimMonk3;
        monkList[3] = victimMonkNoAP;
        monkList[4] = victimMonkDead;

        siegeList[0] = victimSiege1 ;
        siegeList[1] = victimSiege2 ;
        siegeList[2] = victimSiege3 ;
        siegeList[3] = victimSiegeNoAP;
        siegeList[4] = victimSiegeDead;

        villagerList[0] = victimVillager1;
        villagerList[1] = victimVillager2;
        villagerList[2] = victimVillager3;
        villagerList[3] = victimVillagerNoAP;
        villagerList[4] = victimVillagerDead;

        barracksList[0] = victimBarracks1;
        barracksList[1] = victimBarracks2;
        barracksList[2] = victimBarracks3;
        barracksList[3] = victimBarracksNoAP;
        barracksList[4] = victimBarracksDead;

        castleList[0] = victimCastle1;
        castleList[1] = victimCastle2;
        castleList[2] = victimCastle3;
        castleList[3] = victimCastleNoAP;
        castleList[4] = victimCastleDead;
    }
        /**
         * Test how does this entity interact with archer units
         */
        abstract void testInteractWithArcher();

        /**
         * Test how does this entity interact with cavalry units
         */
        abstract void testInteractWithCavalry();

        /**
         * Test how does this entity interact with infantry units
         */
        abstract void testInteractWithInfantry();

        /**
         * Test how does this entity interact with monk units
         */
        abstract void testInteractWithMonk();

        /**
         * Test how does this entity interact with siege units
         */
        abstract void testInteractWithSiege();

        /**
         * Test how does this entity interact with villager units
         */
        abstract void testInteractWithVillager();

        /**
         * Test how does this entity interact with barracks buildings
         */
        abstract void testInteractWithBarracks();

        /**
         * Test how does this entity interact with castle buildings
         */
        abstract void testInteractWithCastle();
}
