package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void should_validate_01(){
        InputValidator inputValidator = new InputValidator();
        boolean flag = inputValidator.validate("1 5 6 7");
        assertThat(flag,is(true));
    }

    @Test
    public void should_validate_02(){
        InputValidator inputValidator = new InputValidator();
        boolean flag = inputValidator.validate("1 5 6 18");
        assertThat(flag,is(false));
    }

}
