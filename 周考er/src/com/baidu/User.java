package com.baidu;

/**
 * ��һ����׼��ʵ������У�<br>
 * 1. �ȶ����ֶΣ� <br>
 * 2. ���幹�췽�����Ǳ���ģ� <br>
 * 3. ������д��equals��hashCode��compareTo�ķ������Ǳ���ģ�<br>
 * 4. ����set��get������<br>
 * 5. ����toString����<br>
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
