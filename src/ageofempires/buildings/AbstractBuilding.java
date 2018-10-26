package ageofempires.buildings;

import ageofempires.AbstractEntity;

/**
 * Implements properties and behavior of buildings of the game
 *
 * @author Jose Miguel Cordero
 */
class AbstractBuilding extends AbstractEntity {

    AbstractBuilding(float hp) {
        super(hp);
    }

    AbstractBuilding(float hp, float ap){
        super(hp, ap);
    }

}
