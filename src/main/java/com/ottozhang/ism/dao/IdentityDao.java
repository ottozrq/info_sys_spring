package com.ottozhang.ism.dao;

import com.ottozhang.ism.dataModel.Identity;

import java.util.List;

/**
 * Created by zhangruoqiu on 2017/4/21.
 */
public interface IdentityDao<T> {
    public void add(T identity);
    public void update(T identity);
    public void delete(T identity);
    public List<Identity> show();
}
