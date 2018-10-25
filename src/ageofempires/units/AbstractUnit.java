package ageofempires.units;

import ageofempires.AbstractEntity;
import ageofempires.IAttacker;

/**
 * Implements properties and behavior of units of the game
 *
 * @author Jose Miguel Cordero
 */
public abstract class AbstractUnit extends AbstractEntity implements IAttacker {

    AbstractUnit(float hp, float ap) {
        super(hp, ap);
        setMaxHP(2*hp);
    }
}
