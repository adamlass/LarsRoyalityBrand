/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author adamlass
 */
public class GenerateCars {

    private static Random rnd = new Random();

    //pair
    private static String[] models = {"Eurasian lynx", "Cougar", "Cheetah", "Ocelot"};
    private static int[] seatSizes = {8, 5, 4, 2};
    public static String[] ecoRatings = {"B", "C", "A", "A+"};
    private static String[] energyTypes = {"Diesel", "Diesel", "Hybrid", "Electric"};
    private static double[] weights = {2303, 2132, 1950, 1500};
    private static double[] heights = {1.7, 1.63, 1.61, 1.46};
    private static double[] widths = {2.1, 2.01, 2, 1.78};
    private static double[] lengths = {7, 6, 5.7, 4.9};

    //pair
    private static String[] colors = {"Black", "White", "Red", "Silver"};
    private static String[] fileNames = {"black.jpg", "white.jpg", "red.png", "silver.png"};

    //pair
    private static String[] letherTypes = {"Premium Full Grain", "Full Grain", "Genuine Leather"};

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < models.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                for (int k = 0; k < letherTypes.length; k++) {
                    String model = models[i];
                    String color = colors[j];
                    String imageURL = fileNames[j];
                    int seats = seatSizes[i];
                    double price = (rnd.nextInt(25) + 5) * 100000;

                    String ecoRating = ecoRatings[i];
                    String energyType = energyTypes[i];
                    String letherType = letherTypes[k];

                    double engineSize = rnd.nextInt(5) + 6.75;
                    double weight = weights[i];
                    double height = heights[i];
                    double width = widths[i];
                    double length = lengths[i];
                    double volumen = (height * width * length) * 0.75;
                    int rpm = rnd.nextInt(340) + 450;
                    int cylinders = rnd.nextInt(4) + 4;
                    int horsepower = rnd.nextInt(330) + 500;
                    int kmLiter = rnd.nextInt(10) + 12;

                    boolean turbo = horsepower > 600;
                    Car newCar = new Car(model, color, imageURL, seats, price, ecoRating, energyType, letherType, engineSize, weight, height, width, length, volumen, rpm, cylinders, horsepower, kmLiter, turbo);
                    cars.add(newCar);
                }
            }
        }
        for (Car car : cars) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(car);
                em.getTransaction().commit();
                
            } finally {
                em.close();
            }
        }
    }
}
