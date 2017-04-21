package com.ottozhang.ism.dao;

import com.ottozhang.ism.dataModel.Identity;

import java.util.List;

/**
 * Created by zhangruoqiu on 2017/4/21.
 */
public interface IdentityDao {
    public void add(Identity identity);
    public void update(Identity identity);
    public void delete(Identity identity);
    public List<Identity> search();
}
