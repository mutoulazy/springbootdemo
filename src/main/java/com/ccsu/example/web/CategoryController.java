package com.ccsu.example.web;

import com.ccsu.example.dao.JpaCategoryDao;
import com.ccsu.example.mapper.CategoryMapper;
import com.ccsu.example.vo.JpaCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by mutoulazy on 2018/3/1.
 */
@Controller
public class CategoryController {
    @Autowired
    private JpaCategoryDao jpaCategoryDao;

    @RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
//      设置倒序
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size ,sort);
        Page<JpaCategory> pageList = jpaCategoryDao.findAll(pageable);
        m.addAttribute("pageList", pageList);
        return "listCategory";
    }

    @RequestMapping("/addCategory")
    public String addCategory(JpaCategory c)throws Exception{
        jpaCategoryDao.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(JpaCategory c)throws Exception{
        jpaCategoryDao.delete(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(JpaCategory c)throws Exception{
        jpaCategoryDao.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(int id, Model m)throws Exception{
        JpaCategory category = jpaCategoryDao.getOne(id);
        m.addAttribute("category", category);
        return "editCategory";
    }
}
