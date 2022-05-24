package com.github.lazyf1sh.util;

import org.w3c.dom.Text;

public class TextTrimmer {

    public String multipleTrim(String content) {
        content = content.replace("\r\n", " ");
        content = content.replace("\n", " ");
        content = content.replace("\r", " ");
        for (int i = 0; i < 10; i++) {
            content = content.replace("  ", " ");
        }
        return content;
    }
}
