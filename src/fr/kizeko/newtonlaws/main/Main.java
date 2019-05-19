package fr.kizeko.newtonlaws.main;

import fr.kizeko.newtonlaws.tasks.GameTask;
import fr.kizeko.newtonlaws.utils.World;
import processing.core.PApplet;

import static fr.kizeko.newtonlaws.utils.Constants.START_POSITION_X;
import static fr.kizeko.newtonlaws.utils.Constants.START_POSITION_Y;
import static fr.kizeko.newtonlaws.utils.Functions.getShootAngle;

public class Main extends PApplet {

    /**
     * Instance de cette classe
     */
    private static Main instance;
    /**
     * Où tout est update
     */
    private World world;
    /**
     * Variable qui determine la vitesse initiale et qui peut changer grâce à UP et DOWN.
     */
    private static float v0 = 100.0f;

    public static void main(String[] args) {
        PApplet.main("fr.kizeko.newtonlaws.main.Main", args);
    }

    @Override
    public void setup() {
        instance = this;
        //Taille de la police à 15
        this.textSize(15);
        //Nouvelle instance de world
        this.world = new World();
    }

    @Override
    public void settings() {
        //Taille de la fenêtre 1280x720
        this.size(1280, 720);
    }

    /**
     * Appellé à chaque image, est destiné à "dessiner" tout ce qui doit être dessiné
     */
    @Override
    public void draw() {
        //Change l'origine du monde aux coordonées START_POSITION_X, START_POSITION_Y (L'axe des ordonées est ascendant et l'axe des abscisses vers la droite)
        translate(START_POSITION_X, START_POSITION_Y);
        //Clear la fenêtre avec un fond blanc
        this.background(255);
        //Update le monde
        this.world.update();
    }

    /**
     * Appellé dés qu'une touche est préssée
     */
    @Override
    public void keyPressed() {
        if (keyCode == UP) {
            //Augmentation de la vitesse initiale
            v0 += 1.0f;
        } else if (keyCode == DOWN) {
            //Abaissement de la vitesse initiale
            if (v0 > 0.0f) v0 -= 1.0f;
        } else if (keyCode == ENTER) {
            //Un nouveau projectile est ajouté
            this.world.addProjectile(v0, getShootAngle());
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public static float getV0() {
        return v0;
    }
}
