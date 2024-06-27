/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.service;

import cn.pht.NotFoundException;
import cn.pht.dao.FriendLinkRepository;
import cn.pht.po.FriendLink;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkRepository friendLinkRepository;

    @Override
    public List<FriendLink> getAll() {
        return friendLinkRepository.findAll();
    }

    @Override
    public Page<FriendLink> listFriendlink(Pageable pageable) {
        return friendLinkRepository.findAll(pageable);
    }

    @Override
    public Object getFriendLink(Long id) {
        return friendLinkRepository.findOne(id);
    }

    @Override
    public FriendLink getFriendLinkByName(String name) {
        return friendLinkRepository.findByName(name);
    }

    @Override
    public FriendLink saveFriendLink(FriendLink link) {
        return friendLinkRepository.save(link);
    }

    @Override
    public FriendLink updateFriendLink(Long id, FriendLink link) {
        FriendLink l = friendLinkRepository.findOne(id);
        if (l == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(link, l);
        return friendLinkRepository.save(l);
    }

    @Override
    public void deleteFrienLink(Long id) {
        friendLinkRepository.delete(id);
    }


}
