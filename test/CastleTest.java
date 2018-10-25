package test;

import ageofempires.buildings.Castle;

public class CastleTest extends AbstractAttackerTest {

    private Castle castle1;
    private Castle castle2;
    private Castle castleNoAP;
    private Castle castleDead;

    @Override
    void setUp() {
        super.setUp();
        castle1 = new Castle(100,100);
        castle2 = new Castle(200, 50);
        castleNoAP = new Castle(100, 0);
        castleDead = new Castle(0, 100);
    }
}
