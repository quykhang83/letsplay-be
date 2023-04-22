package com.ctu.dtos;

import java.sql.Timestamp;

import com.ctu.model.Comment;
import com.ctu.model.User;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CommentResponseDTO {
    private Long commentId;
    private String commentContent;
    private Boolean commentRecommend;
    private Long productId;
    private User user;
    
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp createdTime;

    public CommentResponseDTO() {}

    public CommentResponseDTO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.commentContent = comment.getCommentContent();
        this.commentRecommend = comment.getCommentRecomment();
        this.productId = comment.getProduct().getProductId();
        this.user = comment.getUser();
        this.createdTime = comment.getCreatedTime();
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Boolean getCommentRecommend() {
        return commentRecommend;
    }

    public void setCommentRecommend(Boolean commentRecomment) {
        this.commentRecommend = commentRecomment;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

}
