package com.github.lazyf1sh.asanas.ekaPadaKaundiniAsanaSecondRightLeg;

import com.github.lazyf1sh.asanas.named.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond;
import org.junit.Test;

import java.io.IOException;

import static com.github.lazyf1sh.asanas.named.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond.ekaPadaKaundiniAsanaSecond;
import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class EkaPadaKaundiniAsanaSecondTest
{

    @Test
    public void test() throws IOException
    {
        // when
        final String result = convertToRu(ekaPadaKaundiniAsanaSecond());

        // then
        assertThat(result.length(), equalTo(479));
        allCommonChecks(result, EkaPadaKaundiniAsanaSecond.class);
    }
}