package ageofempires.buildings;

/**
 * The Barracks class models a barracks building: weak against Siege units,
 * weak against all other attacker units, it can not attack
 */
public class Barracks extends AbstractBuilding {

    private float[] coefBarracks = {0.7f, 0.7f, 0.7f, 2.0f, -0.7f, 0f, 0.7f};
    {
        setInteractionWithMe(coefBarracks);
    }

    /**
     * Barracks building constructor
     * @param hp hit points
     */
    public Barracks(float hp) {
        super(hp);
    }
}
