package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String BASE_URL =
            "https://stellarburgers.education-services.ru/api";

    public Response createUser(User user) {

        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(BASE_URL + "/auth/register");
    }

    public Response login(User user) {

        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(BASE_URL + "/auth/login");
    }

    public void deleteUser(String accessToken) {

        given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/auth/user");
    }
}