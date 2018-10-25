package ageofempires.buildings;

import ageofempires.IAttackable;
import ageofempires.IAttacker;


public class Castle extends AbstractBuilding implements IAttacker {

    private float[] coefCastle = {0.3f, 0.1f, 0.3f, 2.0f, 0.3f, 0f, 0.1f};
    {
        setInteractionWithMe(coefCastle);
    }

    /**
     * Castle building constructor
     * @param hp hit points
     * @param ap attack point
     */
    public Castle(float hp, float ap) {
        super(hp, ap);
    }

    @Override
    public void interactWith(IAttackable victim) {
        if (!isAlive()) { return; }
        victim.attackedByCastle(this);
    }
}
