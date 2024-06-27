/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.service;

import cn.pht.po.User;


public interface UserService {

    User checkUser(String username, String password);

    void insertUser(User user);
}
