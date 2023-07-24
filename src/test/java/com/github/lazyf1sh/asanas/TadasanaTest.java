package com.github.lazyf1sh.asanas;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.tadasana.Tadasana.tadasana;
import static com.github.lazyf1sh.asanas.named.tadasana.TadasanaPalmsInNamaste.tadasanaPalmsInNamaste;
import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TadasanaTest
{

    @Test
    public void should_be_of_expected_length() throws IOException
    {
        // given


        // when
        final String result = convertToRu(tadasanaPalmsInNamaste());

        // then
        assertThat(result.length(), equalTo(866));
    }

    @Test
    public void should_contain_asana_name() throws IOException
    {
        // given

        // when
        final String result = convertToRu(tadasana());

        // then
        assertThat(result, containsString("Тад+асана."));
    }

    @Test
    public void should_contain_asana_name_ru() throws IOException
    {
        // given


        // when
        final String result = convertToRu(tadasanaPalmsInNamaste());


        // then
        assertThat(result, containsString("Тад+асана."));
        assertThat(result, containsString("Поза горы."));
        assertThat(result, containsString("Вариант с кистями, сложенными в намасте."));
        containsNoCurlyBrackets(result);
    }
}