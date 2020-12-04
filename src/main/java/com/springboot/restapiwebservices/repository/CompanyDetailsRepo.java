package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetailsModel,Integer> {

    List<CompanyDetailsModel> findByCompanyId(int companyId);
}
