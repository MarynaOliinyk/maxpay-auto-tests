package com.maxpay.api;

import com.maxpay.api.core.APITestBase;
import com.maxpay.api.model.Film;
import com.maxpay.api.model.People;
import com.maxpay.api.model.Planet;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class MaxpayAPITest extends APITestBase {

    @Test
    public void peopleTest() {
        String peopleResource = "people/{peopleID}";
        int peopleID = 1;
        String name = "Luke Skywalker";
        String planetName = "Tatooine";
        String title = "Attack of the Clones";
        long planetPopulation = 200000;

        People people = given().pathParam("peopleID", peopleID).spec(spec).
                expect().
                statusCode(SC_OK).
                when().
                get(peopleResource).as(People.class);
        assertEquals(name, people.getName());

        Planet planet = given().spec(spec).
                expect().
                statusCode(SC_OK).
                when().
                get(people.getHomeWorld()).as(Planet.class);

        assertEquals(planetName, planet.getName());
        assertEquals(planetPopulation, planet.getPopulation());

        Film film = given().spec(spec).
                expect().
                statusCode(SC_OK).
                when().
                get(planet.getFilms().get(0)).as(Film.class);

        assertEquals(title, film.getTitle());
        assertFalse(film.getCharacters().contains(peopleResource));
        assertTrue(film.getPlanets().contains(people.getHomeWorld()));

    }

}
