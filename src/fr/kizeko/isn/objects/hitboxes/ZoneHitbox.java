package fr.kizeko.isn.objects.hitboxes;


import fr.kizeko.isn.main.Main;

public class ZoneHitbox extends Hitbox {

    public ZoneHitbox(float x, float y, float width, float height, boolean displaying) {
        super(x, y, width, height, 0.0f, 0.0f, displaying);
    }

    @Override
    protected void showHitbox() {
        if (this.displaying) {
            Main.getInstance().fill(0, 255, 0, 50);
            Main.getInstance().rect(this.position.x, this.position.y, this.width, this.height);
            Main.getInstance().fill(255);
        }
    }
}
