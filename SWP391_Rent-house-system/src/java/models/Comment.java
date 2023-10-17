package models;

import enums.CommentStatus;
import java.time.LocalDateTime;

public class Comment {
    private Integer commentId;
    private Integer ownerId;
    private Integer postId;
    private String content;
    private LocalDateTime createdAt;
    private CommentStatus status;

    public Comment() {
    }

    public Comment(Integer commentId, Integer ownerId, Integer postId, String content, LocalDateTime createdAt, CommentStatus status) {
        this.commentId = commentId;
        this.ownerId = ownerId;
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", ownerId=" + ownerId + ", postId=" + postId + ", content=" + content + ", createdAt=" + createdAt + ", status=" + status + '}';
    }
    
}
