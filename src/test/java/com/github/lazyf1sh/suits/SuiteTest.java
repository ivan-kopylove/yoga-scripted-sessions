package com.github.lazyf1sh.suits;

import java.io.IOException;

public interface SuiteTest {


     void should_draw_attention_when_length_has_changed() throws IOException;

     void should_contain_specific_lines_ru() throws IOException;

     void should_pass_generic_checks_ru() throws IOException;
}
