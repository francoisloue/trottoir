package com.trottoir.trottoir.entities;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Post post;
    @Size(min = 144, message = "text content is above 144 characters limit")
    private String content;
    @Column(name = "like_count")
    private Long likeCount;
}
