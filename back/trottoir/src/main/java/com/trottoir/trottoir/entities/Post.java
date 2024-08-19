package com.trottoir.trottoir.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "post",uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Size(min = 144, message = "text content is above 144 characters limit")
    private String content;
    @OneToOne
    @JoinColumn(name="author_id", referencedColumnName = "id", nullable = false)
    private User author;
    @Column(name="like_count")
    private Long likeCount;
}

