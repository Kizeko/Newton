package fr.kizeko.isn.objects.hitboxes;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.GameObject;
import fr.kizeko.isn.utils.Constants;
import fr.kizeko.isn.utils.World;
import processing.core.PVector;

public abstract class Hitbox {

    protected PVector position;
    protected float width;
    protected float height;
    protected float marginLeft;
    protected float marginTop;
    protected boolean displaying;

    public Hitbox(float x, float y, float width, float height, float marginLeft, float marginTop, boolean displaying) {
        this.position = new PVector(x, y);
        this.width = width;
        this.height = height;
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.displaying = displaying;
    }

    public void update(PVector objectPosition) {
        this.updateSpecs(objectPosition);
        this.showHitbox();
    }

    protected void updateSpecs(PVector objectPosition) {
        this.position.x = objectPosition.x + this.marginLeft;
        this.position.y = objectPosition.y + this.marginTop;
    }

    protected abstract void showHitbox();

    public PVector getPosition() {
        return position;
    }

    public void setPosition(PVector position) {
        this.position = position;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isDisplaying() {
        return displaying;
    }

    public void setDisplaying(boolean displaying) {
        this.displaying = displaying;
    }
}
