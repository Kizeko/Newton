package fr.kizeko.isn.utils;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.Projectile;
import fr.kizeko.isn.objects.Zone;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

import static fr.kizeko.isn.utils.Constants.START_POSITION_X;
import static fr.kizeko.isn.utils.Constants.START_POSITION_Y;

public class World {

    private static List<Projectile> projectiles;
    private static List<Zone> zones;
    private PImage background;
    private UI ui;

    public World() {
        this.background = Main.getInstance().loadImage("C:/Users/Kizeko/Desktop/ISN/src/fr/kizeko/isn/assets/backgrounds/background.png");
        this.background.resize(Main.getInstance().width, Main.getInstance().height);
        projectiles = new ArrayList<>();
        zones = new ArrayList<>();
        this.ui = new UI(50.0f, getShootAngle());
    }

    public void addProjectile(String id, float x, float y, float v0, float width, float height, float angle) {
        projectiles.add(new Projectile(id, x, y, v0, width, height, angle));
    }

    public void update() {
        this.drawBackground();
        this.updateProjectiles();
        this.updateZones();
        this.ui.update(50.0f, getShootAngle());
    }

    private void updateZones() {
        for (Zone zone : zones) {
            zone.update();
        }
    }

    private void updateProjectiles() {
        for (Projectile projectile : projectiles) {
            projectile.update();
        }
    }

    public static float getShootAngle() {
        if(Main.getInstance().mouseY > Constants.START_POSITION_Y) {
            return 0.0f;
        } else if (Main.getInstance().mouseX < Constants.START_POSITION_X) {
            return -Main.getInstance().PI / 2.0f;
        } else {
            PVector vec1 = new PVector(1.0f, 0.0f);
            PVector vec2 = new PVector(Main.getInstance().mouseX - START_POSITION_X, Main.getInstance().mouseY - START_POSITION_Y);
            return -PVector.angleBetween(vec1, vec2);
        }
    }

    public static void changeVectors(PVector firstVec, PVector clonedVec, float length) {
        if (Main.getInstance().mouseY > Constants.START_POSITION_Y) {
            firstVec.x = 1.0f;
            firstVec.y = 0.0f;
        } else if (Main.getInstance().mouseX < Constants.START_POSITION_X) {
            firstVec.x = 0.0f;
            firstVec.y = -1.0f;
        } else {
            firstVec.x = Main.getInstance().mouseX - Constants.START_POSITION_X;
            firstVec.y = Main.getInstance().mouseY - Constants.START_POSITION_Y;
        }

        clonedVec.x = firstVec.x * (length / firstVec.mag());
        clonedVec.y = firstVec.y * (length / firstVec.mag());
        clonedVec.z = firstVec.z * (length / firstVec.mag());
    }

    private void drawBackground() {
        Main.getInstance().background(this.background);
    }

    public PImage getBackground() {
        return background;
    }

    public static List<Projectile> getProjectiles() {
        return projectiles;
    }

    public static List<Zone> getZones() {
        return zones;
    }
}
