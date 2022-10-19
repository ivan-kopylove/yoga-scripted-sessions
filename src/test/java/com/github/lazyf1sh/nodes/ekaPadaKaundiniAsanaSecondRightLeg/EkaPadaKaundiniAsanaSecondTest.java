package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.sides.Side.RIGHT;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EkaPadaKaundiniAsanaSecondTest {

    @Test
    public void test_left() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecond(LEFT_DEFAULT);

        // then
        assertThat(result.length(), equalTo(484));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }

    @Test
    public void test_right() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecond(RIGHT);

        // then
        assertThat(result.length(), equalTo(484));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }
}