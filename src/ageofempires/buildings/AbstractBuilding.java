package ageofempires.buildings;

import ageofempires.AbstractEntity;
import ageofempires.units.AbstractUnit;

public class AbstractBuilding extends AbstractEntity {

    protected AbstractBuilding(float hp) {
        super(hp);
    }

    protected AbstractBuilding(float hp, float ap){
        super(hp, ap);
    }

}
