package com.gmail.damor4321.prices.repositories;


import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.damor4321.prices.beans.database.PriceDb;

// TODO: Auto-generated Javadoc
/**
 *  Prices Repository.
 */
@Transactional
public interface PricesRepository extends CrudRepository<PriceDb, Long> {


	/**
	 * Runs a native query on the database to get the prices for a product.
	 *
	 * @param productId the product id
	 * @param brandId the brand id
	 * @param requestdate the requestdate
	 * @return the price
	 */
	@Query(
			value =
			"SELECT * "
					+ "FROM pos.prices "
					+ "WHERE product_id = ?1 AND brand_id = ?2 "
					+ "AND ?3 BETWEEN start_date AND end_date "
					+ "AND priority = (SELECT MAX(priority) FROM pos.prices "
					+ "WHERE product_id = ?1 AND brand_id = ?2 "
					+ "AND ?3 BETWEEN start_date AND end_date) ",
					nativeQuery = true)

	PriceDb getPricesForProductAndBrand(Long productId, Integer brandId, LocalDateTime requestdate);


}
