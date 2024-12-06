package com.github.lazyf1sh.common;

import com.github.lazyf1sh.asanas.Asana;
import com.github.lazyf1sh.asanas.named.agnisarKriya.AgnisarKriya;
import com.github.lazyf1sh.asanas.named.ashtangaNamaskara.AshtangaNamaskara;
import com.github.lazyf1sh.asanas.named.balasana.Balasana;
import com.github.lazyf1sh.asanas.named.bitilasana.makarasana.Makarasana;
import com.github.lazyf1sh.asanas.named.dhanurasana.Dhanurasana;
import com.github.lazyf1sh.asanas.named.ekaPadaKaundiniAsanaSecondRightLeg.EkaPadaKaundiniAsanaSecond;
import com.github.lazyf1sh.asanas.named.hastauttanasana.HastaUttanasana;
import com.github.lazyf1sh.asanas.named.marjariasana.Marjariasana;
import com.github.lazyf1sh.asanas.named.shalabhasana.Shalabhasana;
import com.github.lazyf1sh.asanas.named.vasisthasana.VasisthasanaLegsExtended;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static com.github.lazyf1sh.util.CommonAssertion.allCommonChecks;
import static com.github.lazyf1sh.util.Util.convertToRu;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AsanaCommonCheck {

    private static Asana initClass(Class clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Asana asana = (Asana) declaredConstructor.newInstance();
        return asana;
    }

    private static Stream<Arguments> lengths() {
        return Stream.of(
                Arguments.of(AgnisarKriya.class, 910),
                Arguments.of(Dhanurasana.class, 513),
                Arguments.of(Marjariasana.class, 254),
                Arguments.of(HastaUttanasana.class, 702),
                Arguments.of(Balasana.class, 573),
                Arguments.of(Makarasana.class, 428),
                Arguments.of(Shalabhasana.class, 237),
                Arguments.of(VasisthasanaLegsExtended.class, 141),
                Arguments.of(AshtangaNamaskara.class, 221)


        );
    }

    @ParameterizedTest
    @MethodSource("lengths")
    public void common_checks(Class clazz, int expectedLength) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        // given
        Asana asana = initClass(clazz);


        // then
        String result = convertToRu(asana.build());
        allCommonChecks(result, clazz);
        assertThat(result.length(), equalTo(expectedLength));
    }
}
