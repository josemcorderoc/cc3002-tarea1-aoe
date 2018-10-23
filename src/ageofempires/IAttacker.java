package ageofempires;

/**
 * Models behavior of an attacker entity of the game
 * @author Jose Miguel Cordero
 */
public interface IAttacker extends IAttackable {

    /**
     * Depending of the attacker entity , this method modifies (or not) the victim entity
     * @param victim entity to modify
     */
    void interactWith(IAttackable victim);
}
