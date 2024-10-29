package temp;

import Utilities.base;
import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import org.apache.http.client.methods.HttpGet;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import Extensions.verification;
import com.jayway.jsonpath.*;

import static io.restassured.RestAssured.given;
import java.sql.Driver;

public class tempREST {

    String url = "http://localhost:48000/";

    RequestSpecification httpRequest;
    Response response ;
@Test(priority = 900000010)
    public void testing_chipOuts()
    {
        RestAssured.baseURI = url ;
        httpRequest = RestAssured.given().auth().preemptive().basic("userName:admin","password:adm");
        String session_ID = response.getCookie("sessionId");// init the http request
        response = httpRequest.get("/api/Settings/GetChipoutSettings");
        System.out.println(response.getBody().asString() + " test ok ");
        verification.textInString(response.getBody().asString() , "{\"Chipouts\":[\"Default 10 10\",\"Narrow 2 10\",\"Wide 2 20\"],\"DefaultChipout\":\"Default 10 10\"}");
    }

    @Test(priority = 900000020)
    public void testing_isRuningAjob()
    {
        RestAssured.baseURI = url ;
        httpRequest = RestAssured.given();
        response = httpRequest.contentType(ContentType.JSON).body("{userName:\"admin\",password:\"adm\"}").post("api/Login/loginUser");
        String session_ID = response.getCookie("sessionId");
        int statusCode  = response.statusCode();

        JsonPath jp = response.jsonPath();
        HttpGet r = new HttpGet(url+"api/CostOptimizer/GetSWVersion") ;
        //Cookie C = base.driver.manage().getCookieNamed("sessionid");
        r.setHeader("Cookie", "sessionId=" + session_ID);
        response = httpRequest.contentType(ContentType.JSON).body("{userName:\"admin\",password:\"adm\"}").get("api/CostOptimizer/GetSWVersion");
        System.out.println(response.getBody().asString() + " test ok ");
        verification.textInString(response.getBody().asString() , "77");
    }



}
