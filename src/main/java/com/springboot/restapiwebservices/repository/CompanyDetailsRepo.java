package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetailsModel,String> {

  CompanyDetailsModel findBycompanyId(String companyId);
  List<CompanyDetailsModel> findByCompanyId(String companyId);

}
