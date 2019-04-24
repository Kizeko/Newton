package fr.kizeko.newtonlaws.animations;

import fr.kizeko.newtonlaws.objects.GameObject;

public abstract class Animation {

    /**
     * Temps entre chaque animation (secondes)
     */
    protected float timeChange;

    /**
     * Constructeur de la classe Animation
     * @param timeChange Temps entre chaque animation (secondes)
     */
    public Animation(float timeChange) {
        this.timeChange = timeChange;
    }

    /**
     * Affiche les animations
     * @param gameObject GameObject
     */
    public abstract void process(GameObject gameObject);

    public float getTimeChange() {
        return timeChange;
    }
}
