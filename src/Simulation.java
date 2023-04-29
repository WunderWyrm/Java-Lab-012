import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Samuel Theiss
 *
 * @since Version 1.0
 *
 */

import java.util.List;
import java.util.Scanner;

public class Simulation {

    static Scanner sc = new Scanner(System.in);
    static List<SolarSystem> solarSystems = new ArrayList<SolarSystem>();


    public static void createSolarSystem() {
        solarSystems.add( new SolarSystem() );
    }

    public static void createSun() {

        System.out.print("\nWhat is new Sun's name? ");
        String name = sc.nextLine();

        System.out.print("\nWhat is new Sun's mass? ");
        double mass = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Sun's x position? ");
        double xPos = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Sun's y position? ");
        double yPos = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nAssign Sun to which Solar System? (index) ");
        int solarSystem = sc.nextInt();
        sc.nextLine();


        solarSystems.get(solarSystem).setSun( new Sun(name, mass, new double[] {xPos, yPos}) );

    }

    public static void createPlanet() {

        System.out.print("\nWhat is new Planet's name? ");
        String name = sc.nextLine();

        System.out.print("\nWhat is new Planet's mass? ");
        double mass = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Planet's radius? ");
        double radius = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Planet's distance? ");
        double distance = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Planet's x position? ");
        double xPos = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Planet's y position? ");
        double yPos = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Sun's x velocity? ");
        double xVel = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nWhat is new Sun's y velocity? ");
        double yVel = sc.nextDouble();
        sc.nextLine();

        System.out.print("\nAssign Planet to which Solar System? (index) ");
        int solarSystem = sc.nextInt();
        sc.nextLine();


        solarSystems.get(solarSystem).addPlanet( new Planet(name, mass, radius, distance, new double[] {xPos, yPos}, new double[] {xVel, yVel}) );

    }

    public static void showPlanets() {

        for (int i = 0; i < solarSystems.size(); i++) {

            System.out.println("\nSolar System " + i + ":");
            solarSystems.get(i).showPlanets();
            System.out.println();

        }


    }

    public static void passTime() {

        System.out.print("\nHow many seconds do you want to pass? ");
        int seconds = sc.nextInt();
        sc.nextLine();

        for (int j = 1; j <= seconds; j++) {

            for (int i = 0; i < solarSystems.size(); i++) {

                solarSystems.get(i).movePlanets();

            }

        }

        System.out.println("\nPassed " + seconds + " seconds.");

    }

    public static void addSol() {

        solarSystems.add( new SolarSystem() );

        solarSystems.get(solarSystems.size() - 1).setSun( new Sun("Sun", 1.989 * Math.pow(10.0, 30.0), new double[] {0.0, 0.0} ));

        solarSystems.get(solarSystems.size() - 1).addPlanet( new Planet( "Mercury", 0.33 * Math.pow(10.0, 24.0), 2439.5, 57.9 * Math.pow(10.0, 6.0), new double[] {57.9 * Math.pow(10.0, 6.0), 0}, new double[] {0.0, 47.4} ));
        solarSystems.get(solarSystems.size() - 1).addPlanet( new Planet( "Venus", 4.867 * Math.pow(10.0, 24.0), 6052.0, 108.2 * Math.pow(10.0, 6.0), new double[] {108.2 * Math.pow(10.0, 6.0), 0}, new double[] {0.0, 35.0} ));
        solarSystems.get(solarSystems.size() - 1).addPlanet( new Planet( "Earth", 5.97 * Math.pow(10.0, 24.0), 6378.0, 149.6 * Math.pow(10.0, 6.0), new double[] {149.6 * Math.pow(10.0, 6.0), 0}, new double[] {0.0, 29.8} ));
        solarSystems.get(solarSystems.size() - 1).addPlanet( new Planet( "Mars", 0.642 * Math.pow(10.0, 24.0), 3396.0, 228.0 * Math.pow(10.0, 6.0), new double[] {228.0 * Math.pow(10.0, 6.0), 0}, new double[] {0.0, 24.1} ));

        System.out.println("\nSol solar system added.");

    }

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.print("\nWhat would you like to do?\n1) Create new Solar System\n2) Create new Sun\n3) Create new Planet\n4) Show Planets in Solar System\n5) Pass time\n6) Add Solar System \"Sol\"\n7) Quit\n\n(1-7) ");
            String input = sc.nextLine().toLowerCase();

            switch (input) {

                case "1" -> createSolarSystem();

                case "2" -> createSun();

                case "3" -> createPlanet();

                case "4" -> showPlanets();

                case "5" -> passTime();

                case "6" -> addSol();

                case "7" -> {
                    System.out.println("\nEnding Simulation.");
                    running = false;
                }

                default -> {
                    System.out.println("\nPlease enter a number corresponding to a listed action. Press Enter");
                    sc.nextLine();
                }

            }

        }






    }

}
