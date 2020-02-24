import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExampleLogResquestAndResponseTest {

    @Test
    public void useLogAllRequestAndResponse() {

        given().
            log().all().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            log().body();
    }

}
