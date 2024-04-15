package com.semicolon.BloggersApp.dtos.requests;

import lombok.Data;

@Data
public class ViewPostRequest {
    private String postTitle;
    private String viewer;
}
