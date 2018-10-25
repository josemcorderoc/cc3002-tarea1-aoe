package ageofempires.units;

import ageofempires.IAttackable;

public class Siege extends AbstractUnit {

    private float[] coefSiege = {1.2f, 0.8f, 1.2f, 1.5f, 0.5f, 0f, 0.5f};
    {
        setInteractionWithMe(coefSiege);
    }

    /**
     * Siege unit constructor
     * @param hp hit points
     * @param ap attack points
     */
    public Siege(float hp, float ap) {
        super(hp, ap);
        setMaxHP(hp);
    }

    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.attackedBySiege(this);
    }
}
