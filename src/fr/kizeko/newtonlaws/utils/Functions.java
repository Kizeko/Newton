package fr.kizeko.newtonlaws.utils;

import fr.kizeko.newtonlaws.main.Main;
import processing.core.PVector;

import static fr.kizeko.newtonlaws.utils.Constants.*;
import static java.lang.Math.*;

public class Functions {

    /**
     * @return L'angle de tir
     */
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

    /**
     * Equation de la trajectoire
     *
     * @param x     Position(x)
     * @param v0    Vitesse initiale
     * @param angle Angle
     * @return Position(y)
     */
    public static float y(float x, float v0, float angle) {
        return (float) (((g / (2 * pow(v0, 2) * pow(cos(angle), 2))) * pow(x, 2)) + tan(angle) * x);
    }

    public static float yMax(float v0, float angle) {
        return (float) ((pow(v0, 2) * pow(sin(angle), 2)) / (2 * g));
    }

    /**
     * @param posX Position(x)
     * @return Position(x) à l'origine
     */
    public static float convertXToOrigin(float posX) {
        return posX - START_POSITION_X;
    }

    /**
     * @param posY Position(Y)
     * @return Position(Y) à l'origine
     */
    public static float convertYToOrigin(float posY) {
        return posY - START_POSITION_Y;
    }

}
