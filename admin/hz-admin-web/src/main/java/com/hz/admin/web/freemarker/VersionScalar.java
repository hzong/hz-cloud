package com.hz.admin.web.freemarker;

import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname VersionScalar
 * @Description TODO
 * @Date 2020-04-30 21:41
 * @Created by hzong
 */
@Component
public class VersionScalar implements TemplateScalarModel {

    /**
     * 版本号
     */
    private static String VERSION ="?v="+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    @Override
    public String getAsString() throws TemplateModelException {
        return VERSION;
    }
}
