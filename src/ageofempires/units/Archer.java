package ageofempires.units;

import ageofempires.IAttackable;

/**
 * Archer unit class
 *
 * @author Jose Miguel Cordero
 */
public class Archer extends AbstractUnit {

    private float[] coefArcher = {1.2f, 1.2f, 1.5f, 1.5f, 1.0f, 0.5f, 1.2f};
    {
        setInteractionWithMe(coefArcher);
    }

    /**
     * Archer unit constructor
     * @param hp hit points
     * @param ap attack points
     */
    public Archer(float hp, float ap) {
        super(hp, ap);
    }

    /**
     * {@inheritDoc}
     * @param victim entity to modify
     */
    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.attackedByArcher(this);
    }

}