/*
 * 版权所有 (c) 2021. 写Bug的小杜 <https://github.com/shaoxiongdu>  保留所有权利
 */

package cn.pht.web;

import cn.pht.service.SkillService;
import cn.pht.service.WebsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by limi on 2017/10/24.
 */
@Controller
public class AboutShowController {

    @Autowired
    private WebsiteInfoService websiteInfoService;

    @Autowired
    private SkillService skillService;

    @GetMapping("/about")
    public String about(HttpSession session) {
        session.setAttribute("skillList",skillService.getAll());
        session.setAttribute("aboutMeImageUrl",websiteInfoService.getAboutMeImageUrl());
        session.setAttribute("aboutMeContent",websiteInfoService.getAboutMeContent());
        return "about";
    }
}
