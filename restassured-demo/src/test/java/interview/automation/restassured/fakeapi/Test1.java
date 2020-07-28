package interview.automation.restassured.fakeapi;



import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.mapper.TypeRef;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.*;
import static org.hamcrest.Matchers.*;

public class Test1 {
    private String url;
    private String url2;
    @Before
    public void setUp(){
        this.url = "http://jsonplaceholder.typicode.com/posts/1";
        this.url2 = "http://jsonplaceholder.typicode.com/posts/";
    }
//    @Test
    public void getUserById(){
        Response response = get(this.url);
        int code = response.getStatusCode();

        response.then().body("userId",equalTo(1));
        Assert.assertEquals(code, 200);
    }
    @Test
    public void getAllUsers(){
        get(this.url2).then().body("size",greaterThan(10))
                .body("$", hasItem(hasEntry("userId",1)))
                ;
        RestAssured.defaultParser = Parser.JSON;
        Response response = when().get(this.url2);
        // get all users as a string of json
        List<String> users = response.jsonPath().getList("$"); // $ means from root
        List<Integer> userIds = response.jsonPath().getList("userId");
        List<Integer> ids = response.jsonPath().getList("id");
        System.out.println(ids);
    }
}
