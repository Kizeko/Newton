package fr.kizeko.isn.utils;

import fr.kizeko.isn.main.Main;
import processing.core.PVector;

import static fr.kizeko.isn.utils.Constants.*;
import static java.lang.Math.*;

public class Functions {

    public static float getShootAngle() {
        if (Main.getInstance().mouseY > Constants.START_POSITION_Y) {
            return 0.0f;
        } else if (Main.getInstance().mouseX < Constants.START_POSITION_X) {
            return -Main.getInstance().PI / 2.0f;
        } else {
            PVector vec1 = new PVector(1.0f, 0.0f);
            PVector vec2 = new PVector(convertXToOrigin(Main.getInstance().mouseX), convertYToOrigin(Main.getInstance().mouseY));
            return -PVector.angleBetween(vec1, vec2);
        }
    }

    public static float y(float x, float v0, float angle) {
        return (float) (((g / (2 * pow(v0, 2) * pow(cos(angle), 2))) * pow(x, 2)) + tan(angle) * x);
    }

    public static float convertXToOrigin(float posX) {
        return posX - START_POSITION_X;
    }

    public static float convertYToOrigin(float posY) {
        return posY - START_POSITION_Y;
    }

}
