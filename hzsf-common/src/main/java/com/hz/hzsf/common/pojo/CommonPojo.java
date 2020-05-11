package com.hz.hzsf.common.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Classname CommonPojo
 * @Description TODO
 * @Date 2020-01-02 01:14
 * @Created by hzong
 */
public class CommonPojo implements Serializable {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
