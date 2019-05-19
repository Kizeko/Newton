package fr.kizeko.newtonlaws.objects.hitboxes;

import processing.core.PVector;

public abstract class HitBox {

    /**
     * Vecteur position
     */
    protected PVector position;
    /**
     * Longueur
     */
    protected float width;
    /**
     * Hauteur
     */
    protected float height;
    /**
     * True si la HitBox est affichée
     */
    protected boolean displaying;

    /**
     * Constructeur de la classe HitBox
     *
     * @param x          Position(x)
     * @param y          Position(y)
     * @param width      Longueur
     * @param height     Hauteur
     * @param displaying True si la HitBox est affichée
     */
    public HitBox(float x, float y, float width, float height, boolean displaying) {
        this.position = new PVector(x, y);
        this.width = width;
        this.height = height;
        this.displaying = displaying;
    }

    /**
     * Update les positions de la HitBox
     *
     * @param objectPosition Position du GameObject
     */
    public void update(PVector objectPosition) {
        this.updateSpecs(objectPosition);
        if (this.displaying) this.showHitBox();
    }

    protected void updateSpecs(PVector objectPosition) {
        this.position.x = objectPosition.x;
        this.position.y = objectPosition.y;
    }

    protected abstract void showHitBox();

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
