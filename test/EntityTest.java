package test;

import ageofempires.buildings.*;
import ageofempires.units.*;
import org.junit.*;

public class EntityTest {

    @Before
    public void setUp(){
        Archer archer1 = new Archer(100,100);
        Archer archer2 = new Archer(100,100);
        Cavalry cavalry1 = new Cavalry(100,100);
        Cavalry cavalry2 = new Cavalry(100,100);
        Infantry infantry1 = new Infantry(100,100);
        Infantry infantry2 = new Infantry(100,100);
        Monk monk1 = new Monk(100,100);
        Siege siege1 = new Siege(100,100);
        Siege siege2 = new Siege(100,100);
        Villager villager1 = new Villager(100,100);
        Barracks barracks1 = new Barracks(100);
        Castle castle1 = new Castle(100,100);
        Castle castle2 = new Castle(100,100);

    }
}
