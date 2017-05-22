package info.rekayasa.nyantai.models;

/**
 * Created by rachmadi on 5/22/17.
 */

public class Place {

    public String place_name;
    public String street;
    public String city;
    public double latitude;
    public double longitude;
    public String category;
    public String photo;

    public Place() {
    }

    public Place(String place_name, String street, String city, double latitude,
                 double longitude, String category, String photo) {
        this.place_name = place_name;
        this.street = street;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
        this.photo = photo;
    }
}
