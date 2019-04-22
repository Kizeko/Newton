package fr.kizeko.isn.tasks;

import static fr.kizeko.isn.main.Main.*;

import static fr.kizeko.isn.utils.Constants.*;
import static fr.kizeko.isn.utils.Functions.*;

import fr.kizeko.isn.objects.Projectile;
import fr.kizeko.isn.utils.World;

import java.util.TimerTask;

public class GameTask extends TimerTask {

    private World world;
    private static int count;

    public GameTask(World world) {
        this.world = world;
        count = 0;
    }

    @Override
    public void run() {
        if (World.getZone() == null) {
            count++;
            this.world.createNewZone(String.valueOf(count), getInstance().random(convertXToOrigin(FLOOR_MIN_POSITION_X),
                    convertXToOrigin(FLOOR_MAX_POSITION_X)), convertYToOrigin(FLOOR_POSITION_Y), getInstance().random(FLOOR_MIN_WIDTH,
                    FLOOR_MAX_WIDTH), getInstance().random(FLOOR_MIN_HEIGHT, FLOOR_MAX_HEIGHT));
        }
    }

    public void changeZone(Projectile projectile) {
        World.getProjectiles().clear();
        World.setZone(null);
    }

    public static int getCount() {
        return count;
    }
}
