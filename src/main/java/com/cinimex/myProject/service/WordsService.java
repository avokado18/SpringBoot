package com.cinimex.myProject.service;

import com.cinimex.myProject.repository.WordRepository;
import com.cinimex.myProject.model.Word;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordsService {
    @Autowired
    private WordRepository wordRepository;

    @Transactional
    public List<Word> getAll() {
        return Lists.newArrayList(wordRepository.findAll());
    }
    @Transactional
    public Word getOne(Long id){
        return wordRepository.findOne(id);
    }

    @Transactional
    public Word create(Word word){
        Word newWord = new Word();
        newWord.setOriginal(word.getOriginal());
        newWord.setTranslated(word.getTranslated()  );
        newWord.setPriority(Math.abs(newWord.getOriginal().hashCode()) % 5);
        return wordRepository.save(newWord);
    }

    @Transactional
    public void delete(Long id){
        wordRepository.delete(id);
    }

    @Transactional
    public Word update(Long id, Word word){
        Word newWord = wordRepository.findOne(id);
        newWord.setOriginal(word.getOriginal());
        newWord.setTranslated(word.getTranslated());
        newWord.setPriority(Math.abs(newWord.getOriginal().hashCode()) % 5);
        return wordRepository.save(newWord);
    }

    @Transactional
    public List<Word> findWordsForTest(){
        List<Word> result = new ArrayList<Word>();
        result.addAll(wordRepository.findLimited(4, new PageRequest(0, 5)));
        result.addAll(wordRepository.findLimited(3, new PageRequest(0, 4)));
        result.addAll(wordRepository.findLimited(2, new PageRequest(0, 3)));
        result.addAll(wordRepository.findLimited(1, new PageRequest(0, 2)));
        result.addAll(wordRepository.findLimited(0, new PageRequest(0, 1)));
        return result;
    }

    @Transactional
    public List<Word> findWordsByPriority(Integer priority){
        return wordRepository.findLimited(priority, new PageRequest(0, 15));
    }
}
