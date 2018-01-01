package com.xie.java.api.bo;

import java.util.List;

/**
 * Created by xieyang on 17/11/14.
 */
public class ComposeBo {

    private String schoool;

    private List<ClassInfo> classInfoList;

    public String getSchoool() {
        return schoool;
    }

    public void setSchoool(String schoool) {
        this.schoool = schoool;
    }

    public List<ClassInfo> getClassInfoList() {
        return classInfoList;
    }

    public void setClassInfoList(List<ClassInfo> classInfoList) {
        this.classInfoList = classInfoList;
    }

    public static class ClassInfo{
        private String name;
        private int age;
        private int level;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
