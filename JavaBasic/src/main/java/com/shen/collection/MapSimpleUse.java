package com.shen.collection;

import java.util.HashMap;
import java.util.Map;

/*20191231*/
public class MapSimpleUse {
    public static void main(String[] args) {
        // map 键值对，包括键值、值
        // 可以通过键值快速找到对应的值
        // 示例：
            // 001 -> { name: 张三, age: 20}
            // 002 -> { name: 李四, age: 21}
        // 特性：
            // 1、键值不能重复
            // 2、put 方法如果键值已经存在，那么就会使用新值替换旧值，并且返回旧值
            // 3、键值可以是null吗？ 可以
            // 4、值可以是null吗？  可以
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三, 19");
        map.put(2, "李四, 21");
        map.put(3, "王五, 23");
        map.put(null, "没有人");
        map.put(null, "没有人2");
        map.put(null, null);

        System.out.println("返回旧值："+map.put(2, "孙健, 32"));

        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

    }
}
