package repository;

import models.RateConvertor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConversionRateRepository extends CrudRepository<RateConvertor, Long>{
    List<RateConvertor> findByFromCurrency(String fromCurrency);
}
