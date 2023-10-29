package com.github.lazyf1sh.asanas;

import com.github.lazyf1sh.asanas.named.Bends;
import com.github.lazyf1sh.asanas.named.SuryaNamaskar;
import com.github.lazyf1sh.asanas.named.commonWarump.CommonWarmup;
import com.github.lazyf1sh.asanas.named.hipsOpening.HipsOpening;
import com.github.lazyf1sh.asanas.named.outro.Outro;
import com.github.lazyf1sh.domain.Suite;
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

public class SuiteCommonCheck {

    private static Suite initClass(Class clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Suite asana = (Suite) declaredConstructor.newInstance();
        return asana;
    }

    private static Stream<Arguments> lengths() {
        return Stream.of(
                Arguments.of(SuryaNamaskar.class, 41204),
                Arguments.of(Bends.class, 32577),
                Arguments.of(Outro.class, 3862),
                Arguments.of(CommonWarmup.class, 9943),
                Arguments.of(HipsOpening.class, 32692)


        );
    }

    @ParameterizedTest
    @MethodSource("lengths")
    public void common_checks(Class<? extends Suite> clazz, int expectedLength) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        // given
        Suite suite = initClass(clazz);


        // then
        String result = convertToRu(suite.build());
        allCommonChecks(result, clazz);
        assertThat(result.length(), equalTo(expectedLength));
    }
}
