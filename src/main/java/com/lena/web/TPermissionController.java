package com.lena.web;


import com.lena.entity.TPermission;
import com.lena.pojo.TreeNode;
import com.lena.pojo.TreeNodeBulder;
import com.lena.service.ITPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lena
 * @since 2019-03-16
 */
@Controller
@RequestMapping("/permission")
public class TPermissionController {
    @Autowired
    private ITPermissionService itPermissionService;

    @RequestMapping("/loadIndexTreeMeuns")
    @ResponseBody
    public List<TreeNode> loadIndexTreeMeuns(TPermission tPermission, HttpSession session){

        List<TreeNode> nodes=new ArrayList<>();
        List<TPermission> permissions=itPermissionService.selectList(null);
        System.out.println(permissions);
        for (TPermission p:permissions) {
            boolean spread=p.getSpread()==1?true:false;

            nodes.add(new TreeNode(p.getId(),p.getPid(),p.getName(),p.getUrl(),p.getIcon(),spread));
        }
        System.out.println(nodes);
        return TreeNodeBulder.build(nodes,1);
    }



}

