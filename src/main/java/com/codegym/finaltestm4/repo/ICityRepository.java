package com.codegym.finaltestm4.repo;

import com.codegym.finaltestm4.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICityRepository extends PagingAndSortingRepository<City, Long> {

}
