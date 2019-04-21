package fr.kizeko.isn.animations;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.GameObject;

public class ProjectileAnimation extends Animation {

    public ProjectileAnimation() {
        super(0.5f);
    }

    @Override
    public void process(GameObject gameObject) {
        Main.getInstance().ellipse(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getWidth(), gameObject.getHeight());
    }
}
