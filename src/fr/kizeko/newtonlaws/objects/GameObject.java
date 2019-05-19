package fr.kizeko.newtonlaws.objects;

import fr.kizeko.newtonlaws.objects.hitboxes.HitBox;
import processing.core.PVector;

public abstract class GameObject {

    /**
     * Vecteur Position
     */
    protected PVector position;
    /**
     * Vecteur vitesse
     */
    protected PVector velocity;
    /**
     * Vecteur accélération
     */
    protected PVector acceleration;
    /**
     * Longueur
     */
    protected float width;
    /**
     * Hauteur
     */
    protected float height;
    /**
     * HitBox du GameObject
     */
    protected HitBox hitbox;

    /**
     * Constructeur de la classe GameObject
     * @param x         Position(x)
     * @param y         Position(y)
     * @param width     Longueur
     * @param height    Hauteur
     * @param hitbox    HitBox
     */
    protected GameObject(float x, float y, float width, float height, HitBox hitbox) {
        this.position = new PVector(x, y);
        this.velocity = new PVector(0.0f, 0.0f);
        this.acceleration = new PVector(0.0f, 0.0f);
        this.width = width;
        this.height = height;
        this.hitbox = hitbox;
    }

    /**
     * Update le GameObject
     */
    public void update() {
        this.updateSpecs();
        this.draw();
        if (this.hitbox != null) this.hitbox.update(this.position);
    }

    protected void updateSpecs(){}

    /**
     * Affiche sur la fenêtre
     */
    protected abstract void draw();


    public PVector getPosition() {
        return position;
    }

    public PVector getVelocity() {
        return velocity;
    }

    public PVector getAcceleration() {
        return acceleration;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public HitBox getHitbox() {
        return hitbox;
    }

}
