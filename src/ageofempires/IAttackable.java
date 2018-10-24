package ageofempires;

import ageofempires.buildings.Castle;
import ageofempires.units.*;

/**
 * Models behavior of an attackable entity of the game
 * @author Jose Miguel Cordero
 */
public interface IAttackable {

    float getCurrentHP();
    void setCurrentHP(float hp);

    float getAttackPoints();
    void setAttackPoints(float hp);

    /**
     * True if entity is alive (positive hit points), False if is not
     * @return boolean
     */
    boolean isAlive();

    /**
     * An attack received from an archer unit. Removes an amount of points
     * of the entity depending of both entity type and archer unit attack points
     * @param archerUnit attacker archer unit
     */
    void attackedByArcher(Archer archerUnit);


    /**
     * @param cavalryUnit attacker cavalry unit
     */
    void attackedByCavalry(Cavalry cavalryUnit);

    /**
     *
     * @param infantryUnit attacker infantry unit
     */
    void attackedByInfantry(Infantry infantryUnit);

    /**
     *
     * @param monkUnit attacker monk unit
     */
    void curedByMonk(Monk monkUnit);

    /**
     *
     * @param siegeUnit attacker siege unit
     */
    void attackedBySiege(Siege siegeUnit);

    /**
     *
     * @param villagerUnit attacker villager unit
     */
    void handledByVillager(Villager villagerUnit);

    /**
     *
     * @param castleBuilding attacker castle building
     */
    void attackedByCastle(Castle castleBuilding);
}
