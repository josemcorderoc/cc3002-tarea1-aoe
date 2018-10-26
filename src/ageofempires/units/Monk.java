package ageofempires.units;

import ageofempires.IAttackable;
import ageofempires.buildings.Castle;

/**
 * Monk unit class
 *
 * @author Jose Miguel Cordero
 */
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

    /**
     * {@inheritDoc}
     * @param victim entity to modify
     */
    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.curedByMonk(this);
    }

    /**
     * {@inheritDoc}
     * @param archerUnit attacker archer unit
     */
    @Override
    public void attackedByArcher(Archer archerUnit) {
        if (this.isAlive() && archerUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    /**
     * {@inheritDoc}
     * @param cavalryUnit attacker cavalry unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalryUnit) {
        if (this.isAlive() && cavalryUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    /**
     * {@inheritDoc}
     * @param infantryUnit attacker infantry unit
     */
    @Override
    public void attackedByInfantry(Infantry infantryUnit){
        if (this.isAlive() && infantryUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    /**
     * {@inheritDoc}
     * @param siegeUnit attacker siege unit
     */
    @Override
    public void attackedBySiege(Siege siegeUnit){
        if (this.isAlive() && siegeUnit.isAlive()) {
            setCurrentHP(0);
        }
    }

    /**
     * {@inheritDoc}
     * @param castleBuilding attacker castle building
     */
    @Override
    public void attackedByCastle(Castle castleBuilding){
        if (this.isAlive() && castleBuilding.isAlive()) {
            setCurrentHP(0);
        }
    }
}
