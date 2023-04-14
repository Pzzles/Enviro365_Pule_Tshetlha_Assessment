package com.enviro.assessment.grad001.puletshetlha.puleAssessment.service;

import com.enviro.assessment.grad001.puletshetlha.puleAssessment.model.AccountProfile;
import com.enviro.assessment.grad001.puletshetlha.puleAssessment.repository.AccountProfileRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AccountProfileService {
    public final AccountProfileRepo accountProfileRepo;

    public AccountProfileService(AccountProfileRepo accountProfileRepo) {
        this.accountProfileRepo = accountProfileRepo;
    }

    public AccountProfile get(Integer id){
        return accountProfileRepo.findById(id).orElse(null);
    }

    public Iterable<AccountProfile> get(){
        return  accountProfileRepo.findAll();
    }
    public AccountProfile save(String name, String surname, String httpImageLink){
    AccountProfile accountProfile = new AccountProfile();
    accountProfile.setName(name);
    accountProfile.setSurname(surname);
    accountProfile.setHttpImageLink(httpImageLink);
    accountProfileRepo.save(accountProfile);
    return accountProfile;
    }
}
