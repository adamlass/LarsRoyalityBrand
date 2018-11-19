/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.CarDTO;
import entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author adamlass
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<CarDTO> search(String[] energyTypes,
            String[] ecoRatings,
            int minKmLiter,
            int maxSeats,
            int minSeats,
            double maxPrice,
            double minPrice,
            String[] colors) {

        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT new dto.CarDTO(c) FROM Car c";

        
        List<String> props = new ArrayList<>();
        //Props
        
        if (energyTypes != null) {
            String energyTypesString = "( c.energyType = '" + energyTypes[0] + "'";
            for (int i = 1; i < energyTypes.length; i++) {
                energyTypesString += " OR c.energyType = '" + energyTypes[i] + "'";
            }
            energyTypesString += ")";
            props.add(energyTypesString);
        }
        
        if (ecoRatings != null) {
            String ecoRatingsString = "( c.ecoRating = '" + ecoRatings[0] + "'";
            for (int i = 1; i < ecoRatings.length; i++) {
                ecoRatingsString += " OR c.ecoRating = '" + ecoRatings[i] + "'";
            }
            ecoRatingsString += ")";
            props.add(ecoRatingsString);
        }

        if (minKmLiter > 0) {
            props.add("c.kmLiter >= '" + minKmLiter + "'");
        }
        if (maxSeats > 0) {
            props.add("c.seats <= '" + maxSeats + "'");
        }
        if (minSeats > 0) {
            props.add("c.seats >= '" + minSeats + "'");
        }
        if (maxPrice > 0) {
            props.add("c.price <= '" + maxPrice + "'");
        }
        if (minPrice > 0) {
            props.add("c.price >= '" + minPrice + "'");
        }
        if (colors != null) {
            String colorsString = "( c.color = '" + colors[0] + "'";
            for (int i = 1; i < colors.length; i++) {
                colorsString += " OR c.color = '" + colors[i] + "'";
            }
            colorsString += ")";
            props.add(colorsString);
        }

        //Props
        if (!props.isEmpty()) {
            jpql += " WHERE " + props.get(0);
            for (int i = 1; i < props.size(); i++) {
                jpql += " AND " + props.get(i);
            }
        }

        try {

            TypedQuery<CarDTO> tq = em.createQuery(jpql, CarDTO.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

}
