package plane;
/**
 * This class asks the plane to do some unreasonable things.
 * @author blerner
 *
 */
public class FlightController2 {

    public static void main (String[] args) {
        Plane plane = new Plane();
        plane.closeDoors();
        plane.taxi();
        plane.putWheelsUp();
        plane.land();
        plane.openDoors();
        plane.printStatus();
    }
}
