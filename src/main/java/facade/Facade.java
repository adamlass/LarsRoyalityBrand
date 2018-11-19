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

/**
 *
 * @author adamlass
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<CarDTO> search(String energyType,
            String minEcoRating,
            int minKmLiter,
            int maxSize,
            int minSize,
            double maxPrice,
            double minPrice,
            String colors) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT new dto.CarDTO(c) FROM Car c ";

        List<String> props = new ArrayList<>();

        if (!props.isEmpty()) {
            jpql += "WHERE " + props.get(0) + " ";
            for (int i = 1; i < props.size(); i++) {
                jpql += "AND " + props.get(i) + " ";
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
