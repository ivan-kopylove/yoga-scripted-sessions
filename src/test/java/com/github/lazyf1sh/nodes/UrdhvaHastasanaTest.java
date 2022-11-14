package com.github.lazyf1sh.nodes;

import com.github.lazyf1sh.nodes.urdhvaHastasana.UrdhvaHastasana;

import org.junit.Test;

import java.io.IOException;


import static com.github.lazyf1sh.util.CommonAssertion.containsNoCurlyBrackets;
import static org.junit.Assert.assertEquals;

public class UrdhvaHastasanaTest {




    @Test
    public void replaced_with_no_meaning() throws IOException {
        // given


        // when
        final String result = new UrdhvaHastasana().build();

        // then
        assertEquals(461, result.length());
        containsNoCurlyBrackets(result);
    }


}