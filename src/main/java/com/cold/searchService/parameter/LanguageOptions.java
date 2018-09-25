package com.cold.searchService.parameter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ohj on 2016/8/2.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LanguageOptions", propOrder = {
        "source",
        "target"
})
public class LanguageOptions {

    @XmlElement(name = "source")
    protected LanguageOption source;
    @XmlElement(name = "target")
    protected LanguageOption target;

    /**
     * 获取source属性的值。
     *
     * @return
     *     possible object is
     *     {@link LanguageOption }
     *
     */
    public LanguageOption getSource() {
        return source;
    }

    /**
     * 设置source属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link LanguageOption }
     *
     */
    public void setSource(LanguageOption value) {
        this.source = value;
    }

    /**
     * 获取target属性的值。
     *
     * @return
     *     possible object is
     *     {@link LanguageOption }
     *
     */
    public LanguageOption getTarget() {
        return target;
    }

    /**
     * 设置target属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link LanguageOption }
     *
     */
    public void setTarget(LanguageOption value) {
        this.target = value;
    }

    @Override
    public String toString() {
        return "LanguageOptions{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }
}
