/**
 *
 * @author Samuel Theiss
 *
 * @since Version 1.0
 *
 */

public class Sun {

    private String name;
    private double radius;
    private double mass;
    private double temp;
    private double[] position;


    public Sun(String name, double mass, double[] position) {

        this.name = name;
        this.mass = mass;
        this.position = position;

        //I only realized you wanted these two variables after I'd nearly finished with everything else, do you mind if I don't change the constructor parameters so I don't have to add a bunch of scanner statements in Simulation.addSun()?
        this.radius = 695700.0;
        this.temp = 10000.0;

    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public String toString() {
        return this.name;
    }

}
