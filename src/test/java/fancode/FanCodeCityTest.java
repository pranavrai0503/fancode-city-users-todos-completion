package fancode;

import fancodePOJO.Todo;
import fancodePOJO.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class FanCodeCityTest {

    private static final String TODOS_ENDPOINT = "/todos";
    private static final String USERS_ENDPOINT = "/users";

    // Function to get users
    private List<User> getUsers() {
        RequestSpecification requestSpec = ApiRequestBuilder.getRequestSpec();

        Response response = given()
                .spec(requestSpec)
                .when()
                .get(USERS_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.jsonPath().getList("", User.class);
    }

    // Function to get todos
    private List<Todo> getTodos() {
        RequestSpecification requestSpec = ApiRequestBuilder.getRequestSpec();

        Response response = given()
                .spec(requestSpec)
                .when()
                .get(TODOS_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.jsonPath().getList("", Todo.class);
    }

    @Test
    public void testFancodeCityUsersTodosCompletion() {
        List<User> users = getUsers();
        List<Todo> todos = getTodos();

        // Filter users belonging to FanCode city
        List<User> fancodeCityUsers = users.stream()
                .filter(user -> {
                    double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
                    double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
                    return lat > -40 && lat < 5 && lng > 5 && lng < 100;
                })
                .collect(Collectors.toList());

        for (User user : fancodeCityUsers) {
            List<Todo> userTodos = todos.stream()
                    .filter(todo -> todo.getUserId() == user.getId())
                    .collect(Collectors.toList());

            long completedCount = userTodos.stream()
                    .filter(Todo::isCompleted)
                    .count();

            Assert.assertTrue(userTodos.size() > 0, "User has no todos.");
            double completionPercentage = ((double) completedCount / userTodos.size()) * 100;
            Assert.assertTrue(completionPercentage > 50,
                    "User " + user.getUsername() + " has completed less than 50% of their todos.");
        }
    }
}

