package com.dzzh.hz.hzsf.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * @Classname ReflectUtils
 * @Description TODO
 * @Date 2019-08-11 22:18
 * @Created by hzong
 */
public final class ReflectUtils {
    private ReflectUtils() {
    }
    public static Object[] toVarArgs(Method method, Object[] args) {
        if (method.isVarArgs()) {
            Class<?>[] methodParameterTypes = method.getParameterTypes();
            args = getVarArgs(args, methodParameterTypes);
    }

        return args;
    }

    static Object[] getVarArgs(Object[] args, Class<?>[] methodParameterTypes) {
        if (args.length == methodParameterTypes.length && args[args.length - 1].getClass().equals(methodParameterTypes[methodParameterTypes.length - 1])) {
            return args;
        } else {
            Object[] newArgs = new Object[methodParameterTypes.length];
            System.arraycopy(args, 0, newArgs, 0, methodParameterTypes.length - 1);
            Class<?> varArgComponentType = methodParameterTypes[methodParameterTypes.length - 1].getComponentType();
            int varArgLength = args.length - methodParameterTypes.length + 1;
            Object varArgsArray = Array.newInstance(ClassUtils.primitiveToWrapper(varArgComponentType), varArgLength);
            System.arraycopy(args, methodParameterTypes.length - 1, varArgsArray, 0, varArgLength);
            if (varArgComponentType.isPrimitive()) {
                varArgsArray = ArrayUtils.toPrimitive(varArgsArray);
            }

            newArgs[methodParameterTypes.length - 1] = varArgsArray;
            return newArgs;
        }
    }






}
