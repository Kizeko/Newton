package fr.kizeko.newtonlaws.objects;

import fr.kizeko.newtonlaws.animations.Animation;
import fr.kizeko.newtonlaws.objects.hitboxes.HitBox;
import processing.core.PVector;

public abstract class GameObject {

    /**
     * Id
     */
    protected String id;
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
     * Animation du GameObject
     */
    protected Animation animation;

    /**
     * Constructeur de la classe GameObject
     * @param id Id
     * @param x Position(x)
     * @param y Position(y)
     * @param vx Vitesse(x)
     * @param vy Vitesse(y)
     * @param ax Accélération(x)
     * @param ay Accélération(y)
     * @param width Longueur
     * @param height Hauteur
     * @param hitbox HitBox
     * @param animation Animation
     */
    protected GameObject(String id, float x, float y, float vx, float vy, float ax, float ay, float width, float height, HitBox hitbox,
                         Animation animation) {
        this.id = id;
        this.position = new PVector(x, y);
        this.velocity = new PVector(vx, vy);
        this.acceleration = new PVector(ax, ay);
        this.width = width;
        this.height = height;
        this.hitbox = hitbox;
        this.animation = animation;
    }

    /**
     * Update le GameObject
     */
    public void update() {
        this.updateSpecs();
        this.draw();
        if (this.hitbox != null) this.hitbox.update(this.position);
    }

    protected abstract void updateSpecs();

    /**
     * Affiche sur la fenêtre
     */
    protected void draw() {
        this.animation.process(this);
    }

    public String getId() {
        return id;
    }

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

    public Animation getAnimation() {
        return animation;
    }

    public void setId(String id) {
        this.id = id;
    }
}
