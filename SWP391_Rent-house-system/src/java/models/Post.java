package models;

import enums.PostStatus;
import java.time.LocalDateTime;

public class Post {

    private Integer ownerId;
    private Integer addressId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private PostStatus status;
    private Double longitude;
    private Double latitude;
    private String country;
    private String city;
    private String district;
    private String street;
    private Double acreage;
    private Double listedPrice;

    public Post() {
    }

    public Post(Integer ownerId, Integer addressId, String title, String description, LocalDateTime createdAt, PostStatus status, Double longitude, Double latitude, String country, String city, String district, String street, Double acreage, Double listed_price) {
        this.ownerId = ownerId;
        this.addressId = addressId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
        this.city = city;
        this.district = district;
        this.street = street;
        this.acreage = acreage;
        this.listedPrice = listed_price;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public Double getListed_price() {
        return listedPrice;
    }

    public void setListed_price(Double listed_price) {
        this.listedPrice = listed_price;
    }

    @Override
    public String toString() {
        return "Post{" + "ownerId=" + ownerId + ", addressId=" + addressId + ", title=" + title + ", description=" + description + ", createdAt=" + createdAt + ", status=" + status + ", longitude=" + longitude + ", latitude=" + latitude + ", country=" + country + ", city=" + city + ", district=" + district + ", street=" + street + '}';
    }
    
}
