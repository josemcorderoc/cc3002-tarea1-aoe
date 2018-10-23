package ageofempires.units;

import ageofempires.IAttackable;

import java.util.HashMap;
import java.util.Map;

public class Infantry extends AbstractUnit {

    private float[] coefInfantry = {1.0f, 1.2f, 1.0f, 1.5f, 0.8f, 0.5f, 1.2f};
    {
        setInteractionWithMe(coefInfantry);
    }

    public Infantry(float hp, float ap) {
        super(hp, ap);
    }

    @Override
    public void interactWith(IAttackable victim) {
        victim.attackedByInfantry(this);
    }
}
