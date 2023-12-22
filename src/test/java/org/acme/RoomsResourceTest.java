package org.acme;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

@QuarkusTest
class RoomsResourceTest {
  @Test
  void getAvailableRoomsByType() {
    given()
        .body(
            "{\"dateArrivee\":\"2021-01-01\",\"dateDepart\":\"2021-01-02\",\"roomList\":[{\"typeChambre\":\"xxx\"}]}")
        .when()
        .post("/rooms/room-available-by-type")
        .then()
        .statusCode(200);
  }

  @Test
  void getAvailableRoomsByType2() {
    final String body = getBody();
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(body)
        .when()
        .post("/rooms/room-available-by-type-2")
        .then()
        .log()
        .all()
        .statusCode(200)
        .body("typeChambre", org.hamcrest.Matchers.equalTo("xxx"));
  }

  private static String getBody() {
    Jsonb jsonb = JsonbBuilder.create();

    AvailableRoomsRequest request = new AvailableRoomsRequest();
    request.setDateArrive("2021-01-01");
    request.setDateDepart("2021-01-02");
    request.setRoomList(new ArrayList<>());
    request.getRoomList().add("xxx");
    String body = jsonb.toJson(request); // Rest assured still not support jakarta.json.bind
    return body;
  }
}
