package pl.mzuchnik.springpracadomowa5a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mzuchnik.springpracadomowa5a.model.MemeModel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MemeServiceImpl implements MemeService {

    private RestTemplate restTemplate;

    @Value("${api-meme-url}")
    private String apiMemeUrl;

    @Autowired
    public MemeServiceImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public Optional<MemeModel> getRandomMeme() {
        MemeModel memeModel = restTemplate.getForObject(apiMemeUrl + "/1", MemeModel.class);
        return Optional.ofNullable(memeModel);
    }

    @Override
    public Optional<MemeModel> getRandomMeme(String subreddit) {
        MemeModel memeModel = restTemplate.getForObject(apiMemeUrl + "/" + subreddit + "/1", MemeModel.class);
        return Optional.ofNullable(memeModel);
    }

    @Override
    public Optional<MemeModel> getRandomMemeList(int count) {
        MemeModel memesModel = restTemplate.getForObject(apiMemeUrl + "/" + count, MemeModel.class);
        return Optional.ofNullable(memesModel);
    }

    @Override
    public Optional<MemeModel> getRandomMemeList(String subreddit, int count) {
        MemeModel memesModel = restTemplate.getForObject(apiMemeUrl + "/" + subreddit + "/" + count, MemeModel.class);
        return Optional.ofNullable(memesModel);
    }


}
