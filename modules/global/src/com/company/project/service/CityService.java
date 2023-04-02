package com.company.project.service;

import com.company.project.entity.City;

public interface CityService {
    String NAME = "project_CityService";

    City getDefaultCity();
    void resetDefaultCity(City editedCity);
}