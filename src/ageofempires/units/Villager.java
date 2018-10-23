package ageofempires.units;

import ageofempires.IAttackable;

public class Villager extends AbstractUnit {

    private float[] coefVillager = {1.5f, 1.5f, 1.5f, 1.5f, 1.0f, 0.5f, 10000f};

    public Villager(float hp, float ap){
        super(hp, ap);
    }

    @Override
    public void interactWith(IAttackable victim) {
        victim.handledByVillager(this);
    }
}
