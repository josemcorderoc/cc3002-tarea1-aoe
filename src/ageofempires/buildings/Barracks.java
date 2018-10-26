package ageofempires.buildings;

/**
 * Barracks building class
 *
 * @author Jose Miguel Cordero
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
