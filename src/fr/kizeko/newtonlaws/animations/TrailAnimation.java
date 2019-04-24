package fr.kizeko.newtonlaws.animations;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.GameObject;
import fr.kizeko.newtonlaws.objects.Trail;

public class TrailAnimation extends Animation {

    /**
     * Constructeur de la classe TrailAnimation
     */
    public TrailAnimation() {
        super(0.5f);
    }

    @Override
    public void process(GameObject gameObject) {
        Main.getInstance().fill(((Trail) gameObject).getR(), ((Trail) gameObject).getG(), ((Trail) gameObject).getB(),
                ((Trail) gameObject).getA());
        Main.getInstance().noStroke();
        Main.getInstance().ellipse(gameObject.getPosition().x, gameObject.getPosition().y, gameObject.getWidth(), gameObject.getHeight());
        Main.getInstance().stroke(0, 255);
        Main.getInstance().fill(255, 255);
    }
}
