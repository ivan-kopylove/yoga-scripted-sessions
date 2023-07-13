package com.github.lazyf1sh.suits;

import com.github.lazyf1sh.domain.SourceFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.lazyf1sh.nodes.known.agnisarKriya.AgnisarKriya.agnisarKriya;
import static com.github.lazyf1sh.nodes.known.bitilasana.Bitilasana.bitilasana;
import static com.github.lazyf1sh.nodes.known.suptaVirasana.SuptaVirasana.suptaVirasana;
import static com.github.lazyf1sh.nodes.known.tadasana.Tadasana.tadasana;
import static com.github.lazyf1sh.nodes.known.urdhvaHastasana.UrdhvaHastasanaOnHeels.urdhvaHastasanaOnHeels;
import static com.github.lazyf1sh.nodes.known.urdhvaHastasana.UrdhvaHastasanaOnTipToes.urdhvaHastasanaOnTipToes;
import static com.github.lazyf1sh.nodes.unknown.b21ef52bd090.b21ef52bd090;
import static com.github.lazyf1sh.nodes.unknown.b5330ada6870.b5330ada6870;
import static com.github.lazyf1sh.nodes.unknown.b9570a4275e4.b9570a4275e4;
import static com.github.lazyf1sh.nodes.unknown.bf74e9ab9596.bf74e9ab9596;
import static com.github.lazyf1sh.nodes.unknown.d41ec8988cb2.d41ec8988cb2;
import static com.github.lazyf1sh.nodes.unknown.d856222abcd5.d856222abcd5;
import static com.github.lazyf1sh.nodes.unknown.ef2eb0af2276.ef2eb0af2276;
import static com.github.lazyf1sh.nodes.unknown.t2acd3f67e8ed.t2acd3f67e8ed;
import static com.github.lazyf1sh.util.Util.readFile;

public class SuryaNamaskar implements Suite
{

    public static List<SourceFile> suryaNamaskar() throws IOException
    {
        return new SuryaNamaskar().build();
    }

    public List<SourceFile> build() throws IOException
    {
        final List<SourceFile> result = new ArrayList<>();

        // round one
        result.add(urdhvaHastasanaOnTipToes());
        result.add(urdhvaHastasanaOnHeels());
        result.add(t2acd3f67e8ed());
        result.add(readFile("surya-namaskar-round-01.txt"));

        //round two
        result.add(tadasana());
        result.add(readFile("surya-namaskar-round-02.txt"));

        // round three
        result.add(readFile("surya-namaskar-round-03.txt"));

        // part two
        result.add(readFile("ardha-uttanasana-with-standing-point.txt"));
        result.add(readFile("kapalabhati.txt"));
        result.add(agnisarKriya());
        result.add(d41ec8988cb2());
        result.add(bitilasana());
        result.add(readFile("marjariasana-with-knee-to-elbow.txt"));
        result.add(readFile("dandayamana-Bharmanasana-balancing-table.txt"));
        result.add(readFile("eka-hasta-vjagrasana-cross-hook.txt"));
        result.add(readFile("eka-pada-adho-mukha-svanasana-with-elbow-down.txt"));
        result.add(ef2eb0af2276());
        result.add(readFile("dolphin.txt"));
        result.add(b21ef52bd090());
        result.add(readFile("spring-of-leg-moved-to-a-side.txt"));
        result.add(readFile("transition-266ae7aacbff.txt"));
        result.add(readFile("rotate-a-knee-outwards.txt"));
        result.add((d856222abcd5()));
        result.add(readFile("big-toe-to-ear.txt"));
        result.add(readFile("eka-hasta-vjagrasana-one-side-hook.txt"));
        result.add(b5330ada6870());
        result.add(b9570a4275e4());
        result.add(suptaVirasana());
        result.add(bf74e9ab9596());


        return result;
    }
}
