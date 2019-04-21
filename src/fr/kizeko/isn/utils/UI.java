package fr.kizeko.isn.utils;

import fr.kizeko.isn.main.Main;

import static java.lang.Math.*;
import static fr.kizeko.isn.utils.Constants.*;

public class UI {

    private float v0;
    private float angle;
    private final float radius;
    private final int n;
    private final float ellipsesSpacing;

    public UI(float v0, float angle) {
        this.v0 = v0;
        this.angle = angle;
        this.radius = 2.5f;
        this.n = 15;
        this.ellipsesSpacing = 5.0f;
    }

    public void update(float v0, float angle) {
        this.updateSpecs(v0, angle);
        this.drawLauncher();
    }

    private void updateSpecs(float v0, float angle) {
        this.v0 = v0;
        this.angle = angle;
    }

    private void drawLauncher() {
        float x = 0.0f;
        for (int i = 0; i < n; i++) {
            x += this.ellipsesSpacing;
            Main.getInstance().ellipse(x, y(x), radius * 2.0f, radius * 2.0f);
        }
    }

    private float y(float x) {
        return (float) (((g / (2 * pow(v0, 2) * pow(cos(angle), 2))) * pow(x, 2)) + tan(angle) * x);
    }

    public float getV0() {
        return v0;
    }

    public void setV0(float v0) {
        this.v0 = v0;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getRadius() {
        return radius;
    }

    public int getN() {
        return n;
    }

    public float getEllipsesSpacing() {
        return ellipsesSpacing;
    }
}
