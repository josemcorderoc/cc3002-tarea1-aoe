package ageofempires.units;

import ageofempires.IAttackable;

import java.util.HashMap;
import java.util.Map;

/**
 * Infantry unit class
 *
 * @author Jose Miguel Cordero
 */
public class Infantry extends AbstractUnit {

    private float[] coefInfantry = {1.0f, 1.2f, 1.0f, 1.5f, 0.8f, 0.5f, 1.2f};
    {
        setInteractionWithMe(coefInfantry);
    }

    /**
     * Infantry unit constructor
     * @param hp hit points
     * @param ap attack points
     */
    public Infantry(float hp, float ap) {
        super(hp, ap);
    }

    /**
     * {@inheritDoc}
     * @param victim entity to modify
     */
    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.attackedByInfantry(this);
    }
}
