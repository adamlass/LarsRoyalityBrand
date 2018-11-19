/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dto.CarDTO;
import entity.Car;
import facade.Facade;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.GenerateCars;

/**
 * REST Web Service
 *
 * @author adamlass
 */
@Path("cars")
public class Cars {

    @Context
    private UriInfo context;
    private Gson gson;
    private Facade f;

    public Cars() {
        this.f = new Facade(Persistence.createEntityManagerFactory("pu"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(
            @QueryParam("energy_types") String energyTypes,
            @QueryParam("min_eco_rating") String minEcoRating,
            @QueryParam("min_km_liter") int minKmLiter,
            @QueryParam("max_size") int maxSeats,
            @QueryParam("min_size") int minSeats,
            @QueryParam("max_price") double maxPrice,
            @QueryParam("min_price") double minPrice,
            @QueryParam("colors") String colors
    ) {
        String[] energyTypeList = null;
        if(energyTypes != null){
            energyTypeList = energyTypes.split(",");
        }
        
        String[] ecoRatingList = null;
        if(minEcoRating != null){
            String[] ecoRatings = GenerateCars.ecoRatings;
            for (int i = 0; i < ecoRatings.length; i++) {
                String curr = ecoRatings[i];
                if(curr.equals(minEcoRating)){
                   ecoRatingList = Arrays.copyOfRange(ecoRatings, i,ecoRatings.length);
                           break;
                }
            }
            
        }
        
        String[] colorList = null;
        if(colors != null){
            colorList = colors.split(",");
        }
        List<CarDTO> cars = f.search(energyTypeList, ecoRatingList, minKmLiter, maxSeats, minSeats, maxPrice, minPrice, colorList);
        return Response
                .ok()
                .entity(cars)
                .build();
    }

}
