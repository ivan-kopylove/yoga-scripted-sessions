package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecond;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecond.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EkaPadaKaundiniAsanaSecondTest {

    @Test
    public void test() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecond();

        // then
        assertThat(result.length(), equalTo(353));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }
}