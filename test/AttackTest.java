package test;

import ageofempires.AbstractEntity;
import ageofempires.buildings.*;
import ageofempires.units.*;

public class AttackTest {

    protected Archer victimArcher1;
    protected Cavalry victimCavalry1;
    protected Infantry victimInfantry1;
    protected Monk victimMonk1;
    protected Siege victimSiege1;
    protected Villager victimVillager1;
    protected Barracks victimBarracks1;
    protected Castle victimCastle1;

    protected Archer victimArcher2;
    protected Cavalry victimCavalry2;
    protected Infantry victimInfantry2;
    protected Monk victimMonk2;
    protected Siege victimSiege2;
    protected Villager victimVillager2;
    protected Barracks victimBarracks2;
    protected Castle victimCastle2;

    protected Archer victimArcher3;
    protected Cavalry victimCavalry3;
    protected Infantry victimInfantry3;
    protected Monk victimMonk3;
    protected Siege victimSiege3;
    protected Villager victimVillager3;
    protected Barracks victimBarracks3;
    protected Castle victimCastle3;

    protected AbstractEntity[] entitiesList1 = new AbstractEntity[8];
    protected AbstractEntity[] entitiesList2 = new AbstractEntity[8];
    protected AbstractEntity[] entitiesList3 = new AbstractEntity[8];
    protected AbstractEntity[] entitiesListForCompare = new AbstractEntity[8];

    public void setUp(){

        entitiesList1[0] = new Archer(100,100);
        entitiesList1[1] = new Cavalry(100,100);
        entitiesList1[2] = new Infantry(100,100);
        entitiesList1[3] = new Monk(100,100);
        entitiesList1[4] = new Siege(100,100);
        entitiesList1[5] = new Villager(100,100);
        entitiesList1[6] = new Barracks(100);
        entitiesList1[7] = new Castle(100,100);

        entitiesList2[0] = new Archer(100,100);
        entitiesList2[1] = new Cavalry(100,100);
        entitiesList2[2] = new Infantry(100,100);
        entitiesList2[3] = new Monk(100,100);
        entitiesList2[4] = new Siege(100,100);
        entitiesList2[5] = new Villager(100,100);
        entitiesList2[6] = new Barracks(100);
        entitiesList2[7] = new Castle(100,100);

        entitiesList3[0] = new Archer(100,100);
        entitiesList3[1] = new Cavalry(100,100);
        entitiesList3[2] = new Infantry(100,100);
        entitiesList3[3] = new Monk(100,100);
        entitiesList3[4] = new Siege(100,100);
        entitiesList3[5] = new Villager(100,100);
        entitiesList3[6] = new Barracks(100);
        entitiesList3[7] = new Castle(100,100);

        /*
        victimArcher1 = new Archer(100,100);
        victimCavalry1 = new Cavalry(100,100);
        victimInfantry1 = new Infantry(100,100);
        victimMonk1 = new Monk(100,100);
        victimSiege1 = new Siege(100,100);
        victimVillager1 = new Villager(100,100);
        victimBarracks1 = new Barracks(100);
        victimCastle1 = new Castle(100,100);

        victimArcher2 = new Archer(100,100);
        victimCavalry2 = new Cavalry(100,100);
        victimInfantry2 = new Infantry(100,100);
        victimMonk2 = new Monk(100,100);
        victimSiege2 = new Siege(100,100);
        victimVillager2 = new Villager(100,100);
        victimBarracks2 = new Barracks(100);
        victimCastle2 = new Castle(100,100);

        victimArcher3 = new Archer(100,100);
        victimCavalry3 = new Cavalry(100,100);
        victimInfantry3 = new Infantry(100,100);
        victimMonk3 = new Monk(100,100);
        victimSiege3 = new Siege(100,100);
        victimVillager3 = new Villager(100,100);
        victimBarracks3 = new Barracks(100);
        victimCastle3 = new Castle(100,100);
        */

    }
}
