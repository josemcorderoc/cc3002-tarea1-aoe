package ageofempires.buildings;

public class Barracks extends AbstractBuilding {

    private float[] coefBarracks = {0.7f, 0.7f, 0.7f, 2.0f, 0.7f, 0f, 0.7f};
    {
        setInteractionWithMe(coefBarracks);
    }


    public Barracks(float hp) {
        super(hp);
    }
}
