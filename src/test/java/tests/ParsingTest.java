package tests;

import com.cinimex.myProject.translater.Parser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParsingTest {
    private final String str = "мама, где папа нашел эту собаку? она - чудо";

    @Test
    public void parsingTest(){
        assertEquals(Parser.getWords(str), str.split("\\s*[^а-яА-ЯёЁ]+\\s*"));
    }
}
