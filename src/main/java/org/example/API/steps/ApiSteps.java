package org.example.API.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.API.bodies.BodyOfCreateUser;
import org.example.API.bodies.BodyOfLoginUser;
import org.hamcrest.CoreMatchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiSteps {

    static String createUserURL = "/api/auth/register";
    static String loginUserURL = "/api/auth/login";
    static String deleteUserURL = "/api/auth/user";

    @Step("Создание пользователя и все нужные проверки в 1 шаг")
    public static void createUserInOneStep(String email, String password, String name) {
        BodyOfCreateUser bodyOfCreateUser = new BodyOfCreateUser(email, password, name);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyOfCreateUser)
                .when()
                .post(createUserURL);
        response.then().statusCode(200)
                .and()
                .assertThat().body("success", equalTo(true));
    }

    @Step("Авторизация пользователя и все нужные проверки в 1 шаг")
    public static String loginUserInOneStep(String email, String password) {
        BodyOfLoginUser bodyOfLoginUser = new BodyOfLoginUser(email, password);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyOfLoginUser)
                .when()
                .post(loginUserURL);
        response.then().statusCode(200)
                .and()
                .assertThat().body("success", CoreMatchers.equalTo(true));
        return response.jsonPath().getString("accessToken");
    }

    @Step("Удаление пользователя и все нужные проверки в 1 шаг")
    public static void deleteUser(String bearerToken) {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(bearerToken.substring(7))
                .when()
                .delete(deleteUserURL);
        response.then().statusCode(202)
                .and()
                .assertThat().body("message", CoreMatchers.equalTo("User successfully removed"));
    }

    @Step("Авторизация пользователя")
    public static Response loginUser(String email, String password) {
        BodyOfLoginUser bodyOfLoginUser = new BodyOfLoginUser(email, password);
        return given()
                .contentType(ContentType.JSON)
                .body(bodyOfLoginUser)
                .when()
                .post(loginUserURL);
    }
}
