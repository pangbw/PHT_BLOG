/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.dao;

import cn.pht.po.FriendLink;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FriendLinkRepository extends JpaRepository<FriendLink,Long> {

    FriendLink findByName(String name);
}
