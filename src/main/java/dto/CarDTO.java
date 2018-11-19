/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Car;
import sources.Paths;

/**
 *
 * @author adamlass
 */
public class CarDTO {
    public Long id;

    public String model;
    public String color;
    public String imageURL;
    public String purchaseURL;
    public int seats;
    public double price;

    public String ecoRating;
    public String energyType;
    public String letherType;

    public double engineSize;
    public double weight;
    public double height;
    public double width;
    public double length;
    public double volumen;
    public int rpm;
    public int cylinders;
    public int horsepower;
    public int kmLiter;

    public boolean turbo;
    
    public CarDTO(Car c) {
        this.id = c.getId();
        this.model = c.getModel();
        this.color = c.getColor();
        this.imageURL = Paths.URL_PICS + "/" + c.getImageURL();
        this.purchaseURL = Paths.URI_CARS + "/" + c.getId();
        this.seats = c.getSeats();
        this.price = c.getPrice();
        this.ecoRating = c.getEcoRating();
        this.energyType = c.getEnergyType();
        this.letherType = c.getLetherType();
        this.engineSize = c.getEngineSize();
        this.weight = c.getWeight();
        this.height = c.getHeight();
        this.width = c.getWidth();
        this.length = c.getLength();
        this.volumen = c.getVolumen();
        this.rpm = c.getRpm();
        this.cylinders = c.getCylinders();
        this.horsepower = c.getHorsepower();
        this.kmLiter = c.getKmLiter();
        this.turbo = c.isTurbo();
    }
    
    
}
