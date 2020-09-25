package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private List<FlagSchema> flagSchemaList = new ArrayList<>();

    public List<FlagSchema> getFlagSchemaList() {
        return flagSchemaList;
    }




    public Args(String argsText) throws Exception {
        // 命令代码
        this.argsText = argsText;
        // 拆分后的schema
        this.flagSchemaList = inputArgsParse(argsText);
    }

    public List<FlagSchema> inputArgsParse(String args) throws Exception {
        checkFlagsNoSpace(args);
        List<String> argsList =this.splitArgs(args);
        for(String arg: argsList ){
            FlagSchema flagSchema = getflagSchema(arg);
            checkRepeatFlag(flagSchemaList,flagSchema);
            flagSchemaList.add(flagSchema);
        }
        return flagSchemaList;
    }

    private FlagSchema getflagSchema(String arg) throws Exception {
        try {
            FlagSchema flagSchema = SchemaFactory.create(Arrays.asList(arg.split(" ")).get(0));
            return new FlagSchema((String) Arrays.asList(arg.split(" ")).get(0).trim(),Arrays.asList(arg.split(" ")).get(1),flagSchema.getValueType());
        }catch (Exception e){
            FlagSchema flagSchema = SchemaFactory.create(arg.trim());
            return new FlagSchema(arg.trim(),flagSchema.getDefaultValue(),flagSchema.getValueType());
        }
    }

    private void checkRepeatFlag(List<FlagSchema> flagSchemaList, FlagSchema flagSchema) throws Exception {
        for (FlagSchema flagSchema1:flagSchemaList){
            checkFlag(flagSchema1,flagSchema);
        }
    }
    private void checkFlag(FlagSchema flagSchema1,FlagSchema flagSchema) throws Exception {
        if(flagSchema1.getFlag().equals(flagSchema.getFlag())){
            throw new Exception("不允许输入重复flag");
        }
    }

    private List<String> splitArgs( String args){
        return  Arrays.stream(args.split("-"))
                .filter(p->p.length()!=0)
                .collect(Collectors.toList());
    }

    private void checkFlagsNoSpace( String args) throws Exception {
        if(args.contains("-l-")||args.contains("-d-")||args.contains("-p-")){
            throw new Exception("参数之间不用空格分割视为非法");
        };
    }

    // 解析出命令
    public List<Arg> scan(String argsText) {
        // 根据flag划分
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        //
        keyValues = keyValues.stream()
                .map(String::trim)
                .collect(Collectors.toList());

        keyValues = keyValues.subList(1,keyValues.size());
        List<Arg> keyValuePairs = new ArrayList<>();
        keyValues.forEach(
                keyValue -> {
                    String[] splitKeyValue = keyValue.split(" ");
                    String key = splitKeyValue[0];
                    String value = splitKeyValue[1];
                    keyValuePairs.add(new Arg(key,value));
        });

        return keyValuePairs;
    }




    public List<String> scan2() {
        List<String> keyValues = Arrays.asList(" ".concat(argsText).split("-"));

        return keyValues.subList(1,keyValues.size());
    }
}
