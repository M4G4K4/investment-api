package com.investment.User;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class StockResourceIT {

    @Test
    public void getUsers() {
        given()
                .when().get("/user")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    public void getUserById() {
        given()
                .when().get("/user/1")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

}