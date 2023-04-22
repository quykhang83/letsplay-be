package com.ctu.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.ctu.daos.CommentDAO;
import com.ctu.daos.ProductDAO;
import com.ctu.daos.UserDAO;
import com.ctu.dtos.CommentResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InvalidUserCommentException;
import com.ctu.model.Comment;
import com.ctu.model.Product;
import com.ctu.model.User;

@Stateless
public class CommentServiceImp implements CommentService {
    @Inject
    CommentDAO commentDAO;
    @Inject
    ProductDAO productDAO;
    @Inject
    UserDAO userDAO;

    @Override
    public Set<Comment> getAllComments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllComments'");
    }

    @Override
    public Comment getCommentById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            Comment comment = commentDAO.getCommentById(id);
            return comment;
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<CommentResponseDTO> getCommentByProductId(Long productId) {
        List<CommentResponseDTO> result = new ArrayList<CommentResponseDTO>();
        List<Comment> comments = new ArrayList<Comment>();
        try {
            Product product = productDAO.getProductById(productId);
            comments = product.getComments();
            comments.forEach((e) -> result.add(new CommentResponseDTO(e)));
        } catch (EmptyEntityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void createComment(Long productId, Comment comment, String email) {
        try {
            Product product = productDAO.getProductById(productId);
            User user = userDAO.getUserByEmail(email);
            comment.setProduct(product);
            comment.setUser(user);
            Timestamp createdTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));
            comment.setCreatedTime(createdTime);
            commentDAO.createComment(comment);
        } catch (EmptyEntityException e) {
            throw new IdNotFoundException(productId);
        }

    }

    @Override
    public void updateComment(Long idComment, Comment comment, String email) throws InvalidUserCommentException {
        Comment oldComment = getCommentById(idComment);
        if (!oldComment.getUser().getEmail().equals(email)) {
            throw new InvalidUserCommentException();
        } else {
            if (comment.getCommentContent() != null) {
                oldComment.setCommentContent(comment.getCommentContent());
            }
            if (comment.getCommentRecomment() != null) {
                oldComment.setCommentRecomment(comment.getCommentRecomment());
            }
            commentDAO.updateComment(oldComment);
        }
    }

    @Override
    public void deleteComment(Long idComment, String email) throws InvalidUserCommentException {
        Comment comment = getCommentById(idComment);
        if (!comment.getUser().getEmail().equals(email)) {
            throw new InvalidUserCommentException();
        } else {
            commentDAO.deleteComment(idComment);
        }
    }

}
