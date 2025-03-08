package com.atipera.repolister;

import com.atipera.repolister.service.GithubResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestHTTPEndpoint(GithubResource.class)
class GithubResourceTest {
    public static final String USERNAME = "opach16";

    @Test
    void shouldReturnRepositoriesForValidUser() {
        given()
                .pathParam("username", USERNAME)
                .when()
                .get("/{username}")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("$", notNullValue())
                .body("[0].repository_name", notNullValue())
                .body("[0].repository_name", not(emptyString()))
                .body("[0].owner_login", equalTo(USERNAME))
                .body("[0].branch", hasSize(greaterThan(0)))
                .body("[0].branch[0].branch_name", notNullValue())
                .body("[0].branch[0].commit_sha", notNullValue());
    }
}