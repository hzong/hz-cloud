package com.dzzh.hz.hzsf.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.lang.reflect.Type;

/**
 * @Classname JsonUtils
 * @Description TODO
 * @Date 2020-05-21 23:26
 * @Created by hzong
 */
public final class JsonUtils {

    /**
     * 获取JSON字符串
     * @param obj
     * @return
     */
    public static String getJsonString(Object obj) throws JsonProcessingException {
        return JacksonUtils.toString(obj);
    }

    /**
     * 获取JSON字符串
     * @param obj
     * @return
     */
    public static String toString(Object obj) throws JsonProcessingException {
        return JacksonUtils.toString(obj);
    }

    public static <T> T parseObject(String json,Class<T> cls) throws JsonProcessingException {
        return JacksonUtils.parseObject(json,cls);
    }


    static class Tmpl{
        private String code;

        public String getCode() {
            return code;
        }

        public Tmpl setCode(String code) {
            this.code = code;
            return this;
        }
    }

    static class TmplOne extends Tmpl{
        private String code1;

        public String getCode1() {
            return code1;
        }

        public TmplOne setCode1(String code1) {
            this.code1 = code1;
            return this;
        }
    }

    static class TmplTwo extends Tmpl{
        private String code2;

        public String getCode2() {
            return code2;
        }

        public TmplTwo setCode2(String code2) {
            this.code2 = code2;
            return this;
        }
    }

    static class Bo {
        private int type;
        private Tmpl tmpl;

        public int getType() {
            return type;
        }

        public Bo setType(int type) {
            this.type = type;
            return this;
        }

        public  Tmpl getTmpl() {
            return tmpl;
        }

//        public <T extends Tmpl> T tmpl() {
//            return (T) tmpl;
//        }


        public Bo setTmpl(Tmpl tmpl) {
            this.tmpl = tmpl;
            return this;
        }

    }

    public static void main(String[] args) {

        Bo bo = new Bo();
        bo.setType(2);
        bo.setTmpl(new TmplTwo().setCode2("2").setCode("2"));




        /*ParserConfig.getGlobalInstance().getDeserializers().put(Bo.class, new ObjectDeserializer() {
            @Override
            public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
                System.out.println(fieldName );
                return (T) parser.parse();
            }

            @Override
            public int getFastMatchToken() {
                return 0;
            }
        });
        ParserConfig.getGlobalInstance().getDeserializers().put(Tmpl.class, new ObjectDeserializer() {
            @Override
            public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
                System.out.println(fieldName );

                Object val = parser.parseObject(new TypeReference<TmplTwo>() {
                }.getType(),fieldName);
                if(1==1){
                    return null;
                }
                return (T) val;
            }

            @Override
            public int getFastMatchToken() {
                return 0;
            }
        });*/

        String json = JSON.toJSONString(bo);
       /* for (int i = 0; i<1; i++) {

            try{
                Bo bob = JSON.parseObject(json,Bo.class);
                System.out.println(bob);

            }catch (Exception e){
                e.printStackTrace();
            }

            if(i % 10000 == 0){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }*/
        VO vo = JSON.parseObject("{\"vo_name\":\"abc\",\"vo_id\":123,\"value\":{}}", VO.class, new FieldTypeResolver() {
            @Override
            public Type resolve(Object object, String fieldName) {
                System.out.println(fieldName);
                return null;
            }
        });


//        String text = "{\"item_0\":{},\"item_1\":{}}";
//         json = "{\"vo_name\":\"abc\",\"vo_id\":123,\"value\":{}}";

        FieldTypeResolver fieldResolver = new FieldTypeResolver() {
            @Override
            public Type resolve(Object object, String fieldName) {
                if (fieldName.startsWith("item_")) {
                    return Item.class;
                }

                return null;
            }
        };

        VO jsonObject = JSON.parseObject(json, VO.class, fieldResolver);



        ExtraProcessor processor = new ExtraProcessor() {
            @Override
            public void processExtra(Object object, String key, Object value) {
//                Bo vo = (Bo) object;
                System.out.println(key);
//                vo.getAttributes().put(key, value);
            }
        };

        Bo vo1 = JSON.parseObject(json, Bo.class, processor);

    }


    public static class VO1 {
        private int id;
//        private Map<String, Object> attributes = new HashMap<String, Object>();
        public int getId() { return id; }
        public void setId(int id) { this.id = id;}
//        public Map<String, Object> getAttributes() { return attributes;}
    }
    public static class Item {

    }

    public static class VO implements FieldTypeResolver {
        public String name;
        public Value value;
        public int id;




        @Override
        public Type resolve(Object object, String fieldName) {
            System.out.println(fieldName);
            return null;
        }

        /*@Override
        public Type getType(String name) {
//            if ("value".equals(name)) {
//                return Value.class;
//            }
            return null;
        }

        @Override
        public void apply(String name, Object value) {
            System.out.println(name);
            if ("vo_id".equals(name)) {
                this.id = ((Integer) value).intValue();
                throw new RuntimeException();
            } else if ("vo_name".equals(name)) {
                this.name = (String) value;
            } else if ("value".equals(name)) {
                this.value = (Value) value;
            }
        }*/
    }

    public static class Value {

    }

}
