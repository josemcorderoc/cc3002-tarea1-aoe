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
     * True if entity is alive (positive hit points), False if it is not
     * @return
     */
    boolean isAlive();

    /**
     * @param archerUnit
     */
    void attackedByArcher(Archer archerUnit);
    void attackedByCavalry(Cavalry cavalryUnit);
    void attackedByInfantry(Infantry infantryUnit);
    void curedByMonk(Monk monkUnit);
    void attackedBySiege(Siege siegeUnit);
    void handledByVillager(Villager villagerUnit);
    void attackedByCastle(Castle castleBuilding);
}
