package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EkaPadaKaundiniAsanaSecondTest {

    @Test
    public void test_left() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecond();

        // then
        assertThat(result.length(), equalTo(481));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }

    @Test
    public void test_right() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecond();

        // then
        assertThat(result.length(), equalTo(481));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }
}