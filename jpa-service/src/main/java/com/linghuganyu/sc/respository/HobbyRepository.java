package com.linghuganyu.sc.respository;

import com.linghuganyu.sc.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby,Integer> {
}
