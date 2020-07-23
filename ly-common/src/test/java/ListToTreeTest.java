import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListToTreeTest {

    public static void main(String[] args) throws Exception {
        List<Item> list = getList();
        ArrayList<LinkedHashMap<String, Object>> tree = new ArrayList<>();
        loadTree(list, tree, 0l);
        String s = new ObjectMapper().writeValueAsString(tree);
        System.out.println(s);
    }

    public static void loadTree(List<Item> list, List<LinkedHashMap<String, Object>> listTreeNode, Long pid) {
        LinkedHashMap<String, Object> tmpMap = null;
        List<Item> tmpList = list.stream().filter(x -> x.getPid() == pid).collect(Collectors.toList());
        for(Item item : tmpList) {
            tmpMap = new LinkedHashMap<>();
            tmpMap.put("id", item.getId());
            tmpMap.put("name", item.getName());
            tmpMap.put("children", new ArrayList<LinkedHashMap<String,Object>>());
            listTreeNode.add(tmpMap);
            loadTree(list, (List<LinkedHashMap<String, Object>>) tmpMap.get("children"), (Long) tmpMap.get("id"));
        }
    }

    public static List<Item> getList() {
        Item parent1 = new Item();
        parent1.setId(1l);
        parent1.setName("女装");
        parent1.setPid(0l);

        Item parent2 = new Item();
        parent2.setId(2l);
        parent2.setName("男装");
        parent2.setPid(0l);

        Item parent3 = new Item();
        parent3.setId(3l);
        parent3.setName("女士裙装");
        parent3.setPid(1l);

        Item parent4 = new Item();
        parent4.setId(4l);
        parent4.setName("女士上装");
        parent4.setPid(1l);

        Item parent5 = new Item();
        parent5.setId(5l);
        parent5.setName("背带裙");
        parent5.setPid(3l);

        Item parent6 = new Item();
        parent6.setId(6l);
        parent6.setName("羊毛衫");
        parent6.setPid(4l);

        ArrayList<Item> items = new ArrayList<>();
        items.add(parent1);
        items.add(parent2);
        items.add(parent3);
        items.add(parent4);
        items.add(parent5);
        items.add(parent6);
        return items;
    }
}

class Item {
    private Long id;

    private String name;

    private Long pid;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
}

