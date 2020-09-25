package com.thoughtworks.basic;

import java.util.HashSet;
import java.util.Set;

public class SchemaFactory {
    public static FlagSchema create(String flag) throws Exception {
        switch(flag){
            case "l" :
                FlagSchema flagSchema = new FlagSchema(flag,Boolean.TYPE,false);
                return flagSchema;
            case "p" :
                FlagSchema flagSchema1 = new FlagSchema(flag,Integer.TYPE,0);
                return flagSchema1;
            case "d" :
                FlagSchema flagSchema2 = new FlagSchema(flag,String.class,"");
                return flagSchema2;
        }
        throw new Exception("不能识别的命令标识符");
    }
}
