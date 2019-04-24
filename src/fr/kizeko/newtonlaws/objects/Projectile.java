package fr.kizeko.newtonlaws.objects;

import fr.kizeko.newtonlaws.animations.ProjectileAnimation;
import fr.kizeko.newtonlaws.main.Main;
import fr.kizeko.newtonlaws.objects.hitboxes.ProjectileHitBox;
import fr.kizeko.newtonlaws.utils.Functions;

import java.util.ArrayList;
import java.util.List;

import static fr.kizeko.newtonlaws.utils.Constants.*;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.pow;

public class Projectile extends GameObject {

    /**
     * Temps initial
     */
    private final long t0;
    /**
     * Vitesse initiale
     */
    private final float v0;
    /**
     * Angle
     */
    private float angle;
    /**
     * Temps de "vie" de l'objet avec pour origine t0
     */
    private float t;
    /**
     * True si l'objet est en mouvement, False si il ne l'est pas
     */
    private boolean active;
    /**
     * Valeur alpha du projectile
     */
    private float alpha;
    /**
     * Altitude maximum du projectile (yMax)
     */
    private float yMax;
    /**
     * Liste des différents Trail de ce projectile
     */
    private List<Trail> trails;

    /**
     * Constructeur de la classe Projectile
     *
     * @param id    Id
     * @param v0    Vitesse initiale
     * @param angle Angle
     */
    public Projectile(String id, float v0, float angle) {
        super(id, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 10.0f, 10.0f, new ProjectileHitBox(0.0f, 0.0f, 10.0f, 10.0f, false),
                new ProjectileAnimation());
        this.v0 = v0;
        this.t0 = Main.getInstance().millis();
        this.t = 0.0f;
        this.angle = angle;
        this.active = true;
        this.alpha = 255.0f;
        this.yMax = Functions.yMax(v0, angle);
        this.trails = new ArrayList<>();
        this.done = 4;
    }

    @Override
    protected void updateSpecs() {
        //On actualise sa position, vitesse, accélération et ses Trail si le projectile est en mouvement
        if (this.active) {
            t = (Main.getInstance().millis() - t0) / 1000.0f;
            this.acceleration.x = 0.0f;
            this.acceleration.y = g;
            this.velocity.x = (float) (v0 * cos(angle));
            this.velocity.y = (float) (g * t + v0 * sin(angle));
            this.position.x = (float) (v0 * cos(angle) * t);
            this.position.y = (float) (0.5f * g * pow(t, 2) + (v0 * sin(angle)) * t);
            this.addTrails();
            this.updateTrails();
        }

        //Sinon, on supprime ses Trail progressivement
        else if (trails.size() != 0) {
            for (int i = 0; i < 3; i++) {
                if (trails.size() != 0) trails.remove(0);
            }
            this.updateTrails();
        }
    }

    /**
     * Ajoute des Trail de différentes couleurs (5 par 5)
     */
    private void addTrails() {
        int lastDigit = trails.size() % 10;
        if (lastDigit < 5) this.trails.add(new Trail(String.valueOf(trails.size() + 1), position.x, position.y, 55.0f, 66.0f, 250.0f, 255.0f));
        else this.trails.add(new Trail(String.valueOf(trails.size() + 1), position.x, position.y, 235.0f, 47.0f, 6.0f, 255.0f));
    }

    private void updateTrails() {
        for (Trail trail : trails) {
            trail.update();
        }
    }

    /**
     * Change la valeur alpha du projectile et met active sur False
     */
    public void disableProjectile() {
        this.alpha = 60.0f;
        this.active = false;
    }

    public float getAngle() {
        return angle;
    }

    public float getV0() {
        return v0;
    }

    public boolean isActive() {
        return active;
    }

    public float getAlpha() {
        return alpha;
    }

    public long getT0() {
        return t0;
    }

    public float getT() {
        return t;
    }

    public float getYMax() {
        return yMax;
    }

    public List<Trail> getTrails() {
        return trails;
    }
}
