package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//userEnpoints.java

public class userEndpoints {

    public static Response createUser(User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                     .post(urls.post_url);
        return response;
    }


    public static Response readUser(String userName){

        Response response = given()
                .pathParam("username",userName)
                .when()
                .get(urls.getBase_url);
        return response;
    }

    public static Response updateUser(String userName, User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)
                .when()
                .put(urls.put_url);
        return response;
    }

    public static Response deleteUser(String userName){

        Response response = given()
                .pathParam("username",userName)
                .when()
                .delete(urls.delete_url);
        return response;
    }
}

