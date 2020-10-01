package plane;
/**
 * This class only asks the plane to do sensible things.
 * @author blerner
 *
 */
public class FlightController1 {

    public static void main (String[] args) {
        Plane plane = new Plane();
        plane.closeDoors();
        plane.taxi();
        plane.throttleUp(140);
        plane.takeOff();
        plane.putWheelsUp();
        plane.printStatus();
    }
}
