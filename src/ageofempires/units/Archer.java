package ageofempires.units;

import ageofempires.IAttackable;

public class Archer extends AbstractUnit {

    private float[] coefArcher = {1.2f, 1.2f, 1.5f, 1.5f, 1.0f, 0.5f, 1.2f};
    {
        setInteractionWithMe(coefArcher);
    }

    public Archer(float hp, float ap) {
        super(hp, ap);
    }


    @Override
    public void interactWith(IAttackable victim) {
        victim.attackedByArcher(this);
    }

}