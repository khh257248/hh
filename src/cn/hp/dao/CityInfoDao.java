package cn.hp.dao;

import cn.hp.model.City;
import cn.hp.model.Province;

import java.util.List;

public interface CityInfoDao {
    public List<City> findAllCity(int pid);
}
