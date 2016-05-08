package com.agroho.repository;

import com.agroho.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rezaul on 5/8/16.
 */
public interface UserRoleRepository extends CrudRepository <UserRole,Long>{

    @Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
    public List<String> findRoleByUserName(String username);

}
