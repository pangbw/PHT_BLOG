package cn.pht.web.admin;

import cn.pht.po.FriendLink;
import cn.pht.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by limi on 2017/10/16.
 */

@Controller
@RequestMapping("/admin")
public class FriendLinkController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friendLink")
    public String link(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC)
                       Pageable pageable, Model model) {
        model.addAttribute("page", friendLinkService.listFriendlink(pageable));
        return "admin/friendLink";
    }

    @GetMapping("/friendLink/input")
    public String input(Model model) {
        model.addAttribute("friendLink", new FriendLink());
        return "admin/friendLink-input";
    }

    @GetMapping("/friendLink/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        if (id != null) {
            model.addAttribute("friendLink", friendLinkService.getFriendLink(id));
        }
        return "admin/friendLink-input";
    }


    @PostMapping("/friendLink")
    public String post(@Valid FriendLink link, BindingResult result, RedirectAttributes attributes) {
        FriendLink link1 = friendLinkService.getFriendLinkByName(link.getName());
        if (link1 != null) {
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/friendLink-input";
        }
        FriendLink t = friendLinkService.saveFriendLink(link);
        if (t == null) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/friendLink";
    }


    @PostMapping("/friendLink/{id}")
    public String editPost(@Valid FriendLink link, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        FriendLink link1 = friendLinkService.getFriendLinkByName(link.getName());
        if (result.hasErrors()) {
            return "admin/friendLink-input";
        }
        FriendLink t = friendLinkService.updateFriendLink(id, link);
        if (t == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/friendLink";
    }

    @GetMapping("/friendLink/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        friendLinkService.deleteFrienLink(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/friendLink";
    }


}