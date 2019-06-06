package com.example.hw6;

public class Camera {

    private String id,url,discription,type;
    private double lat,lng;;

    public Camera(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }



    public Camera (String id, String description, String url, String type) {
        this.id = id;
        this.type = type;
        this.discription = description;
        setUrl(url);
    }

    private void setUrl(String url) {

        String SDOTUrl = "http://www.seattle.gov/trafficcams/images/";
        String WSDOTUrl = "http://images.wsdot.wa.gov/nw/";

        if (type.equals("sdot")) {
            this.url = SDOTUrl + url;
        } else if (type.equals("wsdot")) {
            this.url = WSDOTUrl + url;
        }

    }

    public String getUrl() {
        return this.url;
    }

    public String getDiscription() {
        return this.discription;
    }

}

