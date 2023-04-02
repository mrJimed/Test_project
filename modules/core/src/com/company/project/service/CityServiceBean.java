package com.company.project.service;

import com.company.project.entity.City;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static org.jgroups.util.Util.assertEquals;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {
    @Inject
    DataManager dataManager;

    @Inject
    private Persistence persistence;

    @Override
    public City getDefaultCity() {
        City defaultCity = dataManager.loadValue("SELECT e FROM project_City e WHERE e.isDefaultCity = TRUE", City.class).one();
        return defaultCity;
    }

    @Override
    public void resetDefaultCity(City editedCity) {
        try(Transaction transaction = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery("SELECT e FROM project_City e WHERE e.isDefaultCity = TRUE AND e.id <> :cityId");
            query.setParameter("cityId", editedCity.getId());
            for(Object city: query.getResultList()) {
                ((City)city).setIsDefaultCity(false);
            }
            transaction.commit();
        }
    }
}