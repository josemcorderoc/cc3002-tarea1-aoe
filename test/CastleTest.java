package test;

import ageofempires.buildings.Castle;

/**
 * Test the Castle class associated methods
 *
 * @author Jose Miguel Cordero
 */
public class CastleTest extends AbstractAttackerTest {

    private Castle castle;
    private Castle castleNoAP;
    private Castle castleDead;

    @Override
    void setUp() {
        super.setUp();
        castle = new Castle(100,100);
        castleNoAP = new Castle(100, 0);
        castleDead = new Castle(0, 100);
    }
}
