package org.acme;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Path("/rooms")
public class RoomsResource {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/room-available-by-type")
  public Response getAvailableRoomsByType(String request_) throws IOException {
    Reader reader = new StringReader(request_);
    JsonReader jsonReader = Json.createReader(reader);
    JsonObject request = jsonReader.readObject();
    jsonReader.close();
    reader.close();
    String arrival = request.getString("dateArrivee");
    String departure = request.getString("dateDepart");
    JsonArray rooms = request.getJsonArray("roomList");
    System.out.println("================== arrival dans getAvailableRoomsByType = " + arrival);
    final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    List<AvailabilityResponse> roomList = new ArrayList<>();
    AvailabilityResponse xxx = new AvailabilityResponse();
    xxx.setTypeChambre("xxx");
    roomList.add(xxx);
    return Response.ok(roomList, MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/room-available-by-type-2")
  public AvailabilityResponse getAvailableRoomsByType2(AvailableRoomsRequest request) {
    String arrival = request.getDateArrive();
    String departure = request.getDateDepart();
    List<String> rooms = request.getRoomList();
    System.out.println("================== arrival dans getAvailableRoomsByType = " + arrival);
    final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    List<AvailabilityResponse> roomList = new ArrayList<>();

    AvailabilityResponse availabilityResponse = new AvailabilityResponse();
    availabilityResponse.setTypeChambre("xxx");
    roomList.add(availabilityResponse);
    return availabilityResponse;
  }
}
