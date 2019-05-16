package com.svideo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svideo.domain.TbCategory;
import com.svideo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 后台分类列表
     *
     * @param session
     * @return
     */
    @RequestMapping("/Category")
    public String list(HttpSession session) {
        List<TbCategory> list = categoryService.getTbCateGorys();
        if (list != null) {
            session.setAttribute("list", list);
        }
        return "category";
    }

    /**
     * 获取分类列表
     *
     * @return
     */
    @RequestMapping("/CategoryList")
    @ResponseBody
    public List<TbCategory> getlist() {
        List<TbCategory> list = categoryService.getTbCateGorys();
        return list;
    }

    /**
     * 后台添加分类
     *
     * @param categoryName
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/categoryAdd")
    public String add(String categoryName, HttpSession session, HttpServletRequest request) {
        try {
            categoryService.saveTbCategory(categoryName);
            Thread.sleep(2000);
            return "category";
        } catch (Exception e) {
            request.setAttribute("error", "添加失败");
            e.printStackTrace();
            return "error";
        }

    }

    /**
     * 修改分类回显
     *
     * @param id
     * @return
     */
    @RequestMapping("/categoryUpdateUI")
    @ResponseBody
    public TbCategory UpdateUI(Long id) {
        TbCategory oneCategory = categoryService.findById(id);
        return oneCategory;
    }

    /**
     * 后台更新分类
     *
     * @param id
     * @param categoryName
     * @param request
     * @return
     */
    @RequestMapping("/categoryUpdate")
    public String Update(Long id, String categoryName, HttpServletRequest request) {
        //创建一个 分类实类
        TbCategory tbCategory = new TbCategory();
        tbCategory.setCategoryName(categoryName);
        tbCategory.setId(id);
        System.out.println(id);
        try {
            categoryService.updateTbCategory(tbCategory);
            return "Category";
        } catch (Exception e) {
//            request.setAttribute("error","更新失败，请检查后重新更新");
//            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 后台删除分类
     *
     * @param id
     * @return
     */
    @RequestMapping("/categoryDelete")
    public void delete(Long id, HttpServletResponse response) throws IOException {
        Map<String, Object> resultmap = new HashMap<>();
        if (id != null) {
            if (categoryService.delTbCateGory(id)) {
                resultmap.put("success", true);
                resultmap.put("result", "删除分类成功");
                response.setCharacterEncoding("utf-8");
                String jsonString = new ObjectMapper().writeValueAsString(resultmap);
                response.getWriter().print(jsonString);
            } else {
                resultmap.put("success", false);
                resultmap.put("result", "删除分类失败");
                response.setCharacterEncoding("utf-8");
                String jsonString = new ObjectMapper().writeValueAsString(resultmap);
                response.getWriter().print(jsonString);
            }
        }
    }
}
