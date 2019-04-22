package fr.kizeko.isn.animations;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.GameObject;

public class ZoneAnimation extends Animation {

    public ZoneAnimation() {
        super(0.1f);
    }

    @Override
    public void process(GameObject gameObject) {
        Main.getInstance().rect(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getWidth(), gameObject.getHeight());
    }
}
