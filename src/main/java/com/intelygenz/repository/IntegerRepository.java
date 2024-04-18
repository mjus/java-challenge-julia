package com.intelygenz.repository;

import com.intelygenz.model.IntegerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegerRepository extends JpaRepository<IntegerEntity, Long> {

    @Query("SELECT integers FROM IntegerEntity WHERE id = :id")
    public String findIntegersById(@Param("id") Long numberId);

}
