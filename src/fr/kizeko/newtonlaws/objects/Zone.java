package fr.kizeko.newtonlaws.objects;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.hitboxes.ZoneHitBox;

public class Zone extends GameObject {

    /**
     * Constructeur de la classe Zone héritant de GameObject
     * @param x Position(x)
     * @param y Position(y)
     * @param width Longueur
     * @param height Hauteur
     */
    public Zone(float x, float y, float width, float height) {
        super(x, y, width, height, new ZoneHitBox(x, y, width, height, true));
    }

    @Override
    protected void draw() {
        Main.getInstance().rect(this.position.x, this.position.y, this.width, this.height);
    }
}
