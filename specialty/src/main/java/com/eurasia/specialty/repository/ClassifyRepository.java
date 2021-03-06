package com.eurasia.specialty.repository;

import com.eurasia.specialty.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Aaron
 * @date 2020/5/16 - 17:33
 **/
public interface ClassifyRepository extends JpaRepository<Classify, Integer>, JpaSpecificationExecutor<Classify> {
}
