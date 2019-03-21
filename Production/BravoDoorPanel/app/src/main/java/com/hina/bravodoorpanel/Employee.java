package com.hina.bravodoorpanel;

import java.util.ArrayList;

public class Employee {

    String name;
    String position;
    String status;
    String uniqueID;
    int pic;
    int id;
    ArrayList<String[]> officeHours = new ArrayList<>();

    /*public void fillList(){
        String[] tmp = new String[]{"Monday", "17:00 - 18:00"};
        officeHours.add(tmp);
        tmp = new String[]{"Tuesday", "12:00 - 13:00"};
        officeHours.add(tmp);
        tmp = new String[]{"Monday", "15:00 - 16:30"};
        officeHours.add(tmp);

//        tmp.add("Monday");
//        tmp.add("17:00 - 18:00");
//        officeHours.add(tmp);
//        tmp.add("Tuesday");
//        tmp.add("12:00 - 13:00");
//        officeHours.add(tmp);
//        tmp.add("Tuesday");
//        tmp.add("15:00 - 16:30");


    }*/

    Employee(String name, String position, String status,  int id, String uniqueID, ArrayList<String[]> officeHours /*,int pic, ArrayList<String[]> officeHours*/) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.status = status;
        this.uniqueID = uniqueID;
        this.officeHours = officeHours;
/*        this.pic = pic;*/

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int pic) {
        this.id = id;
    }

    public ArrayList<String[]> getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(ArrayList<String[]> officeHours) {
        this.officeHours = officeHours;
    }
}

