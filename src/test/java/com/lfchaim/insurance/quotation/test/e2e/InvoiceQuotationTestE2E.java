package com.lfchaim.insurance.quotation.test.e2e;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class InvoiceQuotationTestE2E {

	@Test
    void testCreate() {
        RestAssured.baseURI = "http://localhost:8080";

        given().contentType("application/json")
            .body("{\n"
            		+ "\"product_id\": \"prod-1\",\n"
            		+ "\"offer_id\": \"offer-1\",\n"
            		+ "\"category\": \"HOME\",\n"
            		+ "\"total_monthly_premium_amount\": 75.25,\n"
            		+ "\"total_coverage_amount\": 825000.00 }")
        .when()
            .post("/v1/insurance-quotations")
        .then()
            .statusCode(201)
            .body("product_id", equalTo("prod-1"))
            .body("offer_id", equalTo("offer-1"));
    }
	
}
