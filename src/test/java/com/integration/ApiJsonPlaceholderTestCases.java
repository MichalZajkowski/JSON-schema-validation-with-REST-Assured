package com.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class ApiJsonPlaceholderTestCases {

    private String baseJsonPlaceholderURL = "https://jsonplaceholder.typicode.com";

    @Test
    void testSchemaJsonForUsersResponse_isCorrect() {
        String usersPath = "/users";
        String userId = "/2";
        get(baseJsonPlaceholderURL + usersPath + userId).
                then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("apiplaceholder/usersJsonPlaceholderSchema.json")).
                body("username", Matchers.equalTo("Antonette"));
    }

    @Test
    void testSchemaJsonForPostsResponse_isCorrect() {
        String postPath = "/posts";
        String userId = "/1";
        get(baseJsonPlaceholderURL + postPath + userId).then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("apiplaceholder/postsJsonPlaceholderSchema.json")).
                body("title", Matchers.equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    void testSchemaJsonForCommentsResponse_isCorrect() {
        String commentPath = "/comments";
        String userId = "/1";
        get(baseJsonPlaceholderURL + commentPath + userId).then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("apiplaceholder/commentsJsonPlaceholderSchema.json")).
                body("email", Matchers.equalTo("Eliseo@gardner.biz"));
    }

    @Test
    void testSchemaJsonForAlbumsResponse_isCorrect() {
        String albumsPath = "/albums";
        String userId = "/1";
        get(baseJsonPlaceholderURL + albumsPath + userId).then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("apiplaceholder/albumsJsonPlaceholderSchema.json")).
                body("title", Matchers.equalTo("quidem molestiae enim"));
    }

    @Test
    void testUserResponse_isIncorrect() {
        String usersPath = "/users";
        String userId = "/0";
        get(baseJsonPlaceholderURL + usersPath + userId).then().statusCode(404);
    }

    @Test
    void testAlbumsResponse_isIncorrect() {
        String usersPath = "/albums";
        String userId = "/0";
        get(baseJsonPlaceholderURL + usersPath + userId).then().statusCode(404);
    }

    @Test
    void testCommentsResponse_isIncorrect() {
        String usersPath = "/comments";
        String userId = "/0";
        get(baseJsonPlaceholderURL + usersPath + userId).then().statusCode(404);
    }

    @Test
    void testPostsResponse_isIncorrect() {
        String usersPath = "/posts";
        String userId = "/0";
        get(baseJsonPlaceholderURL + usersPath + userId).then().statusCode(404);
    }
}
