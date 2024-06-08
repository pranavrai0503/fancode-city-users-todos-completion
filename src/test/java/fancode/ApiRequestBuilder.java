package fancode;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class ApiRequestBuilder {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    private static final RequestSpecification requestSpec;

    static {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }


    public static void getTodos() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/todos")
                .then()
                .statusCode(200);
    }

    public static void getPosts() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/posts")
                .then()
                .statusCode(200);
    }

    public static void getComments() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/comments")
                .then()
                .statusCode(200);
    }

    public static void getAlbums() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/albums")
                .then()
                .statusCode(200);
    }

    public static void getPhotos() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/photos")
                .then()
                .statusCode(200);
    }

    public static void getUsers() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }
}

