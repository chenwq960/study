package com.baidu.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.dto.User;

public final class BaiduUtil {

    private BaiduUtil() {
    }

    private static final String APP_ID = "18154900";
    private static final String API_KEY = "jOmIBfUZwostrczFdrENmLVR";
    private static final String SECRET_KEY = "vf9ZoHlsVDFQ7Qmfim49Pc7HgNN6Omhj";

    public static class IdCardFront {
        private String name;
        private String nation;
        private String address;
        private String idCard;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "IdCardFront [name=" + name + ", nation=" + nation + ", address=" + address + ", idCard=" + idCard
                    + ", sex=" + sex + "]";
        }
    }

    // 设置APPID/AK/SK
    // 初始化一个AipOcr
    private static final AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    static {
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    @SuppressWarnings("unchecked")
    public static IdCardFront getIdCardFrontInfo(String path) {
        JSONObject jsonObj = client.idcard(path, "front", new HashMap<>());
        String json = jsonObj.toString();

        Map<String, Object> jsonMap = JSON.parseObject(json, new TypeReference<Map<String, Object>>() {
        });

        Map<Object, Object> result = (Map<Object, Object>) jsonMap.get("words_result");

        IdCardFront idCardFront = new IdCardFront();
        idCardFront.setName(((Map<String, String>) result.get("姓名")).get("words").toString());
        idCardFront.setNation(((Map<String, Object>) result.get("民族")).get("words").toString());
        idCardFront.setAddress(((Map<String, Object>) result.get("住址")).get("words").toString());
        idCardFront.setIdCard(((Map<String, Object>) result.get("公民身份号码")).get("words").toString());
        idCardFront.setSex(((Map<String, Object>) result.get("性别")).get("words").toString());
        return idCardFront;
    }

    public static void seachPhoto(String path, User user, HttpSession session) {
        String url = "C:\\Users\\Administrator\\Desktop\\timg.jfif";
        IdCardFront idCardFrontInfo = getIdCardFrontInfo(url);
        System.out.println(idCardFrontInfo.name);
        user.setRealName(idCardFrontInfo.name);
        user.setNation(idCardFrontInfo.nation);
        user.setAddress(idCardFrontInfo.address);
        user.setIdCard(idCardFrontInfo.idCard);
        user.setSex(idCardFrontInfo.sex == "男" ? 1 : 2);
        user.setBirthday(new Date());
        user.setCreateTime(new Date());
        User attribute = (User) session.getAttribute("currentUser");
        user.setCreateUser(attribute.getUserId());
        user.setUpdateUser(attribute.getUserId());
        user.setRoleId(attribute.getUserId());
        user.setDepartmentId(attribute.getUserId());
        System.out.println("----------------------");
        user.setUpdateTime(new Date());

        // user.setCreateUser(session.getAttribute(name));

        System.out.println("user对象" + user);

    }

}
