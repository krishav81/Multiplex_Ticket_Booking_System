package com.Multiplex.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.HallCapacity;
@Repository
public interface HallCapacityDao extends JpaRepository<HallCapacity, Integer>{

}
