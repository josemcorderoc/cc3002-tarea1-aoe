package ageofempires.units;

import ageofempires.IAttackable;
import ageofempires.buildings.Castle;

public class Monk extends AbstractUnit {

    private float[] coefMonk = {1000, 1000, 1000, 1000, 1000, 1000, 1000};
    {
        setInteractionWithMe(coefMonk);
    }

    /**
     * Monk unit constructor
     * @param hp hit points
     * @param ap attack points
     */
    public Monk(float hp, float ap) {
        super(hp, ap);
    }

    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.curedByMonk(this);
    }

    @Override
    public void attackedByArcher(Archer archer){
        setCurrentHP(0);
    }

    @Override
    public void attackedByCavalry(Cavalry cavalry){
        setCurrentHP(0);
    }

    @Override
    public void attackedByInfantry(Infantry infantry){
        setCurrentHP(0);
    }

    @Override
    public void attackedBySiege(Siege siege){
        setCurrentHP(0);
    }

    @Override
    public void attackedByCastle(Castle castle){
        setCurrentHP(0);
    }
}
