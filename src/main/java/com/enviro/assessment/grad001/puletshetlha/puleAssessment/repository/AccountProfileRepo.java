package com.enviro.assessment.grad001.puletshetlha.puleAssessment.repository;


import com.enviro.assessment.grad001.puletshetlha.puleAssessment.model.AccountProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileRepo extends CrudRepository<AccountProfile, Integer>{

}
