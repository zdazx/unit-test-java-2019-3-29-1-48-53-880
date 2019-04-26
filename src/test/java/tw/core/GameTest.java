package tw.core;

import com.google.inject.Inject;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    @Test
    public void should_return_guessed_result_1() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Game game = new Game(answerGenerator);
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        GuessResult expectedGuessResult = game.guess(answer);
        assertThat(expectedGuessResult.getResult().contains("A"),is(true));
    }

    @Test
    public void should_return_guessed_result_2() throws OutOfRangeAnswerException {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Game game = new Game(answerGenerator);
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        GuessResult expectedGuessResult = game.guess(answer);
        assertThat(expectedGuessResult.getResult().length(),is(4));
    }

}
