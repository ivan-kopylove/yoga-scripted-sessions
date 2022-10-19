package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecondRightLeg.ekaPadaKaundiniAsanaSecondRightLeg;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ekaPadaKaundiniAsanaSecondRightLegTest {

    @Test
    public void test() throws IOException {
        // when
        String result = ekaPadaKaundiniAsanaSecondRightLeg();

        // then
        assertThat(result.length(), equalTo(449));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecondRightLeg.class);
    }
}