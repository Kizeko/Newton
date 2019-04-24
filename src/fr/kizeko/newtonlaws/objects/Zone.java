package fr.kizeko.newtonlaws.objects;

import fr.kizeko.newtonlaws.animations.ZoneAnimation;
import fr.kizeko.newtonlaws.objects.hitboxes.ZoneHitBox;

public class Zone extends GameObject {

    /**
     * Constructeur de la classe Zone héritant de GameObject
     * @param id Id
     * @param x Position(x)
     * @param y Position(y)
     * @param width Longueur
     * @param height Hauteur
     */
    public Zone(String id, float x, float y, float width, float height) {
        super(id, x, y, 0.0f, 0.0f, 0.0f, 0.0f, width, height, new ZoneHitBox(x, y, width, height, true), new ZoneAnimation());
    }

    @Override
    protected void updateSpecs() {
    }

}
