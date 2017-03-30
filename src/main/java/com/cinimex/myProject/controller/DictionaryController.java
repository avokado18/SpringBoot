package com.cinimex.myProject.controller;

import com.cinimex.myProject.model.Word;
import com.cinimex.myProject.service.WordsService;
import com.cinimex.myProject.translater.Parser;
import com.cinimex.myProject.translater.Translater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private WordsService wordsService;

    @RequestMapping(value = "")
    public String index() {
        return "redirect:/";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e,
                                   ModelMap modelMap) {
        modelMap.addAttribute("error", e.getMessage());
        return "error";
    }

    @RequestMapping(value = "/list", method = GET)
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("words", wordsService.getAll());
        return "dictionary/list";
    }

    @RequestMapping(value = "/addWords")
    public String addRedirect(){
        return "dictionary/addWords";
    }

    @RequestMapping(value = "/addOneWord", method = POST)
    public String saveOneWord(@ModelAttribute("word") Word word){
        wordsService.create(word);
        return "redirect:/";
    }

    @RequestMapping(value = "/addOneWord")
    public String addWordRedirect(){
        return "dictionary/addOneWord";
    }

    @RequestMapping(value = "/addText")
    public String addTextRedirect(){
        return "dictionary/addText";
    }

    @RequestMapping(value = "/addText", method = POST)
    public String addText(@ModelAttribute("textToTranslate") String textToTranslate, ModelMap modelMap) {
        String[] originals = Parser.getWords(textToTranslate);
        String[] translateds = Translater.getTranslated(originals);
        List<Word> words = new ArrayList<Word>();
        for (int i = 0; i < originals.length; i++) {
            Word word = new Word();
            word.setOriginal(originals[i]);
            word.setTranslated(translateds[i]);
            words.add(word);
        }
        modelMap.addAttribute("words", words);
        return "dictionary/addTextList";
    }

    @RequestMapping(value = "/addTextList", method = POST)
    public String deleteAddedWord(@ModelAttribute("wordsString") String wordsString, ModelMap modelMap){
        List<Word> words = Parser.JSONParser(wordsString);
        for(Word word : words) {
            wordsService.create(word);
        }
        modelMap.clear();
        return "redirect:/";
    }

}
