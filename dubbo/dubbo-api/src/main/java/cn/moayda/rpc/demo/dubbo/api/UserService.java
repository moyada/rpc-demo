package cn.moayda.rpc.demo.dubbo.api;

import java.util.List;

public interface UserService {

    void save(UserInfo userInfo);

    UserInfo getById(Integer userId);

    List<UserInfo> queryAll();

    List<UserInfo> queryByIds(List<Integer> ids);
}
