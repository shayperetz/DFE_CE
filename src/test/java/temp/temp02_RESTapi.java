package temp;
import Utilities.base;
import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.HttpGet;
import org.json.simple.JSONObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import Extensions.verification;
public class temp02_RESTapi {

    String url = "http://localhost:48000/";

    RequestSpecification httpRequest;
    Response response ;

    @Test(priority = 900000020)
    public void testing_isRuningAjob()
    {
        RestAssured.baseURI = url ;
        httpRequest = RestAssured.given();
        response = httpRequest.contentType(ContentType.JSON).body("{userName:\"admin\",password:\"adm\"}").post("api/Login/loginUser");
        String session_ID = response.getCookie("sessionId");

        HttpGet r = new HttpGet(url+"api/CostOptimizer/GetSWVersion") ;
        //Cookie C = base.driver.manage().getCookieNamed("sessionid");
        r.setHeader("Cookie", "sessionId=" + session_ID);
        response = httpRequest.get("api/CostOptimizer/GetSWVersion");
        System.out.println(response.getBody().asString() + " test ok ");


    }
}
