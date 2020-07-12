package by.zapolski.englishphrases.controller;

import by.zapolski.englishphrases.service.TextToLemmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("text/check")
public class TextToLemmasController {

    @Autowired
    private TextToLemmasService textToLemmasService;

    @PostMapping
    public Set<String> getUniqueLemmasFromText(@RequestBody String text) {
        return textToLemmasService.getUniqueLemmasFromText(text);
    }

}
              