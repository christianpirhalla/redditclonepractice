package com.example.redditclonepractice.services;


import com.example.redditclonepractice.dto.SubredditDto;
import com.example.redditclonepractice.model.Subreddit;
import com.example.redditclonepractice.repositories.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    @Autowired
    SubredditRepository subredditRepository;

    public SubredditDto save(SubredditDto subredditDto){
        Subreddit save = subredditRepository.save(mapSubredditDto(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    private Subreddit mapSubredditDto(SubredditDto subredditDto) {
        return Subreddit.builder().name(subredditDto.getSubredditName())
                .description(subredditDto.getDescription())
                .build();
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private SubredditDto mapToDto(Subreddit subreddit) {
        return SubredditDto.builder().subredditName(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                .build();
    }

}
