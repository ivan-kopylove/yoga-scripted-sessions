package com.github.lazyf1sh.asanas.ashtangaNamaskara;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.ashtangaNamaskara.AshtangaNamaskara.ashtangaNamaskara;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AshtangaNamaskaraTest
{

    @Test
    public void should_draw_attention_when_length_has_changed() throws IOException
    {
        // when
        String result = convertToRu(ashtangaNamaskara());

        // then
        assertThat(result.length(), equalTo(221));
    }
}