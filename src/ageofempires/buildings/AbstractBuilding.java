package ageofempires.buildings;

import ageofempires.AbstractEntity;
import ageofempires.units.AbstractUnit;

public class AbstractBuilding extends AbstractEntity {

    AbstractBuilding(float hp) {
        super(hp);
    }

    AbstractBuilding(float hp, float ap){
        super(hp, ap);
    }

}
