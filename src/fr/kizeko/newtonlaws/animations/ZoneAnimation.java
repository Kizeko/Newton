package fr.kizeko.newtonlaws.animations;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.GameObject;

public class ZoneAnimation extends Animation {

    /**
     * Constructeur de la classe ZoneAnimation
     */
    public ZoneAnimation() {
        super(0.5f);
    }

    @Override
    public void process(GameObject gameObject) {
        Main.getInstance().rect(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getWidth(), gameObject.getHeight());
    }
}
