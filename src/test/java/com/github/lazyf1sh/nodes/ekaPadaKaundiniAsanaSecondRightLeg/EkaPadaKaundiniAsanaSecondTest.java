package com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg;

import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.nodes.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EkaPadaKaundiniAsanaSecondTest {

    @Test
    public void test() throws IOException {
        // when
        String result = convertToRu(ekaPadaKaundiniAsanaSecond());

        // then
        assertThat(result.length(), equalTo(560));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }
}