package Variables;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @org.junit.jupiter.api.Test
    void getRightRotation() {
        assertEquals(Compass.S, Compass.E.getRightRotation(),"Right must rotate from E to S");
        assertEquals(Compass.W, Compass.S.getRightRotation(),"Right must rotate from S to W");
        assertEquals(Compass.N, Compass.W.getRightRotation(),"Right must rotate from W to N");
        assertEquals(Compass.E, Compass.N.getRightRotation(),"Right must rotate from N to E");
    }

    @org.junit.jupiter.api.Test
    void getLeftRotation() {
        assertEquals(Compass.S, Compass.W.getLeftRotation(),"Left must rotate from W to S");
        assertEquals(Compass.E, Compass.S.getLeftRotation(),"Left must rotate from S to E");
        assertEquals(Compass.N, Compass.E.getLeftRotation(),"Left must rotate from E to N");
        assertEquals(Compass.W, Compass.N.getLeftRotation(),"Left must rotate from N to W");
    }
}