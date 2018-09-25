package com.cold.util;

import java.util.regex.Pattern;

/**
 * Created by ohj on 2016/8/31.
 */
public class CommonConstants {

    public static final String CONTANS_CHAR = "的地得和与该及％%/\\";
    public static final String PUNCTUATION = "，|。|；|\\.|、|：|“|”|’|\\(|\\)";
    public static final String LUCENE_ESCAPE_CHARS = "[\\\"\\\\+\\-\\!\\(\\)\\:\\^\\[\\]\\{\\}\\~\\*\\?]";//需转义符号
    public static final Pattern LUCENE_PATTERN = Pattern.compile(LUCENE_ESCAPE_CHARS);
    public static final String REPLACEMENT_STRING = "\\\\$0";

    public static final Pattern pattern = Pattern.compile("<font color='red'>([\\s\\S]*?)</font>");

    public static final String INDEX_SEARCH_NAME = "source";
    public static final String INDEX_TRANS = "trans";
    public static final String INDEX_CORRESPOND = "correspond";
    public static final int SEARCH_COUNT = 100;
}
