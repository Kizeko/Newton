package fr.kizeko.isn.objects;

import fr.kizeko.isn.animations.ProjectileAnimation;
import fr.kizeko.isn.main.Main;
import fr.kizeko.isn.objects.hitboxes.ProjectileHitbox;

import static fr.kizeko.isn.utils.Constants.*;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.pow;

public class Projectile extends GameObject {

    private final long t0;
    private final float v0;
    private float angle;
    private boolean active;
    private float alpha;

    public Projectile(String id, float v0, float angle) {
        super(id, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 10.0f, 10.0f, new ProjectileHitbox(0.0f, 0.0f, 10.0f, 10.0f, false),
                new ProjectileAnimation());
        this.v0 = v0;
        this.t0 = Main.getInstance().millis();
        this.angle = angle;
        this.active = true;
        this.alpha = 255.0f;
    }

    @Override
    protected void updateSpecs() {
        if (this.active) {
            float t = (Main.getInstance().millis() - t0) / 1000.0f;
            this.acceleration.x = 0.0f;
            this.acceleration.y = g;
            this.velocity.x = (float) (v0 * cos(angle));
            this.velocity.y = (float) (g * t + v0 * sin(angle));
            this.position.x = (float) (v0 * cos(angle) * t);
            this.position.y = (float) (0.5f * g * pow(t, 2) + (v0 * sin(angle)) * t);
        }
    }

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
}
