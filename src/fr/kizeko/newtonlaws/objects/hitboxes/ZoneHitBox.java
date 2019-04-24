package fr.kizeko.newtonlaws.objects.hitboxes;


import fr.kizeko.newtonlaws.main.Main;

public class ZoneHitBox extends HitBox {

    /**
     * Constructeur de la classe ZoneHitBox
     * @param x Position(x)
     * @param y Position(y)
     * @param width Longueur
     * @param height Hauteur
     * @param displaying True si la HitBox est affichée
     */
    public ZoneHitBox(float x, float y, float width, float height, boolean displaying) {
        super(x, y, width, height, displaying);
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
