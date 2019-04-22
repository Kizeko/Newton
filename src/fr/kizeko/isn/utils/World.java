package fr.kizeko.isn.utils;

import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.Projectile;
import fr.kizeko.isn.objects.Zone;
import fr.kizeko.isn.objects.hitboxes.ProjectileHitbox;
import fr.kizeko.isn.tasks.GameTask;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static fr.kizeko.isn.utils.Functions.*;

public class World {

    private static List<Projectile> projectiles;
    private static Zone zone;
    private PImage background;
    private GameTask gameTask;
    private UI ui;

    public World() {
        this.background = Main.getInstance().loadImage("C:/Users/Kizeko/Desktop/ISN/src/fr/kizeko/isn/assets/backgrounds/background.png");
        this.background.resize(Main.getInstance().width, Main.getInstance().height);
        projectiles = new ArrayList<>();
        this.ui = new UI();
        this.gameTask = new GameTask(this);
        Timer timer = new Timer();
        timer.schedule(gameTask, 0, 1000);
    }

    public void addProjectile(String id, float v0, float angle) {
        projectiles.add(new Projectile(id, v0, angle));
    }

    public void createNewZone(String id, float x, float y, float width, float height) {
        zone = new Zone(id, x, y, width, height);
    }

    public void update() {
        this.drawBackground();
        this.updateZone();
        this.updateProjectiles();
        this.checkCollision();
        this.ui.update();
    }

    private void checkCollision() {
        for (int i = 0; i < projectiles.size(); i++) {
            if (projectiles.get(i).isActive()) {
                int result = ((ProjectileHitbox) projectiles.get(i).getHitbox()).hasCollided(zone);
                if (result != 2) {
                    projectiles.get(i).disableProjectile();
                    this.ui.setTravelTimeOfLastBall(projectiles.get(i).getT());
                    this.ui.setDistanceOfLastBall(projectiles.get(i).getPosition().x);
                    if (result == 0) {
                        this.gameTask.changeZone(projectiles.get(i));
                    }
                }
            }
        }
    }

    private void updateZone() {
        if (zone != null) {
            zone.update();
        }
    }

    private void updateProjectiles() {
        for (Projectile projectile : projectiles) {
            projectile.update();
        }
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

    public static Zone getZone() {
        return zone;
    }

    public static void setZone(Zone zone) {
        World.zone = zone;
    }

    public UI getUi() {
        return ui;
    }
}
