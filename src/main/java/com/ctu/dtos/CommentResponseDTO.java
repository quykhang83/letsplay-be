package com.ctu.dtos;

import com.ctu.model.Comment;
import com.ctu.model.User;

public class CommentResponseDTO {
    private Long commentId;
    private String commentContent;
    private Boolean commentRecommend;
    private Long productId;
    private User user;

    public CommentResponseDTO() {}

    public CommentResponseDTO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.commentContent = comment.getCommentContent();
        this.commentRecommend = comment.getCommentRecomment();
        this.productId = comment.getProduct().getProductId();
        this.user = comment.getUser();
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

    
}
