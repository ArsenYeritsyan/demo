package com.example.demo.rest.controllers;


import com.example.demo.rest.models.CommentRequestModel;
import com.example.demo.rest.models.CommentResponseModel;
import com.example.demo.rest.models.ProducerRequestModel;
import com.example.demo.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CommentController {
    private final CommentService commentService;

    public CommentController( CommentService commentService) {
        this.commentService = commentService;

    }

    @PostMapping(value = "/producer")
    public ResponseEntity<CommentResponseModel> createComment(@RequestBody CommentRequestModel commentRequestModel) {
        CommentResponseModel comment = commentService.createComment(commentRequestModel);
        return ResponseEntity.ok(comment);
    }

    @PutMapping(value = "/producer/{id}")
    public ResponseEntity<CommentResponseModel> updateComment(@PathVariable Long id, @RequestBody CommentRequestModel commentRequestModel) {
        CommentResponseModel commentResponseModel = commentService.updateComment(id, commentRequestModel);
        return ResponseEntity.ok(commentResponseModel);
    }

    @GetMapping(value = "/producer")
    public ResponseEntity<List<CommentResponseModel>> findAll() {
        List<CommentResponseModel> all = commentService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/producer/{id}")
    public ResponseEntity<CommentResponseModel> findById(@PathVariable Long id) {
        CommentResponseModel commentResponseModel = commentService.findById(id);
        return ResponseEntity.ok(commentResponseModel);
    }

    @DeleteMapping("/producer/{id}")
    public ResponseEntity<CommentResponseModel> deleteComment(@PathVariable Long id) {
        CommentResponseModel delete = commentService.deleteComment(id);
        return ResponseEntity.ok(delete);
    }
}
