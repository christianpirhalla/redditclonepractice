package com.example.redditclonepractice.controllers;

import com.example.redditclonepractice.dto.SubredditDto;
import com.example.redditclonepractice.model.Subreddit;
import com.example.redditclonepractice.services.SubredditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubredditController {

    @Autowired
    SubredditService subredditService;

    @PostMapping
    public ResponseEntity<SubredditDto> createSubreddit(@RequestBody SubredditDto subredditDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subredditService.save(subredditDto));
    }

    @GetMapping
    public ResponseEntity<List<SubredditDto>> getAllSubreddits(){
        return ResponseEntity.status(HttpStatus.OK).body(subredditService.getAll());
    }

}
