package fr.kizeko.isn.main;

import fr.kizeko.isn.tasks.GameTask;
import fr.kizeko.isn.utils.World;
import processing.core.PApplet;

import static fr.kizeko.isn.utils.Constants.START_POSITION_X;
import static fr.kizeko.isn.utils.Constants.START_POSITION_Y;
import static fr.kizeko.isn.utils.Functions.getShootAngle;

public class Main extends PApplet {

    private static Main instance;
    private World world;
    private static float v0 = 100.0f;

    public static void main(String[] args) {
        PApplet.main("fr.kizeko.isn.main.Main", args);
    }

    @Override
    public void setup() {
        instance = this;
        this.textSize(15);
        this.world = new World();
    }

    @Override
    public void settings() {
        this.size(1280, 720);
    }

    @Override
    public void draw() {
        translate(START_POSITION_X, START_POSITION_Y);
        this.background(255);
        this.world.update();
        //System.out.println("X : " + mouseX + " Y = " + mouseY);
        /*PVector a2 = new PVector(mouseX - 500, mouseY - 500);
        PVector newPog = PVector.mult(a2, 75.0f / a2.mag());
        translate(500, 500);
        line(0, 0, newPog.x, newPog.y);*/
    }

    @Override
    public void keyPressed() {
        if (keyCode == UP) {
            v0 += 1.0f;
        } else if (keyCode == DOWN) {
            if (v0 > 0.0f) v0 -= 1.0f;
        } else if (keyCode == ENTER) {
            this.world.addProjectile(String.valueOf(GameTask.getCount() - 1), v0, getShootAngle());
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public static float getV0() {
        return v0;
    }
}
