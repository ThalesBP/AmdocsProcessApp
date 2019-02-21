package Entities;

import Variables.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TerrainTest {

    @org.junit.jupiter.api.Test
    void checkCollision(){
        Terrain terrain = new Terrain(new Vector(5, 5));
        assertEquals(true, terrain.checkCollision(new Vector(-1, -1)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(2, -1)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(-1, 2)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(6, -1)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(-1, 6)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(6, 2)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(2, 6)), "Must detect a collision");
        assertEquals(true, terrain.checkCollision(new Vector(6, 6)), "Must detect a collision");
        assertEquals(false, terrain.checkCollision(new Vector(2, 2)), "Must'nt detect a collision");
    }

}