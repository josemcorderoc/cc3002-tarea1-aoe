package ageofempires.buildings;

import ageofempires.AbstractEntity;
import ageofempires.units.AbstractUnit;

/**
 * Implements properties and behavior of buildings of the game
 *
 * @author Jose Miguel Cordero
 */
public class AbstractBuilding extends AbstractEntity {

    AbstractBuilding(float hp) {
        super(hp);
    }

    AbstractBuilding(float hp, float ap){
        super(hp, ap);
    }

}
