package com.lanxuewei.leet_code.other;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lanxuewei create in 2020/6/19 11:42
 * description: 统计各部门人数
 */
@Slf4j
public class TreeSort {

    private static List<Department> result = new ArrayList<>();
    private static List<Department> data = getData();

    @Data
    @Accessors(chain = true)
    static class Department {
        /** 上一级部门 */
        private Department pre;
        /** 部门名 */
        private String name;
        /** 人数 */
        private Integer count = 0;
    }

    /**
     *              A[10]
     *        B[3]         C[7]
     *     D[1]  E[2]   F[3]  G[4]
     */
    public static List<Department> getData() {
        Department a = new Department().setName("A").setPre(null);

        Department b = new Department().setName("B").setPre(a);
        Department c = new Department().setName("C").setPre(a);

        Department d = new Department().setName("D").setPre(b).setCount(1);
        Department e = new Department().setName("E").setPre(b).setCount(2);
        Department f = new Department().setName("F").setPre(c).setCount(3);
        Department g = new Department().setName("G").setPre(c).setCount(4);

        List<Department> departments = new ArrayList<>();
        departments.add(a);
        departments.add(b);
        departments.add(c);
        departments.add(d);
        departments.add(e);
        departments.add(f);
        departments.add(g);

        return departments;
    }

    public static List<Department> count() {
        List<Department> data = getData();

        data.stream().forEach(entry -> {
            Department pre = entry.getPre();
            while (pre != null) {
                pre.setCount(entry.getCount() + pre.getCount());
                pre = pre.getPre();
            }
        });

        return data;
    }

    /**
     * description: 获取孩子节点，分组可以只需一次，为了方便没有抽离
     * @return 当前节点所拥有的孩子节点集
     * @author lanxuewei 2020/6/19 15:07
     */
    public static List<Department> getChildren(List<Department> dataList, Department parent) {
        Map<String, List<Department>> preNameMap = dataList.stream()
                .collect(Collectors.groupingBy(entry -> {
                    Department pre = entry.getPre();
                    return pre != null ? pre.getName() : "null";
        }));
        return preNameMap.getOrDefault(parent.getName(), new ArrayList<>());
    }

    /**
     * description: 采用后序遍历方式
     * @return 按后序遍历方式采集每个部门人数
     * @author lanxuewei 2020/6/19 15:07
     */
    public static List<Department> postOrder(Department root) {
        if (root == null) {
            return result;
        }
        List<Department> children = getChildren(data, root);
        if (children.size() > 0) {
            for (Department ch : children) {
                postOrder(ch);
                root.setCount(root.getCount() + ch.getCount());
            }
        }
        result.add(root);

        return result;
    }

    public static void testCount() {
        List<Department> data = count();
        data.stream().forEach(entry -> {
            Department pre = entry.getPre();
            String preName = pre != null ? pre.getName() : null;
            log.info(">>>> name = {}, preName = {}, count = {} <<<<", entry.getName(), preName, entry.getCount());
        });
    }

    public static void testCount_v1() {
        data.stream().filter(entry -> (entry.getPre() == null)).findFirst()
                .ifPresent(entry -> {
                    List<Department> departments = postOrder(entry);
                    departments.stream().forEach(item -> {
                        Department pre = item.getPre();
                        String preName = pre != null ? pre.getName() : null;
                        log.info(">>>> name = {}, preName = {}, count = {} <<<<", item.getName(), preName, item.getCount());
            });
        });
    }

    public static void main(String[] args) {
//        testCount();
        testCount_v1();
    }
}
