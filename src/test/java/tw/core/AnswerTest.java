package tw.core;

import org.junit.Test;
import tw.core.model.Record;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void should_answer_create_answer_with_string(){
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        Answer expectedAnswer = Answer.createAnswer("1 5 6 7");
        assertThat(answer.toString(),is(expectedAnswer.toString()));
    }

    @Test
    public void should_return_index_of_num(){
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        int index = 0;
        int expectedIndex = answer.getIndexOfNum("1");
        assertThat(index,is(expectedIndex));
    }

    @Test
    public void should_return_checked_result_record_with_4A0B(){
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        Record record = new Record();
        record.increaseCurrentNum();
        record.increaseCurrentNum();
        record.increaseCurrentNum();
        record.increaseCurrentNum();
        Answer expectedAnswer = Answer.createAnswer("1 5 6 7");
        Record expectedRecord = expectedAnswer.check(answer);
        assertThat(record.getValue(),is(expectedRecord.getValue()));
    }

    @Test
    public void should_return_checked_result_record_with_others(){
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        Record record = new Record();
        record.increaseCurrentNum();
        record.increaseCurrentNum();
        record.increaseIncludeOnlyNum();
        record.increaseIncludeOnlyNum();
        Answer expectedAnswer = Answer.createAnswer("5 1 6 7");
        Record expectedRecord = expectedAnswer.check(answer);
        assertThat(record.getValue(),is(expectedRecord.getValue()));
    }

    @Test
    public void should_return_checked_result_record_with_others_01(){
        Answer answer = new Answer();
        answer.setNumList(new ArrayList<String>(){{
            add("1");
            add("5");
            add("6");
            add("7");
        }});
        Record record = new Record();
        record.increaseCurrentNum();
        record.increaseIncludeOnlyNum();
        Answer expectedAnswer = Answer.createAnswer("6 4 2 7");
        Record expectedRecord = expectedAnswer.check(answer);
        assertThat(record.getValue(),is(expectedRecord.getValue()));
    }

}