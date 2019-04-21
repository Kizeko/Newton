package fr.kizeko.isn.main;

import fr.kizeko.isn.objects.Projectile;
import fr.kizeko.isn.utils.World;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import static fr.kizeko.isn.utils.Constants.START_POSITION_X;
import static fr.kizeko.isn.utils.Constants.START_POSITION_Y;

public class Main extends PApplet {

    private static Main instance;
    private World world;

    public static void main(String[] args) {
        PApplet.main("fr.kizeko.isn.main.Main", args);
    }

    @Override
    public void setup() {
        instance = this;
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
    public void keyTyped(KeyEvent event) {
        System.out.println("ONE : ");
        World.getProjectiles().add(new Projectile("OMEGALUL", 0.0f, 0.0f, 50.0f, 10.0f, 10.0f, World.getShootAngle()));
    }

    public static Main getInstance() {
        return instance;
    }
}
