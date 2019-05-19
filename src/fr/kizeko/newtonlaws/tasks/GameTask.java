package fr.kizeko.newtonlaws.tasks;

import static fr.kizeko.newtonlaws.main.Main.*;

import static fr.kizeko.newtonlaws.utils.Constants.*;
import static fr.kizeko.newtonlaws.utils.Functions.*;

import fr.kizeko.newtonlaws.utils.World;

import java.util.TimerTask;

public class GameTask extends TimerTask {

    private World world;
    /**
     * Nombre de zones touchées
     */
    private static int count;


    public GameTask(World world) {
        this.world = world;
        count = 0;
    }

    /**
     * Sera executé toutes les secondes
     */
    @Override
    public void run() {
        //Si la zone est nulle --> (qu'il n'y en a pas), on en ajoute une
        if (World.getZone() == null) {
            count++;
            this.world.instantiateNewZone(getInstance().random(convertXToOrigin(FLOOR_MIN_POSITION_X), convertXToOrigin(FLOOR_MAX_POSITION_X))
                    , convertYToOrigin(START_POSITION_Y), getInstance().random(ZONE_MIN_WIDTH, ZONE_MAX_WIDTH),
                    getInstance().random(ZONE_MIN_HEIGHT, ZONE_MAX_HEIGHT));
        }
    }

    /**
     * On détruit les projectiles et la zone
     */
    public void changeZone() {
        World.getProjectiles().clear();
        World.setZone(null);
    }

    public static int getCount() {
        return count;
    }
}
