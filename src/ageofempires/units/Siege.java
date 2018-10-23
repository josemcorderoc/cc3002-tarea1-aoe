package ageofempires.units;

import ageofempires.IAttackable;

public class Siege extends AbstractUnit {

    private float[] coefSiege = {1.2f, 0.8f, 1.2f, 1.5f, 0.5f, 0f, 0.5f};
    {
        setInteractionWithMe(coefSiege);
    }

    public Siege(float hp, float ap) {
        super(hp, ap);
    }

    @Override
    public void interactWith(IAttackable victim) {
        victim.attackedBySiege(this);
    }
}
