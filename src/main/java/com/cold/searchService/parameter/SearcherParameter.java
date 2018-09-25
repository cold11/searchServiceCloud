package com.cold.searchService.parameter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ohj on 2016/8/2.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearcherParameter", propOrder = {
        "searchCount",
        "languageOptions",
        "originalText"
})
public class SearcherParameter {
    @XmlElement(name = "searchCount")
    protected int searchCount;
    @XmlElement(name = "languageOptions")
    protected LanguageOptions languageOptions;
    @XmlElement(name = "originalText")
    protected String originalText;

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public LanguageOptions getLanguageOptions() {
        return languageOptions;
    }

    public void setLanguageOptions(LanguageOptions languageOptions) {
        this.languageOptions = languageOptions;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    @Override
    public String toString() {
        return "SearcherParameter{" +
                "searchCount=" + searchCount +
                ", languageOptions=" + languageOptions +
                ", originalText='" + originalText + '\'' +
                '}';
    }
}
