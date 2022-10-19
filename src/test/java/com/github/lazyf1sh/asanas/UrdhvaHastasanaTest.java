package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.urdhvaHastasana.UrdhvaHastasana;

import org.junit.Test;

import java.io.IOException;


import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UrdhvaHastasanaTest {




    @Test
    public void replaced_with_no_meaning() throws IOException {
        // given


        // when
        final String result = new UrdhvaHastasana().build();

        // then
        assertEquals(459, result.length());
        containsNoCurlyBrackets(result);
    }


}