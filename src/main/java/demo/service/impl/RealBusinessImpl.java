package demo.service.impl;

import demo.service.BusinessInterface;

import java.util.Iterator;
import java.util.ServiceLoader;

public class RealBusinessImpl implements BusinessInterface {
    public void dosomething(String username) {
        System.out.println("正在为用户：" + username + "，进行真实的业务处理。。。");
    }

    public static void main(String[] args) {
        ServiceLoader<BusinessInterface> interf = ServiceLoader.load(BusinessInterface.class);

    }
}
