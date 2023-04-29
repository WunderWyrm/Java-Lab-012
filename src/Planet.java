/**
 *
 * @author Samuel Theiss
 *
 * @since Version 1.0
 *
 */

public class Planet {

    private String name;
    private double mass;
    private double radius;
    private double distance;
    private double[] position;
    private double[] velocity;


    public Planet(String name, double mass, double radius, double distance, double[] position, double[] velocity) {

        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.distance = distance;
        this.position = position;
        this.velocity = velocity;

    }

    public void move(double x, double y) {

        this.position[1] += x;
        this.position[2] += y;

    }

    public void move(double[] coords) {

        for (int i = 0; i < coords.length; i++) {
            this.position[i] += coords[i];
        }

    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public String toString() {
        return this.name;
    }


    public double getMass() {
        return mass;
    }

    public double getDistance() {
        return distance;
    }

    public double getRadius() {
        return radius;
    }
}
