package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.agnisarKriya.AgnisarKriya;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AgnisarKriyaTest {

    @Test
    public void should_draw_attention_when_size_has_changed() throws IOException {
        // when
        final String result = convertToRu(new AgnisarKriya().build());

        // then
        assertThat(result.length(), equalTo(833));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException {
        // given

        // when
        final String result = convertToRu(new AgnisarKriya().build());

        // then
        assertThat(result, containsString("Агнисара Дхаути Крийя."));
        assertThat(result, containsString("Очищение внутренним огнём."));
    }

    @Test
    public void should_pass_generic_check_ru() throws IOException {
        // then
        final String result = convertToRu(new AgnisarKriya().build());

        allCommonChecks(result, AgnisarKriya.class);
    }


}