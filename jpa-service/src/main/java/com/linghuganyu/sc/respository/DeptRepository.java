package com.linghuganyu.sc.respository;

import com.linghuganyu.sc.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,Integer> {
}
