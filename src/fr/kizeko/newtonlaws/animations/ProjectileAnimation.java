package fr.kizeko.newtonlaws.animations;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.GameObject;
import fr.kizeko.newtonlaws.objects.Projectile;

public class ProjectileAnimation extends Animation {

    /**
     * Constructeur de la classe ProjectileAnimation
     */
    public ProjectileAnimation() {
        super(0.5f);
    }

    @Override
    public void process(GameObject gameObject) {
        Main.getInstance().fill(255, ((Projectile) gameObject).getAlpha());
        Main.getInstance().stroke(0, ((Projectile) gameObject).getAlpha());
        Main.getInstance().ellipse(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getWidth(), gameObject.getHeight());
        Main.getInstance().fill(255, 255);
        Main.getInstance().stroke(0, 255);
    }
}
