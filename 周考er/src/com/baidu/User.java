package com.baidu;

/**
 * 在一个标准的实体对象中，<br>
 * 1. 先定义字段， <br>
 * 2. 定义构造方法（非必须的） <br>
 * 3. 定义重写的equals，hashCode，compareTo的方法（非必须的）<br>
 * 4. 定义set，get方法，<br>
 * 5. 定义toString方法<br>
 * 
 * @author songyz
 * @createTime 2019-09-09 17:09:25
 */
public class User implements Comparable<User> {
    private String name;
    private int age;
    private char sex;

    public User(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(User o) {
        // TODO Auto-generated method stub
        return this.age - o.age;
    }

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }

}
