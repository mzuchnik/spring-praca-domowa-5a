package pl.mzuchnik.springpracadomowa5a.service;

import pl.mzuchnik.springpracadomowa5a.model.MemeModel;

import java.util.List;
import java.util.Optional;

public interface MemeService {


    Optional<MemeModel> getRandomMeme();

    Optional<MemeModel> getRandomMeme(String subreddit);

    Optional<MemeModel> getRandomMemeList(int count);

    Optional<MemeModel> getRandomMemeList(String subreddit, int count);


}
