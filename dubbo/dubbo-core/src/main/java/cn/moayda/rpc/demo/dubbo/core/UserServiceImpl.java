package cn.moayda.rpc.demo.dubbo.core;

import cn.moayda.rpc.demo.dubbo.api.UserInfo;
import cn.moayda.rpc.demo.dubbo.api.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("init user service");
    }

    @Override
    public void save(UserInfo userInfo) {
        System.out.println(userInfo.toString());
    }

    @Override
    public UserInfo getById(Integer userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setNikeName("test" + userId);
        userInfo.setPhone("+86 " + System.currentTimeMillis());
        userInfo.setAge(userId + 5);
        userInfo.setGender(true);
        return userInfo;
    }

    @Override
    public List<UserInfo> queryAll() {
        List<UserInfo> list = new ArrayList<>(5);
        int id = 1;
        list.add(getById(id++));
        list.add(getById(id++));
        list.add(getById(id++));
        list.add(getById(id++));
        list.add(getById(id));
        return list;
    }

    @Override
    public List<UserInfo> queryByIds(List<Integer> ids) {
        List<UserInfo> list = new ArrayList<>(ids.size());
        for (Integer id : ids) {
            list.add(getById(id));
        }
        return list;
    }
}
