package com.github.lazyf1sh.nodes;

import java.io.IOException;

public interface GenericRuAsanaTest
{

    void should_draw_attention_when_length_has_changed() throws IOException;

    void should_contain_asana_name_ru() throws IOException;

    void should_contain_asana_meaning_ru() throws IOException;

    void should_pass_generic_check_ru() throws IOException;
}
