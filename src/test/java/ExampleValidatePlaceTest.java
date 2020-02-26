import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ExampleValidatePlaceTest {

    @Test
    public void validateZipCode90210_And_PlaceNameBeverlyHills() {

        given().
                when().
                    get("http://zippopotam.us/us/90210").
                then().
                    assertThat().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void validateZipCode90210_And_StateCalifornia() {

        given().
                when().
                    get("http://zippopotam.us/us/90210").
                then().
                    assertThat().
                    body("places[0].'state'", equalTo("California"));
    }

    @Test
    public void validateZipCode90210_And_PlaceNameExpectContainsBeverlyHills() {

        given().
                when().
                    get("http://zippopotam.us/us/90210").
                then().
                    assertThat().
                    body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void validateZipCode90210_And_PlaceNameNotExpectContainsBeverlyHills() {

        given().
                when().
                    get("http://zippopotam.us/us/90210").
                then().
                    assertThat().
                    body("places.'place name'", not(hasItem("Beverlsy Hills")));
    }

    @Test
    public void validateZipCode90210_And_PlaceNameHasSize() {
        // Deve trazer apenas uma Plance Name.
        given().
                when().
                    get("http://zippopotam.us/us/90210").
                then().
                    assertThat().
                    body("places.'place name'", hasSize(1));
    }

}