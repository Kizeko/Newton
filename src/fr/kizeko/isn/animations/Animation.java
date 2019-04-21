package fr.kizeko.isn.animations;

import fr.kizeko.isn.objects.GameObject;

public abstract class Animation {

    protected float timeChange;

    public Animation(float timeChange) {
        this.timeChange = timeChange;
    }

    public abstract void process(GameObject gameObject);

    public float getTimeChange() {
        return timeChange;
    }
}
