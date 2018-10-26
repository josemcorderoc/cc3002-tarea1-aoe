package ageofempires.units;

import ageofempires.IAttackable;

/**
 * Villager unit class
 *
 * @author Jose Miguel Cordero
 */
public class Villager extends AbstractUnit {

    private float[] coefVillager = {1.5f, 1.5f, 1.5f, 1.5f, 1.0f, 0.5f, 1.2f};
    {
        setInteractionWithMe(coefVillager);
    }

    /**
     * Villager unit constructor
     * @param hp hit points
     * @param ap attack points
     */
    public Villager(float hp, float ap){
        super(hp, ap);
    }

    /**
     * {@inheritDoc}
     * @param victim entity to modify
     */
    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.handledByVillager(this);
    }
}
