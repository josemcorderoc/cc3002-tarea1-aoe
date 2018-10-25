package test;

import ageofempires.AbstractEntity;
import ageofempires.units.Cavalry;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test the Cavalry class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class CavalryTest extends AbstractAttackerTest {

    private Cavalry attackerCavalry;
    private Cavalry attackerCavalryNoAP;
    private Cavalry attackerCavalryDead;

    @Before
    void setUp(){
        super.setUp();
        attackerCavalry = new Cavalry(100,200);
        attackerCavalryNoAP = new Cavalry(100,0);
        attackerCavalryDead = new Cavalry(0,100);
        }


}

