package fr.kizeko.isn.utils;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.tasks.GameTask;

import static fr.kizeko.isn.utils.Functions.*;

public class UI {

    private float v0;
    private float angle;
    private final float radius;
    private final int n;
    private final float ellipsesSpacing;
    private float travelTimeOfLastBall;
    private float distanceOfLastBall;

    public UI() {
        this.v0 = Main.getV0();
        this.angle = getShootAngle();
        this.radius = 2.5f;
        this.n = 15;
        this.ellipsesSpacing = 5.0f;
        this.travelTimeOfLastBall = 0.0f;
        this.distanceOfLastBall = 0.0f;
    }

    public void update() {
        this.updateSpecs();
        this.drawLauncher();
        this.drawText();
        this.drawGraduation();
    }

    private void updateSpecs() {
        this.v0 = Main.getV0();
        this.angle = getShootAngle();
    }

    private void drawText() {
        String timeText = "Time : " + Math.round(Main.getInstance().millis() / 1000.0f) + " s";
        String zoneText = "Zone touched : " + (GameTask.getCount() - 1);
        String vText = "V0 : " + this.v0 + " m/s";
        String angleText = "Angle : " + -Math.round(Math.toDegrees(getShootAngle())) + "°";
        String distanceText = "Distance : " + this.distanceOfLastBall + " m";
        String timeBallText = "Time traveled : " + this.travelTimeOfLastBall + " s";

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
    }

    private void drawLauncher() {
        float x = 0.0f;
        for (int i = 0; i < n; i++) {
            x += this.ellipsesSpacing;
            Main.getInstance().ellipse(x, y(x, v0, angle), radius * 2.0f, radius * 2.0f);
        }
    }

    private void drawGraduation() {
        for (int i = 0; i < (Main.getInstance().width - Constants.START_POSITION_X) / 10.0f; i++) {
            if (i * 10.0f % 100.0f == 0.0f) {

                Main.getInstance().line(i * 10.0f, convertYToOrigin(Constants.FLOOR_POSITION_Y + 60.0f), i * 10.0f,
                        convertYToOrigin(Constants.FLOOR_POSITION_Y + 40.0f));

                if (i != 0)
                    Main.getInstance().text(Math.round(i * 10.0f), i * 10.0f - 14.0f, convertYToOrigin(Constants.FLOOR_POSITION_Y + 80.0f));
            } else {

                Main.getInstance().line(i * 10.0f, convertYToOrigin(Constants.FLOOR_POSITION_Y + 60.0f), i * 10.0f,
                        convertYToOrigin(Constants.FLOOR_POSITION_Y + 50.0f));
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

    public float getTravelTimeOfLastBall() {
        return travelTimeOfLastBall;
    }

    public void setTravelTimeOfLastBall(float travelTimeOfLastBall) {
        this.travelTimeOfLastBall = travelTimeOfLastBall;
    }

    public float getDistanceOfLastBall() {
        return distanceOfLastBall;
    }

    public void setDistanceOfLastBall(float distanceOfLastBall) {
        this.distanceOfLastBall = distanceOfLastBall;
    }
}
