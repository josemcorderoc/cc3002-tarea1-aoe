package ageofempires.units;

import ageofempires.AbstractEntity;
import ageofempires.IAttacker;

public abstract class AbstractUnit extends AbstractEntity implements IAttacker {

    protected AbstractUnit(float hp, float ap){
        super(hp, ap);
        setMaxHP(2*hp);
    }


}
