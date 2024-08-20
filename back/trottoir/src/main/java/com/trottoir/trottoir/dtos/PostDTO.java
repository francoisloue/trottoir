package com.trottoir.trottoir.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDTO {
    @NotNull
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @Size(max = 144, message = "Content must not exceed 144 characters")
    private String content;

    @NotNull
    private Long authorId;

    private Long likeCount = 0L;

    // Getters and Setters
}
