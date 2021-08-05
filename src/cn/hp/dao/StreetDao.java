package cn.hp.dao;

import cn.hp.model.Street;

import java.util.List;

public interface StreetDao {
    public List<Street> findAllStreet(int cid);
}
