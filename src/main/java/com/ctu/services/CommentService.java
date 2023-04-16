package com.ctu.services;

import java.util.List;
import java.util.Set;

import com.ctu.dtos.CommentResponseDTO;
import com.ctu.exception.InvalidUserCommentException;
import com.ctu.model.Comment;

public interface CommentService {
    public Set<Comment> getAllComments();

    public Comment getCommentById(final Long id);

    public List<CommentResponseDTO> getCommentByProductId(final Long productId);

    public void createComment(final Long productId, final Comment comment, final String email);

    public void updateComment(Long idComment, Comment comment, final String email) throws InvalidUserCommentException;

    public void deleteComment(Long id, final String email) throws InvalidUserCommentException;
}
