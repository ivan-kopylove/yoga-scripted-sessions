package com.github.lazyf1sh.logic.resource.phrase.date.current.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.lazyf1sh.domain.Line;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.resource.phrase.date.current.api.BuildCurrentDateLineApi;
import com.github.lazyf1sh.logic.resource.phrase.date.current.api.BuildCurrentDateLineApi.Result.Success;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BuildCurrentDateLineUseCase implements BuildCurrentDateLineApi {


    @Override
    public BuildCurrentDateLineApi.Result buildCurrentDate() {

        try {
            Calendar cal = Calendar.getInstance();

            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

            Line e1 = new Line("""
                    { "ru": "%s." }""".formatted(format.format(cal.getTime())));
            var date = new SourceFile(List.of(e1));

            return new Success(date);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
