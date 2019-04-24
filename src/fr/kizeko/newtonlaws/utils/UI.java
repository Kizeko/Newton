package fr.kizeko.newtonlaws.utils;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.tasks.GameTask;

import java.text.DecimalFormat;

import static fr.kizeko.newtonlaws.utils.Functions.*;

public class UI {

    /**
     * Vitesse initiale
     */
    private float v0;
    /**
     * Angle
     */
    private float angle;
    /**
     * Rayon des cercles du lanceur
     */
    private final float radius;
    /**
     * Nombres de cercles du lanceur
     */
    private final int n;
    /**
     * Le nombre de pixels qui séparent les cercles (abscisses)
     */
    private final float ellipsesSpacing;
    /**
     * La durée de vol du projectile
     */
    private float travelTimeOfLastProjectile;
    /**
     * La distance que le dernier projectile a parcouru
     */
    private float distanceOfLastProjectile;
    /**
     * Angle du dernier projectile
     */
    private float angleOfLastProjectile;
    /**
     * y Max du dernier projectile
     */
    private float yMaxOfLastProjectile;

    /**
     * Constructeur de la classe UI
     */
    public UI() {
        this.v0 = Main.getV0();
        this.angle = getShootAngle();
        this.radius = 2.5f;
        this.n = 15;
        this.ellipsesSpacing = 5.0f;
        this.travelTimeOfLastProjectile = 0.0f;
        this.distanceOfLastProjectile = 0.0f;
        this.angleOfLastProjectile = 0.0f;
        this.yMaxOfLastProjectile = 0.0f;
    }

    /**
     * Update tout ce que la classe UI gère
     */
    public void update() {
        this.updateSpecs();
        this.drawAxes();
        this.drawLauncher();
        this.drawText();
    }

    private void updateSpecs() {
        this.v0 = Main.getV0();
        this.angle = getShootAngle();
    }

    /**
     * Affiche les différentes informations
     */
    private void drawText() {
        DecimalFormat format = new DecimalFormat("#.##");

        String timeText = "Time : " + Math.round(Main.getInstance().millis() / 1000.0f) + " s";
        String zoneText = "Zone touched : " + (GameTask.getCount() - 1);
        String vText = "V0 : " + this.v0 + " m/s";
        String angleText = "Angle : " + format.format(-Math.toDegrees(getShootAngle())) + "°";
        String distanceText = "Distance : " + format.format(this.distanceOfLastProjectile) + " m";
        String timeBallText = "Time traveled : " + format.format(this.travelTimeOfLastProjectile) + " s";
        String lastAngleText = "Angle : " + format.format(-Math.toDegrees(this.angleOfLastProjectile)) + "°";
        String yMaxText = "yMax : " + format.format(this.yMaxOfLastProjectile) + " m";

        Main.getInstance().text(timeText, convertXToOrigin(Main.getInstance().width / 2.0f - Main.getInstance().textWidth(timeText) / 2.0f),
                convertYToOrigin(25.0f));

        Main.getInstance().text(zoneText, convertXToOrigin(Main.getInstance().width / 2.0f - Main.getInstance().textWidth(zoneText) / 2.0f),
                convertYToOrigin(55.0f));

        Main.getInstance().text(vText, convertXToOrigin(Main.getInstance().width - 10.0f - Main.getInstance().textWidth(vText)), convertYToOrigin(25.0f));

        Main.getInstance().text(angleText, convertXToOrigin(Main.getInstance().width - 10.0f - Main.getInstance().textWidth(angleText)),
                convertYToOrigin(55.0f));

        Main.getInstance().text(distanceText, convertXToOrigin(Main.getInstance().width / 2.0f - Main.getInstance().textWidth(distanceText) / 2.0f),
                convertYToOrigin(640.0f));

        Main.getInstance().text(timeBallText, convertXToOrigin(Main.getInstance().width / 2.0f - Main.getInstance().textWidth(timeBallText) / 2.0f),
                convertYToOrigin(660.0f));

        Main.getInstance().text(lastAngleText, convertXToOrigin(Main.getInstance().width / 2.0f - Main.getInstance().textWidth(lastAngleText) / 2.0f),
                convertYToOrigin(680.0f));

        Main.getInstance().text(yMaxText, convertXToOrigin(Main.getInstance().width / 2.0f - Main.getInstance().textWidth(yMaxText) / 2.0f),
                convertYToOrigin(700.0f));
    }

    /**
     * Affiche le lanceur
     */
    private void drawLauncher() {
        float x = 0.0f;
        for (int i = 0; i < n; i++) {
            x += this.ellipsesSpacing;
            Main.getInstance().ellipse(x, y(x, v0, angle), radius * 2.0f, radius * 2.0f);
        }
    }

    /**
     * Affiche les axes
     */
    private void drawAxes() {
        for (int i = 0; i < (Main.getInstance().width - Constants.START_POSITION_X) / 10.0f; i++) {
            if (i * 10.0f % 100.0f == 0.0f) {

                Main.getInstance().line(i * 10.0f, convertYToOrigin(Constants.START_POSITION_Y + 60.0f), i * 10.0f,
                        convertYToOrigin(Constants.START_POSITION_Y + 40.0f));

                if (i != 0)
                    Main.getInstance().text(Math.round(i * 10.0f), i * 10.0f - 14.0f, convertYToOrigin(Constants.START_POSITION_Y + 80.0f));
            } else {

                Main.getInstance().line(i * 10.0f, convertYToOrigin(Constants.START_POSITION_Y + 60.0f), i * 10.0f,
                        convertYToOrigin(Constants.START_POSITION_Y + 50.0f));
            }
        }

        for (int i = 0; i < (Main.getInstance().height + Constants.START_POSITION_Y) / 10.0f; i++) {
            if (i * 10.0f % 100.0f == 0.0f) {

                Main.getInstance().line(convertXToOrigin(0.0f), -i * 10.0f, convertXToOrigin(20.0f), -i * 10.0f);

                if (i != 0) Main.getInstance().text(Math.round(i * 10.0f), convertXToOrigin(25.0f), -i * 10.0f + 4.0f);
            } else {

                Main.getInstance().line(convertXToOrigin(0.0f), -i * 10.0f, convertXToOrigin(10.0f), -i * 10.0f);
            }
        }
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

    public float getTravelTimeOfLastProjectile() {
        return travelTimeOfLastProjectile;
    }

    public float getDistanceOfLastProjectile() {
        return distanceOfLastProjectile;
    }

    public void setAngleOfLastProjectile(float angleOfLastProjectile) {
        this.angleOfLastProjectile = angleOfLastProjectile;
    }

    public void setDistanceOfLastProjectile(float distanceOfLastProjectile) {
        this.distanceOfLastProjectile = distanceOfLastProjectile;
    }

    public void setTravelTimeOfLastProjectile(float travelTimeOfLastProjectile) {
        this.travelTimeOfLastProjectile = travelTimeOfLastProjectile;
    }

    public void setyMaxOfLastProjectile(float yMaxOfLastProjectile) {
        this.yMaxOfLastProjectile = yMaxOfLastProjectile;
    }
}
