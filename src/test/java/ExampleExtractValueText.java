import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleExtractValueText {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setup() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void ExtractPlaceNameFromResponseBody() {

        String placeName =

        given().
            spec(requestSpec).
        when().
            get("us/90210").
        then().
            spec(responseSpec).
            extract().
            path("places[0].'place name'");

        assertEquals(placeName, "Beverly Hills");

    }
}