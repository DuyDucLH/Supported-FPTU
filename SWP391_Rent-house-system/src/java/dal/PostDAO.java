package dal;

import enums.PostStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Post;

public class PostDAO {

    private final DBContext dbContext = new DBContext();

    private Post postRowMapper(ResultSet rs) throws Exception {
        Integer ownerId = rs.getInt("owner_id");
        Integer addressId = rs.getInt("address_id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
        PostStatus status = PostStatus.valueOf(rs.getString("status"));
        Double longitude = rs.getDouble("longitude");
        Double latitude = rs.getDouble("latitude");
        String country = rs.getString("country");
        String city = rs.getString("city");
        String district = rs.getString("district");
        String street = rs.getString("street");
        Double acreage = rs.getDouble("acreage");
        Double listedPrice = rs.getDouble("listed-price");
        return new Post(ownerId, addressId, title, description, createdAt, status, longitude, latitude, country, city, district, street, acreage, listedPrice);
    }

    public Post getPostById(Integer postId) {
        String SQL = "select * from Post"
                + " where post_id = ?";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setInt(1, postId);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return postRowMapper(rs);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Post> getRecommendedPosts(Double userLatitude, Double userLongitude) {
        int numberPostOfList = 5;   //Recommended maximum number of post
        double recommendedRadius = 3; // km

        //Calculate range of latitude, longitude
        Double minLatitude = userLatitude - (recommendedRadius / 111);
        Double maxLatitude = userLatitude + (recommendedRadius / 111);
        Double minLongitude = userLongitude + (recommendedRadius / 111) / Math.cos(userLatitude);
        Double maxLongitude = userLongitude - (recommendedRadius / 111) / Math.cos(userLatitude);

        String SQL = "select * from Post"
                + " where (longitude > ? and longitude < ?) and (latitude > ? and latitude < ?)";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setDouble(1, minLongitude);
            ps.setDouble(2, maxLongitude);
            ps.setDouble(3, minLatitude);
            ps.setDouble(4, maxLatitude);
            List<Post> recommendedPosts = new ArrayList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (recommendedPosts.size() == numberPostOfList) {
                        break;
                    }
                    recommendedPosts.add(postRowMapper(rs));
                }
                return recommendedPosts;
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Post> getNearbyPosts(Double userLatitude, Double userLongitude) {
        double recommendedRadius = 3; // km

        //Calculate range of latitude, longitude
        Double minLatitude = userLatitude - (recommendedRadius / 111);
        Double maxLatitude = userLatitude + (recommendedRadius / 111);
        Double minLongitude = userLongitude + (recommendedRadius / 111) / Math.cos(userLatitude);
        Double maxLongitude = userLongitude - (recommendedRadius / 111) / Math.cos(userLatitude);

        String SQL = "select * from Post"
                + " where (longitude > ? and longitude < ?) and (latitude > ? and latitude < ?)";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setDouble(1, minLongitude);
            ps.setDouble(2, maxLongitude);
            ps.setDouble(3, minLatitude);
            ps.setDouble(4, maxLatitude);
            List<Post> nearbyPosts = new ArrayList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    nearbyPosts.add(postRowMapper(rs));
                }
                return nearbyPosts;
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Filter by location range
    public List<Post> getPostsByLocation(Double userLatitude, Double userLongitude, Double radius) {
        Double minLatitude = userLatitude - (radius / 111);
        Double maxLatitude = userLatitude + (radius / 111);
        Double minLongitude = userLongitude + (radius / 111) / Math.cos(userLatitude);
        Double maxLongitude = userLongitude - (radius / 111) / Math.cos(userLatitude);
        String SQL = "select * from Post"
                + " where (longitude > ? and longitude < ?) and (latitude > ? and latitude < ?)";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setDouble(1, minLongitude);
            ps.setDouble(2, maxLongitude);
            ps.setDouble(3, minLatitude);
            ps.setDouble(4, maxLatitude);
            List<Post> filterPosts = new ArrayList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    filterPosts.add(postRowMapper(rs));
                }
                return filterPosts;
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Filter by address location
    public List<Post> getPostsByAddress(String country, String city, String district, String street) {
        String SQL = "select * from Post"
                + " where country = ? and city = ? and district = ? and street = ?";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setNString(1, country);
            ps.setNString(2, city);
            ps.setNString(3, district);
            ps.setNString(4, street);
            List<Post> recommendedPosts = new ArrayList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    recommendedPosts.add(postRowMapper(rs));
                }
                return recommendedPosts;
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Filter by acreage range
    public List<Post> getPostsByAcreageRange(Double maxAcreage, Double minAcreage) {
        String SQL = "select * from Post"
                + " where acreage > ? and acreage < ?";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setDouble(1, minAcreage);
            ps.setDouble(2, maxAcreage);
            List<Post> filterPosts = new ArrayList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    filterPosts.add(postRowMapper(rs));
                }
                return filterPosts;
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Filter by listed price range
    public List<Post> getPostsByListedPriceRange(Double maxPrice, Double minPrice) {
        String SQL = "select * from Post"
                + " where listed_price > ? and listed_price < ?";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL)) {
            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);
            List<Post> filterPosts = new ArrayList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    filterPosts.add(postRowMapper(rs));
                }
                return filterPosts;
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
