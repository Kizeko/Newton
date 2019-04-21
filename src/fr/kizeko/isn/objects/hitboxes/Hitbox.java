package fr.kizeko.isn.objects.hitboxes;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.GameObject;
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

    protected void showHitbox() {
        if (this.displaying) {
            Main.getInstance().fill(0, 255, 0, 50);
            Main.getInstance().rect(this.position.x, this.position.y, this.width, this.height);
            Main.getInstance().fill(255);
        }
    }

    protected int isOutOfScreen() {
        if (this.position.x < this.width / 2.0f) {
            return 0;
        } else if (this.position.x > Main.getInstance().width) {
            return 1;
        } else if (this.position.y < this.height / 2.0f) {
            return 2;
        } else if (this.position.y > Main.getInstance().height) {
            return 3;
        } else {
            return 4;
        }
    }

    protected boolean stopMovementAfterCollidingWithWalls(GameObject gameObject) {
        Integer index = this.isOutOfScreen();
        if (index != 4) {
            if (index == 0) {
                //Touché a gauche --> décale à droite
            } else if (index == 1) {
                //Touché à droite --> décale à gauche
            } else if (index == 2) {
                //Touché en haut --> décale en bas
            } else {
                //Touché en bas --> décale en bas
            }
            return true;
        } else {
            return false;
        }
    }

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
