package com.github.lazyf1sh.logic.phrase.date.current.usecase;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.node.*;
import com.github.lazyf1sh.domain.Line;
import static com.github.lazyf1sh.domain.LineType.REGULAR;
import com.github.lazyf1sh.domain.SourceFile;
import com.github.lazyf1sh.logic.phrase.date.current.api.BuildCurrentDateLineApi;
import com.github.lazyf1sh.logic.phrase.date.current.api.BuildCurrentDateLineApi.Result.Success;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BuildCurrentDateLineUseCase implements BuildCurrentDateLineApi {


    @Override
    public BuildCurrentDateLineApi.Result buildCurrentDate() {

        Calendar cal = Calendar.getInstance();

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("en", format.format(cal.getTime()));

        Line e1 = new Line(node, -1, REGULAR);

        var date = new SourceFile("current date", List.of(e1));

        return new Success(date);
    }


}
