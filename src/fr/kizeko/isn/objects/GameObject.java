package fr.kizeko.isn.objects;

import fr.kizeko.isn.animations.Animation;
import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.hitboxes.Hitbox;
import processing.core.PVector;

public abstract class GameObject {

    protected String id;
    protected PVector position;
    protected PVector velocity;
    protected PVector acceleration;
    protected float width;
    protected float height;
    protected Hitbox hitbox;
    protected Animation animation;

    protected GameObject(String id, float x, float y, float vx, float vy, float ax, float ay, float width, float height, Hitbox hitbox, Animation animation) {
        this.id = id;
        this.position = new PVector(x, y);
        this.velocity = new PVector(vx, vy);
        this.acceleration = new PVector(ax, ay);
        this.width = width;
        this.height = height;
        this.hitbox = hitbox;
        this.animation = animation;
    }

    public void update() {
        this.updateSpecs();
        this.draw();
    }

    protected abstract void updateSpecs();

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

    public Hitbox getHitbox() {
        return hitbox;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setId(String id) {
        this.id = id;
    }
}
