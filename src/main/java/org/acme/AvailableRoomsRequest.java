package org.acme;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class AvailableRoomsRequest {
    private String dateArrive;
    private String dateDepart;
    private List<String> roomList;

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public List<String> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<String> roomList) {
        this.roomList = roomList;
    }
}
