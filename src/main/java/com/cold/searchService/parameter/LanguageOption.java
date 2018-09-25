package com.cold.searchService.parameter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ohj on 2016/8/2.
 */
@XmlType(name = "LanguageOption")
@XmlEnum
public enum LanguageOption {

    @XmlEnumValue("en")
    EN("en"),
    @XmlEnumValue("zh")
    ZH("zh"),
    @XmlEnumValue("jp")
    JP("jp"),
    @XmlEnumValue("ko")
    KO("ko");
    private final String value;

    LanguageOption(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LanguageOption fromValue(String v) {
        for (LanguageOption c: LanguageOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
