package ageofempires.units;

import ageofempires.IAttackable;

public class Cavalry extends AbstractUnit {

    private float[] coefCavalry = {1.2f, 1.0f, 1.0f, 1.0f, 0.5f, 0.5f, 1.2f};
    {
        setInteractionWithMe(coefCavalry);
    }

    public Cavalry(float hp, float ap) { super(hp, ap); }

    @Override
    public void interactWith(IAttackable victim) {
        victim.attackedByCavalry(this);
    }
}
