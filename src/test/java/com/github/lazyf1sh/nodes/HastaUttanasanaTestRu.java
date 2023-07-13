package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.named.hastauttanasana.HastaUttanasana;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.named.hastauttanasana.HastaUttanasana.hastaUttanasana;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HastaUttanasanaTestRu
{

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException
    {
        // when
        final String result = convertToRu(hastaUttanasana());

        // then
        assertThat(result.length(), equalTo(705));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException
    {
        // when
        final String result = convertToRu(hastaUttanasana());

        // then
        assertThat(result, containsString("Хаста уттан+асана."));
    }

    @Test
    public void should_pass_generic_check_ru() throws IOException
    {
        // when

        final String result = convertToRu(hastaUttanasana());

        // then
        allCommonChecks(result, HastaUttanasana.class);
    }
}