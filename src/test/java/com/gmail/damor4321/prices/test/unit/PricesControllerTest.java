package com.gmail.damor4321.prices.test.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gmail.damor4321.prices.beans.object.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;


// TODO: Auto-generated Javadoc
/* The Class PricesControllerTest */

/**
 * The Class PricesControllerTest.
 */
@SpringBootTest(
	properties = {
			"spring.profiles.active=test"
	},
	webEnvironment = WebEnvironment.RANDOM_PORT
)

@Timeout(value = 20, unit = TimeUnit.SECONDS)

/** The Constant log. */
@Slf4j
public class PricesControllerTest {

	/** The port. */
	@LocalServerPort
	private int port = 60002;
	
	/** The rt. */
	@Autowired
	private TestRestTemplate rt;

	/**
	 * Test get price 1.
	 */
	@Test
	void testGetPrice1() {
		String getPriceURI = getPriceUri(35455L, 1, "2020-06-14 10:00:00");
		ResponseEntity<Price> response = rt.getForEntity(getPriceURI, Price.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "testGetPrice1 check");
		Price result = response.getBody();
		assertThat(withBigDecimal(result.getPrice(), 2)).isEqualTo(35.50);
	}

	/**
	 * Test get price 2.
	 */
	@Test
	void testGetPrice2() {
		String getPriceURI = getPriceUri(35455L, 1, "2020-06-14 16:00:00");
		ResponseEntity<Price> response = rt.getForEntity (getPriceURI, Price.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "testGetPrice2 check");
		Price result = response.getBody();
		assertThat(withBigDecimal(result.getPrice(), 2)).isEqualTo(25.45);
	}
	
	/**
	 * Test get price 3.
	 */
	@Test
	void testGetPrice3() {
		String getPriceURI = getPriceUri(35455L, 1, "2020-06-14 21:00:00");
		ResponseEntity<Price> response = rt.getForEntity (getPriceURI, Price.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "testGetPrice3 check");
		Price result = response.getBody();
		assertThat(withBigDecimal(result.getPrice(), 2)).isEqualTo(35.50);
	}

	/**
	 * Test get price 4.
	 */
	@Test
	void testGetPrice4() {
		String getPriceURI = getPriceUri(35455L, 1, "2020-06-15 10:00:00");
		ResponseEntity<Price> response = rt.getForEntity (getPriceURI, Price.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "testGetPrice4 check");
		Price result = response.getBody();
		assertThat(withBigDecimal(result.getPrice(), 2)).isEqualTo(30.50);
	}
	
	/**
	 * Test get price 5.
	 */
	@Test
	void testGetPrice5() {
		String getPriceURI = getPriceUri(35455L, 1, "2020-06-16 21:00:00");
		ResponseEntity<Price> response = rt.getForEntity (getPriceURI, Price.class);
		assertEquals(HttpStatus.OK, response.getStatusCode(), "testGetPrice5 check");
		Price result = response.getBody();
		assertThat(withBigDecimal(result.getPrice(), 2)).isEqualTo(38.95);
	}

	/**
	 * Test get price 6.
	 */
	@Test
	void testGetPrice6() {
		String getPriceURI = getPriceUri(0L, 1, "2021-06-16 21:00:00");
		ResponseEntity<Price> response = rt.getForEntity (getPriceURI, Price.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "testGetPrice6 check");
	}

	/**
	 * Gets the price uri.
	 *
	 * @param productId the product id
	 * @param brandId the brand id
	 * @param requestDate the request date
	 * @return the price uri
	 */
	private String getPriceUri(Long productId, Integer brandId, String requestDate) {

		String uri = String.format("%s:%d%s/product?product_id=%d&brand_id=%d&request_date=%s",
				"http://localhost", port, "/prices/v1", productId, brandId, requestDate);
		log.info("uri: " + uri);
        return uri;
	}

	/**
	 * With big decimal.
	 *
	 * @param bigDecimal the big decimal
	 * @param places the places
	 * @return the double
	 */
	public double withBigDecimal(BigDecimal bigDecimal, int places) {
		bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}

	

}
