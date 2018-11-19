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
            @QueryParam("energy_type") String energyType,
            @QueryParam("min_eco_rating") String minEcoRating,
            @QueryParam("min_km_liter") int minKmLiter,
            @QueryParam("max_size") int maxSize,
            @QueryParam("min_size") int minSize,
            @QueryParam("max_price") double maxPrice,
            @QueryParam("min_price") double minPrice,
            @QueryParam("colors") String colors
    ) {
        List<CarDTO> cars = f.search(energyType, minEcoRating, minKmLiter, maxSize, minSize, maxPrice, minPrice, colors);
        return Response
                .ok()
                .entity(cars)
                .build();
    }

}
