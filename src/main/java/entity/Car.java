/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author adamlass
 */
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String color;
    private String imageURL;
    private int seats;
    private double price;

    private String ecoRating;
    private String energyType;
    private String letherType;

    private double engineSize;
    private double weight;
    private double height;
    private double width;
    private double length;
    private double volumen;
    private int rpm;
    private int cylinders;
    private int horsepower;
    private int kmLiter;

    private boolean turbo;

    public Car() {
    }

    public Car(String model, String color, String imageURL, int seats, double price, String ecoRating, String energyType, String letherType, double engineSize, double weight, double height, double width, double length, double volumen, int rpm, int cylinders, int horsepower, int kmLiter, boolean turbo) {
        this.model = model;
        this.color = color;
        this.imageURL = imageURL;
        this.seats = seats;
        this.price = price;
        this.ecoRating = ecoRating;
        this.energyType = energyType;
        this.letherType = letherType;
        this.engineSize = engineSize;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.volumen = volumen;
        this.rpm = rpm;
        this.cylinders = cylinders;
        this.horsepower = horsepower;
        this.kmLiter = kmLiter;
        this.turbo = turbo;
    }

    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getSeats() {
        return seats;
    }

    public double getPrice() {
        return price;
    }

    public String getEcoRating() {
        return ecoRating;
    }

    public String getEnergyType() {
        return energyType;
    }

    public String getLetherType() {
        return letherType;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getVolumen() {
        return volumen;
    }

    public int getRpm() {
        return rpm;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getKmLiter() {
        return kmLiter;
    }

    public boolean isTurbo() {
        return turbo;
    }

}
