/**
 *
 * @author Samuel Theiss
 *
 * @since Version 1.0
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolarSystem {

    private Sun theSun;
    private List<Planet> planets = new ArrayList<Planet>();


    public SolarSystem() {

    }


    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }

    public void setSun(Sun sun) {
        this.theSun = sun;
    }

    public void showPlanets() {

        System.out.println("Planets:");

        for (int i = 0; i < planets.size(); i++) {

            System.out.println("Name: " + planets.get(i) + "\tMass: " + planets.get(i).getMass() + "\tRadius: " + planets.get(i).getRadius() + "\tDistance: " + planets.get(i).getDistance() + "\tPosition: " + Arrays.toString(planets.get(i).getPosition()) + "\tVelocity: " + Arrays.toString(planets.get(i).getVelocity()) );

        }

    }

    public void movePlanets() {

        double G = 0.1;
        double dt = 0.001;

        for(Planet p : this.planets) {

            double[] newPosition = {(p.getPosition()[0] + dt * p.getVelocity()[0]),  p.getPosition()[1] + dt * p.getVelocity()[1]};
            p.setPosition( newPosition );

            double rx = this.theSun.getPosition()[0] - p.getPosition()[0];
            double ry = this.theSun.getPosition()[1] - p.getPosition()[1];
            double r = Math.sqrt(Math.pow(rx, 2) + Math.pow(ry, 2));

            double accX = G * this.theSun.getMass() * rx / Math.pow(r, 3);
            double accY = G * this.theSun.getMass() * ry / Math.pow(r, 3);

            p.setVelocity(new double[] {p.getVelocity()[0] + dt * accX, p.getVelocity()[1] + dt * accY} );
        }

    }

}
