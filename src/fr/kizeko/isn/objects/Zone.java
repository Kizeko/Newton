package fr.kizeko.isn.objects;

import fr.kizeko.isn.animations.ZoneAnimation;
import fr.kizeko.isn.objects.hitboxes.ZoneHitbox;

public class Zone extends GameObject {

    public Zone(String id, float x, float y, float width, float height) {
        super(id, x, y, 0.0f, 0.0f, 0.0f, 0.0f, width, height, new ZoneHitbox(x, y, width, height, true), new ZoneAnimation());
    }

    @Override
    protected void updateSpecs() {
    }

}
