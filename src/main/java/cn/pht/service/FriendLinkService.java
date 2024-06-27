/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.service;

import cn.pht.po.FriendLink;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FriendLinkService {

    /**
     * 获取所有友链记录
     *
     */
    public List<FriendLink> getAll();

    Object listFriendlink(Pageable pageable);

    Object getFriendLink(Long id);

    FriendLink getFriendLinkByName(String name);

    FriendLink saveFriendLink(FriendLink link);

    FriendLink updateFriendLink(Long id, FriendLink link);

    void deleteFrienLink(Long id);
}
