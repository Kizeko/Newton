package fr.kizeko.isn.objects.hitboxes;

import fr.kizeko.isn.objects.Zone;
import fr.kizeko.isn.utils.Constants;

public class ProjectileHitbox extends Hitbox {

    public ProjectileHitbox(float x, float y, float width, float height, boolean displaying) {
        super(x, y, width, height, 0.0f, 0.0f, displaying);
    }

    public boolean hasCollided(Zone zone) {
        //800 --> height of the floor
        if (this.position.x >= zone.getPosition().x && this.position.x <= zone.getPosition().x && zone.getPosition().y >= Constants.START_POSITION_Y + 50.0f) {
            System.out.println("TOUCHED");
            return true;
        } else {
            return false;
        }
    }
}
