package com.zarterstein.chaxels.tests;

import com.zarterstein.chaxels.Screen;
import com.zarterstein.chaxels.clrender.Renderer;
import com.zarterstein.testshapes.CloudShape;
import com.zarterstein.testshapes.SunShape;
import com.zarterstein.testshapes.ExplosionShape;

public class ConsoleTest {
    public static void main(String[] args) throws InterruptedException {
        Renderer renderer = new Renderer();
        renderer.createScreen(80, 24);
        Screen screen = renderer.getScreen();
        
        CloudShape cloud = (CloudShape) new CloudShape().shape();
        SunShape sun = (SunShape) new SunShape().shape();
        ExplosionShape explosion = (ExplosionShape) new ExplosionShape().shape();
        
        System.out.println("Starting Console Test...");
        System.out.println("Please note: IntelliJ will not support screen reset, it will scroll the console A LOT.");
        Thread.sleep(1000);
        
        renderer.moveToBeginning();
        
        for (int i = 0; i < 60; i++) {
            screen.getCanvas().reset(80, 24);
            screen.removeAll();
            
            // Draw sun
            screen.add(sun, "sun", 50, 2);
            
            // Draw moving cloud
            screen.add(cloud, "cloud", (i % 80), 5);
            
            // Random explosions
            if (i % 10 < 3) {
                screen.add(explosion, "boom" + i, 10 + (i * 2) % 60, 15);
            }
            
            renderer.tick();
            renderer.printScreen();
            Thread.sleep(100);
        }
        
        System.out.println("Test complete.");
    }
}
