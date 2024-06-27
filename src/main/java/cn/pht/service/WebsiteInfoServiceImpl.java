/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.service;

import cn.pht.dao.WebsiteInfoRepository;
import cn.pht.po.WebsiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteInfoServiceImpl implements WebsiteInfoService {

    @Autowired
    private WebsiteInfoRepository websiteInfoRepository;

    @Override
    public Long addOneForViews() {
        /*获取当前浏览量*/
        WebsiteInfo views = websiteInfoRepository.findByValueName("views");

        /*递增*/
        Long view = Long.parseLong(views.getValue());
        view++;
        views.setValue(view.toString());
        websiteInfoRepository.save(views);

        /*返回*/
        return view;
    }

    @Override
    public String getAboutMeImageUrl() {
        WebsiteInfo aboutMeImageUrl = websiteInfoRepository.findByValueName("aboutMeImageUrl");
        return aboutMeImageUrl.getValue();
    }

    @Override
    public String updateAboutMeImageUrl(String aboutMeImageUrl) {
        WebsiteInfo aboutMeImageUrl1 = websiteInfoRepository.findByValueName("aboutMeImageUrl");
        aboutMeImageUrl1.setValue(aboutMeImageUrl);
        websiteInfoRepository.save(aboutMeImageUrl1);
        return aboutMeImageUrl1.getValue();
    }

    @Override
    public String getTopTitle() {
        WebsiteInfo topTitle = websiteInfoRepository.findByValueName("topTitle");
        return topTitle.getValue();
    }

    @Override
    public String updateTopTitle(String topTitle) {
        WebsiteInfo topTitle1 = websiteInfoRepository.findByValueName("topTitle");
        topTitle1.setValue(topTitle);
        websiteInfoRepository.save(topTitle1);
        return topTitle1.getValue();
    }

    @Override
    public String getAboutMeContent() {
        return websiteInfoRepository.findByValueName("aboutMeContent").getValue();
    }
}
