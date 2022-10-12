package com.codegym.finaltestm4.repo;

import com.codegym.finaltestm4.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICountryRepository extends PagingAndSortingRepository<Country, Long> {
}
