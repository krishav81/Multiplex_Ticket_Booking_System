package com.Multiplex.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.Hall;
@Repository
public interface HallDao extends JpaRepository<Hall, Integer> {


}
