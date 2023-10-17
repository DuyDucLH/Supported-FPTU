package dal;

import enums.CommentStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Comment;

public class CommentDAO {

    private final DBContext dbContext = new DBContext();

    private Comment commentRowMapper(ResultSet rs) throws Exception {
        Integer commentId = rs.getInt("comment_id");
        Integer ownerId = rs.getInt("owner_id");
        Integer postId = rs.getInt("post_id");
        String content = rs.getString("content");
        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
        CommentStatus status = CommentStatus.valueOf(rs.getString("status"));
        return new Comment(commentId, ownerId, postId, content, createdAt, status);
    }

    public Comment createCommentOnPost(Integer postId, Integer ownerId, String content) {
        String SQL = "insert into Comment(owner_id, post_id, content, created_at, status)"
                + " values(?,?,?,?,?)";
        try ( Connection cn = dbContext.connection;  PreparedStatement ps = cn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, ownerId);
            ps.setInt(2, postId);
            ps.setNString(3, content);
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(5, CommentStatus.CREATED.toString());
            int affectedRow = ps.executeUpdate();
            if (affectedRow > 0) {
                Comment comment = new Comment(0, ownerId, postId, content, LocalDateTime.now(), CommentStatus.CREATED);
                try ( ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        comment.setCommentId(rs.getInt(1));
                        return comment;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
}
