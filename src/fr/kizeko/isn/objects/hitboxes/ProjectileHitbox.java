package fr.kizeko.isn.objects.hitboxes;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.GameObject;
import fr.kizeko.isn.objects.Projectile;
import fr.kizeko.isn.objects.Zone;
import fr.kizeko.isn.utils.Constants;
import fr.kizeko.isn.utils.Functions;
import processing.core.PVector;

public class ProjectileHitbox extends Hitbox {

    public ProjectileHitbox(float x, float y, float width, float height, boolean displaying) {
        super(x, y, width, height, 0.0f, 0.0f, displaying);
    }

    @Override
    protected void showHitbox() {
        if (this.displaying) {
            Main.getInstance().fill(0, 255, 0, 50);
            Main.getInstance().ellipse(this.position.x, this.position.y, this.width, this.height);
            Main.getInstance().fill(255);
        }
    }

    public int hasCollided(Zone zone) {
        if (this.position.x + this.width / 2.0f >= zone.getPosition().x && this.position.x - this.width / 2.0f <= zone.getPosition().x + zone.getWidth() && this.position.y + this.height / 2.0f >= zone.getPosition().y + zone.getHeight() && this.position.y - this.height / 2.0f <= zone.getPosition().y + zone.getHeight()) {
            return 0;
        } else if (this.position.y >= Functions.convertYToOrigin(Constants.FLOOR_POSITION_Y)) {
            return 1;
        } else {
            return 2;
        }
    }

    protected void destroyOutOfScreen() {
        if (this.position.x < -Constants.START_POSITION_X) {
            //return 0;
        } else if (this.position.x > Main.getInstance().width - Constants.START_POSITION_X) {
            //return 1;
        } else if (this.position.y < -Constants.START_POSITION_Y) {
            //return 2;
        } else if (this.position.y > Constants.FLOOR_POSITION_Y - Constants.START_POSITION_Y) {
            //return 3;
        } else {
            //return 4;
        }
    }
}
