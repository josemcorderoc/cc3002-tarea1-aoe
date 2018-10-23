package ageofempires;


import ageofempires.buildings.Castle;
import ageofempires.units.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the properties and behavior of all attackable entitys of the game
 * @author Jose Miguel Cordero
 */
public abstract class AbstractEntity implements IAttackable {

    private float currentHP;
    private float maxHP;
    private float attackPoints;

    private static final Map<String, Float> interactionWithMe = new HashMap<String, Float>();


    protected AbstractEntity(float hp) {
        this(hp, 0);
    }

    protected AbstractEntity(float hp, float ap){
        currentHP = hp;
        maxHP = hp;
        attackPoints = ap;
    }

    protected void setInteractionWithMe(float[] coef) {
        interactionWithMe.put("Infantry", coef[0]);
        interactionWithMe.put("Archer", coef[1]);
        interactionWithMe.put("Cavalry", coef[2]);
        interactionWithMe.put("Siege", coef[3]);
        interactionWithMe.put("Villager", coef[4]);
        interactionWithMe.put("Monk", coef[5]);
        interactionWithMe.put("Castle", coef[6]);
    }

    /**
     * An attack received from an archer unit. Removes an amount of points
     * of the entity depending of both entity type and archer unit attack points
     * @param archerUnit attacker archer unit
     */
    public void attackedByArcher(Archer archerUnit){
        if (!isAlive()) { return; }
        currentHP -= interactionWithMe.get("Archer")*archerUnit.getAttackPoints();
    }

    /**
     * An attack received from a cavalry unit. Removes an amount of points
     * of the entity depending of both entity type and cavalry unit attack points
     * @param cavalryUnit attacker cavalry unit
     */
    public void attackedByCavalry(Cavalry cavalryUnit){
        if (!isAlive()) { return; }
        currentHP -= interactionWithMe.get("Cavalry")*cavalryUnit.getAttackPoints();
    }


    /**
     * @param infantryUnit
     */
    public void attackedByInfantry(Infantry infantryUnit){
        if (!isAlive()) { return; }
        currentHP -= interactionWithMe.get("Infantry")*infantryUnit.getAttackPoints();
    }

    public void attackedBySiege(Siege siegeUnit){
        if (!isAlive()) { return; }
        currentHP -= interactionWithMe.get("Siege")*siegeUnit.getAttackPoints();
    }

    public void attackedByCastle(Castle castleBuilding){
        if (!isAlive()) { return; }
        currentHP -= interactionWithMe.get("Castle")*castleBuilding.getAttackPoints();
    }

    public void curedByMonk(Monk monk){
        if (!isAlive()) { return; }
        currentHP += interactionWithMe.get("Monk")*monk.getAttackPoints();
    }

    public void handledByVillager(Villager villager){
        if (!isAlive()) { return; }
        currentHP -= interactionWithMe.get("Villager")*villager.getAttackPoints();
    }

    @Override
    public float getCurrentHP() { return currentHP; }

    @Override
    public void setCurrentHP(float newHitPoints) { currentHP = newHitPoints; }

    public float getMaxHP() { return currentHP; }

    public void setMaxHP(float newMaxHP) { currentHP = newMaxHP; }

    @Override
    public float getAttackPoints() { return attackPoints;}

    @Override
    public void setAttackPoints(float newAttackPoints) {attackPoints = newAttackPoints;}

    @Override
    public boolean isAlive() { return currentHP > 0; }







}
