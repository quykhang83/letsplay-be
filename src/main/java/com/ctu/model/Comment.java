package com.ctu.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ctu.utils.TimestampDeserializer;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "Comments")
@Table(name = "Comments", schema = "PUBLIC")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long commentId;

    @Column(name = "commentContent")
    private String commentContent;

    @Column(name = "commentRecomment")
    private Boolean commentRecomment;

    @Column(name = "createdTime")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp createdTime;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    // @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Comment() {}

    public Comment(String commentContent, Boolean commentRecomment, Timestamp createdTime) {
        this.commentContent = commentContent;
        this.commentRecomment = commentRecomment;
        this.createdTime = createdTime;
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.commentContent == null) {
            return true;
        }
        if (this.commentRecomment == null) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public boolean isUpdatable() {
        if (this.commentContent != null) {
            return true;
        }
        if (this.commentRecomment != null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentRecomment="
                + commentRecomment + "]";
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

    public Boolean getCommentRecomment() {
        return commentRecomment;
    }

    public void setCommentRecomment(Boolean commentRecomment) {
        this.commentRecomment = commentRecomment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
