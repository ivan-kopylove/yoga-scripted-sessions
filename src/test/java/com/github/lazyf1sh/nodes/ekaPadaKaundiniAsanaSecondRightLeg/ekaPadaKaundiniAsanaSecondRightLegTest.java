package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.sides.Side.LEFT_DEFAULT;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ekaPadaKaundiniAsanaSecondRightLegTest {

    @Test
    public void test() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecond(LEFT_DEFAULT);

        // then
        assertThat(result.length(), equalTo(484));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }
}