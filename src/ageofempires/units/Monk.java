package ageofempires.units;

import ageofempires.IAttackable;
import ageofempires.buildings.Castle;

public class Monk extends AbstractUnit {

    private float[] coefMonk = {10000f, 10000f, 10000f, 10000f, 0f, 0.5f, 10000f};
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
    public void attackedByArcher(Archer archerUnit) {
        if (this.isAlive() && archerUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    @Override
    public void attackedByCavalry(Cavalry cavalryUnit) {
        if (this.isAlive() && cavalryUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    @Override
    public void attackedByInfantry(Infantry infantryUnit){
        if (this.isAlive() && infantryUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    @Override
    public void attackedBySiege(Siege siegeUnit){
        if (this.isAlive() && siegeUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    @Override
    public void attackedByCastle(Castle castleBuilding){
        if (this.isAlive() && castleBuilding.isAlive()) {
            setCurrentHP(0);
        }
    }
}
