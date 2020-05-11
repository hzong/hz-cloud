package com.hz.admin.db.service;

import com.github.pagehelper.PageHelper;
import com.hz.admin.db.result.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname BaseService
 * @Description TODO
 * @Date 2020-01-06 23:28
 * @Created by hzong
 */
public abstract class BaseService<TE, T, KI> implements InitializingBean,IService<TE,T,KI> {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    private final Map<String, Method> methodMap = new HashMap<>(10);

    /**
     * 获取Mapper
     *
     * @return
     */
    protected abstract Object mapper();

    private <R> R invokeMethod(String methodName, Object... args) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("invokeMethod() called with: methodName = [" + methodName + "], args = [" + args + "]");
        }
        R r = null;
        try {
            Method method = methodMap.get(methodName);
            r = (R) method.invoke(mapper(), args);
        } catch (IllegalAccessException e) {
            LOGGER.error("服务器异常：" + "invokeMethod() called with: methodName = [" + methodName + "], args = [" + args + "]", e);
        } catch (InvocationTargetException e) {
            LOGGER.error("服务器异常：" + "invokeMethod() called with: methodName = [" + methodName + "], args = [" + args + "]", e);
        }
        return r;
    }

    @Override
    public T selectByPrimaryKey(KI id) {
        T t = invokeMethod(IService.SELECT_BY_PRIMARY_KEY, id);
        return t;
    }
    @Override
    public long countByExample(TE example) {
        return invokeMethod(IService.COUNT_BY_EXAMPLE, example);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByExample(TE example) {
        return invokeMethod(IService.DELETE_BY_EXAMPLE, example);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(KI id) {
        return invokeMethod(IService.DELETE_BY_PRIMARY_KEY, id);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(T record) {
        return invokeMethod(IService.INSERT, record);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int[] batcherInsert(List<T> records) {
        int[] result = new int[records.size()];
        for (int i = 0; i < records.size(); i++) {
            result[i] = insert(records.get(i));
        }
        return result;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(T record) {
        return invokeMethod(IService.INSERT_SELECTIVE, record);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int[] insertSelective(List<T> records) {
        int[] result = new int[records.size()];
        for (int i = 0; i < records.size(); i++) {
            result[i] = insertSelective(records.get(i));
        }
        return result;
    }


    @Override
    public List<T> selectByExample(TE example) {
        return invokeMethod(IService.SELECT_BY_EXAMPLE, example);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByExampleSelective(T record, TE example) {
        return invokeMethod(IService.UPDATE_BY_EXAMPLE_SELECTIVE, example);
    }
    @Override
    public PageResult<T> selectPages(int pageNum, int pageSize, TE te) {
        //分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = selectByExample(te);
        return new PageResult(list);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByExample(T record, TE example) {
        return invokeMethod(IService.UPDATE_BY_EXAMPLE, example);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(T record) {
        return invokeMethod(IService.UPDATE_BY_PRIMARY_KEY_SELECTIVE, record);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(T record) {
        return invokeMethod(IService.UPDATE_BY_PRIMARY_KEY, record);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Method mod = null;
        for (Method method : mapper().getClass().getMethods()) {
            method.setAccessible(true);
            methodMap.put(method.getName(), method);
        }
    }

}
