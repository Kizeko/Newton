package fr.kizeko.newtonlaws.objects;

import fr.kizeko.newtonlaws.animations.Animation;
import fr.kizeko.newtonlaws.animations.TrailAnimation;
import fr.kizeko.newtonlaws.main.Main;
import processing.core.PVector;

public class Trail extends GameObject {

    /**
     * Variable qui contient le temps lors de la création de l'objet en millisecondes
     */
    private final float time;

    /**
     * Valeurs red, green, blue, alpha du Trail
     */
    private float r, g, b, a;

    /**
     * Constructeur de la classe Trail héritant de GameObject
     * @param id Id
     * @param x Position(x)
     * @param y Position(y)
     * @param r Red
     * @param g Green
     * @param b Blue
     * @param a Alpha
     */
    protected Trail(String id, float x, float y, float r, float g, float b, float a) {
        super(id, x, y, 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f, null, new TrailAnimation());
        this.time = Main.getInstance().millis();
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    @Override
    protected void updateSpecs() {
    }

    public PVector getPosition() {
        return position;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getR() {
        return r;
    }

    public float getG() {
        return g;
    }

    public float getB() {
        return b;
    }

    public float getA() {
        return a;
    }

    public float getTime() {
        return time;
    }

    public Animation getAnimation() {
        return animation;
    }
}
