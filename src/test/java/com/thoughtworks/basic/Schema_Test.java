package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Schema_Test {
    @Test
    public void should_return_type_when_given_flag_l(){
        FlagSchema flagSchema = new FlagSchema("l",Boolean.TYPE,false);
        FlagSchema flagSchema1 = new FlagSchema("p",Integer.TYPE,0);
        FlagSchema flagSchema2 = new FlagSchema("p",Integer.TYPE,0);
        List<FlagSchema> flagsSchema =  new ArrayList<>();
        flagsSchema.add(flagSchema);
        flagsSchema.add(flagSchema1);
        flagsSchema.add(flagSchema2);
        Schema schema = new Schema(flagsSchema);

        String flag = "p";
        System.out.println(schema.getFlagsSchemas());
        System.out.println(schema.getTypeOf("p"));

        Assert.assertEquals(schema.getTypeOf(flag),Integer.TYPE);
    }
}
