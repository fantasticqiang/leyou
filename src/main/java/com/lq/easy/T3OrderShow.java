package com.lq.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lq on 2020/4/29.
 */
public class T3OrderShow {

    public static void main(String[] args) {
        ArrayList<List<String>> orders = new ArrayList<>();
        String[] order1 = {"David","3","Ceviche"};
        String[] order2 = {"Corina","10","Beef Burrito"};
        String[] order3 = {"David","3","Fried Chicken"};
        String[] order4 = {"Carla","5","Water"};
        String[] order5 = {"Carla","5","Ceviche"};
        String[] order6 = {"Rous","3","Ceviche"};
        orders.add(Arrays.asList(order1));
        orders.add(Arrays.asList(order2));
        orders.add(Arrays.asList(order3));
        orders.add(Arrays.asList(order4));
        orders.add(Arrays.asList(order5));
        orders.add(Arrays.asList(order6));
        List<List<String>> result = displayTable(orders);
        for (List<String> item : result) {
            System.out.println(String.join(",", item));
        }
    }

    /**
     * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。

     请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。

     注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。

     输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
     输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]

     Table,Beef Burrito,Ceviche,Fried Chicken,Water
     3    ,0           ,2      ,1            ,0
     5    ,0           ,1      ,0            ,1
     10   ,1           ,0      ,0            ,0
     对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
     而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
     餐桌 10：Corina 点了 "Beef Burrito"

     * @param orders
     * @return
     */
    public static List<List<String>> displayTable(List<List<String>> orders) {
        ArrayList<List<String>> result = new ArrayList<>();
        HashMap<String, TreeMap<String, String>> twoLevelMap = new HashMap<>();

        TreeSet<String> foodsSet = new TreeSet<>();

        for(List<String> order : orders) {
            String tableNum = order.get(1);
            String foodName = order.get(2);
            if(!foodsSet.contains(foodName)) {
                foodsSet.add(foodName);
            }
            if(!twoLevelMap.containsKey(tableNum)) {
                twoLevelMap.put(tableNum, new TreeMap<>());
            }
            TreeMap<String, String> treeMap = twoLevelMap.get(tableNum);
            if(!treeMap.containsKey(foodName)) {
                treeMap.put(foodName, "1");
            } else {
                String num = treeMap.get(foodName);
                treeMap.put(foodName, String.valueOf(Integer.parseInt(num) + 1));
            }
        }
        //表头
        ArrayList<String> tableName = new ArrayList<>();
        tableName.add("Table");
        tableName.addAll(foodsSet);
        result.add(tableName);
        // table num quantity
        List<List<String>> tableBody = new ArrayList<>();
        List<String> tableItem;
        for(Map.Entry<String, TreeMap<String, String>> entry : twoLevelMap.entrySet()) {
            tableItem = new ArrayList<>();
            tableItem.add(entry.getKey()); // key是几号桌
            TreeMap<String, String> treeMap = entry.getValue();
            Set<String> tableFoodSet = treeMap.keySet();
            for(String fooName : foodsSet) {
                if(tableFoodSet.contains(fooName)) {
                    tableItem.add(treeMap.get(fooName));
                } else {
                    tableItem.add("0");
                }
            }
            tableBody.add(tableItem);
        }
        List<List<String>> collect = tableBody.stream().sorted(Comparator.comparing(x -> Integer.parseInt(x.get(0)))).collect(Collectors.toList());
        result.addAll(collect);
        return result;
    }
}
