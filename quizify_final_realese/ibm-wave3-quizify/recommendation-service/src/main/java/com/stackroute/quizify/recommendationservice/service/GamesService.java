package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GamesService {

    public List<Game> getAll();

    public Game getone(long gameId);

    public Game create(Game game);

    public Game delete(long gamed);

    public Game update(Game game);

    List<Game> getMostPlayed();

    List<Game> getAllRelatedGamesOfAGenre(long genreId);

    List<Game> getAllRelatedGamesOfAGenreByName(String genreName);

    List<Game> getAllRelatedGamesOfATopic(long topicId);

    public List<Game> getAllRelatedGamesOfATopicByName(String topicName);

    List<Game> getAllGamesPlayedByAUser(long userId);

    public List<Game> getAllGamesPlayedByAUserName(String userName);

    List<Game> getAllGamesLikedByAUser(long userId);

    List<Game> getAllGamesLikedByAUserName(String userName);

    List<Game> getAllGamesByLevel(String level,int playerScore, int totalPoints);
}
