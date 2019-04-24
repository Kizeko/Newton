package fr.kizeko.newtonlaws.utils;

import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.Projectile;
import fr.kizeko.newtonlaws.objects.Zone;
import fr.kizeko.newtonlaws.objects.hitboxes.ProjectileHitBox;
import fr.kizeko.newtonlaws.tasks.GameTask;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class World {

    /**
     * Liste qui contient tous les projectiles affichés
     */
    private static List<Projectile> projectiles;
    /**
     * Zone actuellement affichée
     */
    private static Zone zone;
    /**
     * Image de fond
     */
    private PImage background;
    /**
     * Tache qui sera répétée toutes les secondes qui update certaines données
     */
    private GameTask gameTask;
    /**
     * ATH du jeu
     */
    private UI ui;

    /**
     * Constructeur de la classe World
     */
    public World() {
        this.background = Main.getInstance().loadImage("C:/Users/Kizeko/Desktop/ISN/src/fr/kizeko/newtonlaws/assets/backgrounds/background.png");
        this.background.resize(Main.getInstance().width, Main.getInstance().height);
        projectiles = new ArrayList<>();
        this.ui = new UI();
        this.gameTask = new GameTask(this);
        Timer timer = new Timer();
        timer.schedule(gameTask, 0, 1000);
    }

    /**
     * @param id Id
     * @param v0 Vitesse initiale
     * @param angle Angle
     */
    public void addProjectile(String id, float v0, float angle) {
        projectiles.add(new Projectile(id, v0, angle));
    }

    /**
     * @param id Id
     * @param x Position(x)
     * @param y Position(y)
     * @param width Longueur
     * @param height Hauteur
     */
    public void instantiateNewZone(String id, float x, float y, float width, float height) {
        zone = new Zone(id, x, y, width, height);
    }

    /**
     * Update tout dans le monde
     */
    public void update() {
        this.drawBackground();
        this.updateZone();
        this.updateProjectiles();
        this.checkCollision();
        this.ui.update();
    }

    /**
     * Vérifie si les projectiles ont touchés la zone ou le sol
     */
    private void checkCollision() {
        for (int i = 0; i < projectiles.size(); i++) {
            //On vérifie si le projectile est encore en mouvement
            if (projectiles.get(i).isActive()) {
                //La méthode #hasCollided renvoie 0 si un projectile a touché la zone, 1 si le projectile a touché le sol, 2 si aucun contact
                int result = ((ProjectileHitBox) projectiles.get(i).getHitbox()).hasCollided(zone);
                if (result != 2) {
                    //Si cela a touché le sol ou la zone, on desactive le projectile et on update certaines données
                    projectiles.get(i).disableProjectile();
                    this.ui.setTravelTimeOfLastBall(projectiles.get(i).getT());
                    this.ui.setDistanceOfLastBall(projectiles.get(i).getPosition().x);
                    if (result == 0) {
                        //Le projectile a touché la zone, on génère une nouvelle zone
                        this.gameTask.changeZone();
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

    public static List<Projectile> getProjectiles() {
        return projectiles;
    }

    public static Zone getZone() {
        return zone;
    }

    public static void setZone(Zone zone) {
        World.zone = zone;
    }
}
