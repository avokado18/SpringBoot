package tests;

import com.cinimex.myProject.MainConf;
import com.cinimex.myProject.model.Word;
import com.cinimex.myProject.service.WordsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainConf.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SetPriorityTest {
    @Autowired
    private WordsService wordsService;

    @Test
    public void priorityTest() {
        Word word = new Word();
        word.setOriginal("тест");
        word.setTranslated("test");
        Word savedWord = wordsService.create(word);
        assertEquals(savedWord.getPriority(), (word.getOriginal().hashCode() % 5));
    }
}
