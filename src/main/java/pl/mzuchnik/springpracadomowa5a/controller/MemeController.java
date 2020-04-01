package pl.mzuchnik.springpracadomowa5a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mzuchnik.springpracadomowa5a.model.MemeModel;
import pl.mzuchnik.springpracadomowa5a.service.MemeService;

import java.util.Optional;

@Controller
@RequestMapping("/api-meme")
public class MemeController {

    private MemeService memeService;

    @Autowired
    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping
    public String getMeme(Model model){
        Optional<MemeModel> randomMeme = memeService.getRandomMeme();
        randomMeme.ifPresent(memeModel -> model.addAttribute("memeModel", memeModel));
        return "index";
    }

    @GetMapping("/{count}")
    public String getMemes(Model model, @PathVariable int count){
        Optional<MemeModel> randomMemeList = memeService.getRandomMemeList(count);
        randomMemeList.ifPresent(memeModel -> model.addAttribute("memeModel",memeModel));
        return "index";
    }

    @GetMapping("/{subreddit}")
    public String getSubredditMeme(Model model, @PathVariable String subreddit) {
        Optional<MemeModel> randomMemeList = memeService.getRandomMeme(subreddit);
        randomMemeList.ifPresent(memeModel -> model.addAttribute("memeModel",memeModel));
        return "index";
    }
    @GetMapping("/{subreddit}/{count}")
    public String getSubredditMemes(Model model,
                                    @PathVariable("subreddit") String subreddit,
                                    @PathVariable("count") int count){
        Optional<MemeModel> randomMemeList = memeService.getRandomMemeList(subreddit, count);
        randomMemeList.ifPresent(memeModel -> model.addAttribute("memeModel",memeModel));
        return "index";
    }


}
