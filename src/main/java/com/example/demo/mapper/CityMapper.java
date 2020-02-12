package com.example.demo.mapper;

import com.example.demo.pojo.City;
import com.example.demo.utils.ParentMapper;

import java.util.List;

public interface CityMapper extends ParentMapper<City> {

    List<City> getCityList();

}