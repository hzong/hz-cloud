package com.hz.hzsf.common.codes;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname NumberCodeEnum
 * @Description TODO
 * @Date 2020-01-31 21:08
 * @Created by hzong
 */
public enum NumberCodeEnum {
    N01(1, 1L, "1"),
    N02(2, 2L, "2"),
    N00(0, 0L, "0");
    private int ival;
    private String sval;
    private long lval;

    NumberCodeEnum(int ival, long lval, String sval) {
        this.ival = ival;
        this.sval = sval;
        this.lval = lval;
    }

    public int getIval() {
        return ival;
    }

    public String getSval() {
        return sval;
    }

    public long getLval() {
        return lval;
    }}
