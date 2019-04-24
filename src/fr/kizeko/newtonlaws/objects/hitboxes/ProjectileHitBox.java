package fr.kizeko.newtonlaws.objects.hitboxes;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.Zone;
import fr.kizeko.newtonlaws.utils.Constants;
import fr.kizeko.newtonlaws.utils.Functions;

public class ProjectileHitBox extends HitBox {

    /**
     * Constructeur de la classe ProjectileHitBox
     * @param x Position(x)
     * @param y Position(y)
     * @param width Longueur
     * @param height Hauteur
     * @param displaying True si la HitBox est affichée
     */
    public ProjectileHitBox(float x, float y, float width, float height, boolean displaying) {
        super(x, y, width, height, displaying);
    }

    /**
     * Affiche la HitBox
     */
    @Override
    protected void showHitbox() {
        if (this.displaying) {
            Main.getInstance().fill(0, 255, 0, 50);
            Main.getInstance().ellipse(this.position.x, this.position.y, this.width, this.height);
            Main.getInstance().fill(255);
        }
    }

    /**
     * @param zone Zone
     * @return 0 si contact avec la zone, 1 si contact avec le sol, 2 si aucun contact
     */
    public int hasCollided(Zone zone) {
        if (this.position.x + this.width / 2.0f >= zone.getPosition().x && this.position.x - this.width / 2.0f <= zone.getPosition().x + zone.getWidth() && this.position.y + this.height / 2.0f >= zone.getPosition().y + zone.getHeight() && this.position.y - this.height / 2.0f <= zone.getPosition().y + zone.getHeight()) {
            return 0;
        } else if (this.position.y >= Functions.convertYToOrigin(Constants.START_POSITION_Y)) {
            return 1;
        } else {
            return 2;
        }
    }
}
