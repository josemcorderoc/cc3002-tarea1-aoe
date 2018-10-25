package ageofempires;

import ageofempires.buildings.Castle;
import ageofempires.units.*;

/**
 * Models behavior of an attackable entity of the game
 * @author Jose Miguel Cordero
 */
public interface IAttackable {

    /**
     * True if entity is alive (positive hit points), False if is not
     *
     * @return status (dead or alive)
     */
    boolean isAlive();

    /**
     * An attack received from an archer unit. Removes an amount of points
     * of the entity depending of both entity type and archer unit attack points
     *
     * @param archerUnit attacker archer unit
     */
    void attackedByArcher(Archer archerUnit);


    /**
     * An attack received from a cavalry unit. Removes an amount of points
     * of the entity depending of both entity type and cavalry unit attack points
     *
     * @param cavalryUnit attacker cavalry unit
     */
    void attackedByCavalry(Cavalry cavalryUnit);

    /**
     * An attack received from an infantry unit. Removes an amount of points
     * of the entity depending of both entity type and infantry unit attack points
     *
     * @param infantryUnit attacker infantry unit
     */
    void attackedByInfantry(Infantry infantryUnit);

    /**
     * A curing received from a monk unit. Adds an amount of points of
     * the entity depending of both entity type and monk unit attack points
     *
     * @param monkUnit curing monk unit
     */
    void curedByMonk(Monk monkUnit);

    /**
     * An attack received from a siege unit. Removes an amount of points
     * of the entity depending of both entity type and siege unit attack points
     *
     * @param siegeUnit attacker siege unit
     */
    void attackedBySiege(Siege siegeUnit);

    /**
     * An interaction between this entity and a villager unit. Removes or adds an amount of points
     * of the entity depending of both entity type and villager unit unit attack points
     *
     * @param villagerUnit interacting villager unit
     */
    void handledByVillager(Villager villagerUnit);

    /**
     * An attack received from a castle building. Removes an amount of points
     * of the entity depending of both entity type and castle attack points
     *
     * @param castleBuilding attacker castle building
     */
    void attackedByCastle(Castle castleBuilding);
}
