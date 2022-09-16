package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class Responses {
    File file = new File("src/test/java/apiTests/Body.json");

    @Test
    public void updatePet() {
        int petId = 12;
        Response updatePet = given()
                .accept("application/json")
                .header("Authorization","bearer a")
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Pet playlistResponse = updatePet.jsonPath().getObject("$", Pet.class);
        int petIdJson = playlistResponse.getId();
        Assert.assertEquals(petId, petIdJson);
    }

    @Test
    public void createUser() {
        Response createUser = given()
                .accept("application/json")
                .header("Authorization","bearer a")
                .contentType("application/json")
                .when()
                .body(file)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200)
                .extract()
                .response();

        User playlistResponse = createUser.jsonPath().getObject("$", User.class);
        String messageId = playlistResponse.getMessage();
        Assert.assertEquals(messageId, "15");
    }

    @Test
    public void deleteUser() {
        String name = "string";
        given()
                .accept("application/json")
                .header("Authorization","bearer a")
                .when()
                .delete("https://petstore.swagger.io/v2/user/" + name)
                .then()
                .statusCode(200)
                .extract()
                .response();
        //Оставил тут только проверку на 200
    }

    @Test
    public void updateUser() {
        String name = "string";
        given()
                .accept("application/json")
                .header("Authorization","bearer a")
                .contentType("application/json")
                .when()
                .body(file)
                .put("https://petstore.swagger.io/v2/user/" + name)
                .then()
                .statusCode(200)
                .extract()
                .response();
        //Оставил тут только проверку на 200
    }
}
