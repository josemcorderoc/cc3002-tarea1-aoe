package ageofempires;


import ageofempires.buildings.Castle;
import ageofempires.units.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements properties and behavior of all attackable entitys of the game
 *
 * @author Jose Miguel Cordero
 */
public abstract class AbstractEntity implements IAttackable {

    private float currentHP;
    private float maxHP;
    private float attackPoints;

    private final Map<String, Float> interactionWithMe = new HashMap<>();

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
     * Getter method for current hit points
     * @return currentHP
     */
    public float getCurrentHP() { return currentHP; }

    /**
     * Setter method for current hit points
     * @param newHitPoints new setting HP
     */
    public void setCurrentHP(float newHitPoints) { currentHP = newHitPoints; }

    /**
     * Getter method for max hit points
     * @return max hit points
     */
    public float getMaxHP() { return maxHP; }
    public void setMaxHP(float newMaxHP) { maxHP = newMaxHP; }

    public float getAttackPoints() { return attackPoints; }
    public void setAttackPoints(float newAttackPoints) { attackPoints = newAttackPoints; }

    /**
     * {@inheritDoc}
     * @return boolean
     */
    @Override
    public boolean isAlive() { return currentHP > 0; }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() == o.getClass()) {
            return this.currentHP == ((AbstractEntity)o).currentHP &&
                    this.attackPoints == ((AbstractEntity)o).attackPoints;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @param archerUnit attacker archer unit
     */
    @Override
    public void attackedByArcher(Archer archerUnit) {
        if (this.isAlive() && archerUnit.isAlive()) {
            currentHP -= interactionWithMe.get("Archer") * archerUnit.getAttackPoints();
            if (currentHP < 0) { setCurrentHP(0);}
        }
    }

    /**
     * {@inheritDoc}
     * @param cavalryUnit attacker cavalry unit
     */
    @Override
    public void attackedByCavalry(Cavalry cavalryUnit) {
        if (this.isAlive() && cavalryUnit.isAlive()) {
            currentHP -= interactionWithMe.get("Cavalry") * cavalryUnit.getAttackPoints();
            if (currentHP < 0) { setCurrentHP(0);}
        }

    }

    /**
     * {@inheritDoc}
     * @param infantryUnit attacker infantry unit
     */
    @Override
    public void attackedByInfantry(Infantry infantryUnit) {
        if (this.isAlive() && infantryUnit.isAlive()) {
            currentHP -= interactionWithMe.get("Infantry")*infantryUnit.getAttackPoints();
            if (currentHP < 0) { setCurrentHP(0);}
        }
    }

    /**
     * {@inheritDoc}
     * @param siegeUnit attacker siege unit
     */
    @Override
    public void attackedBySiege(Siege siegeUnit) {
        if (this.isAlive() && siegeUnit.isAlive()) {
            currentHP -= interactionWithMe.get("Siege") * siegeUnit.getAttackPoints();
            if (currentHP < 0) { setCurrentHP(0); }
        }
    }

    /**
     * {@inheritDoc}
     * @param castleBuilding attacker castle building
     */
    @Override
    public void attackedByCastle(Castle castleBuilding) {
        if (this.isAlive() && castleBuilding.isAlive()) {
            currentHP -= interactionWithMe.get("Castle") * castleBuilding.getAttackPoints();
            if (currentHP < 0) { setCurrentHP(0); }
        }
    }

    /**
     * {@inheritDoc}
     * @param monkUnit
     */
    @Override
    public void curedByMonk(Monk monkUnit) {
        if (this.isAlive() && monkUnit.isAlive()) {
            currentHP += interactionWithMe.get("Monk") * monkUnit.getAttackPoints();
            if (currentHP > maxHP) { setCurrentHP(maxHP); }
        }
    }

    /**
     * {@inheritDoc}
     * @param villagerUnit
     */
    @Override
    public void handledByVillager(Villager villagerUnit) {
        if (this.isAlive() && villagerUnit.isAlive()) {
            currentHP -= interactionWithMe.get("Villager") * villagerUnit.getAttackPoints();
            if (currentHP < 0) { setCurrentHP(0); }
            else if (currentHP > maxHP) { setCurrentHP(maxHP); }
        }
    }

}