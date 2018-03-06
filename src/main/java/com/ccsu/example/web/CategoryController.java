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
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by mutoulazy on 2018/3/1.
 */
@Controller
public class CategoryController {
    @Autowired
    private JpaCategoryDao jpaCategoryDao;

    @GetMapping("/category")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
//      设置倒序
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size ,sort);
        Page<JpaCategory> pageList = jpaCategoryDao.findAll(pageable);
        m.addAttribute("pageList", pageList);
        return "listCategory";
    }

    @PutMapping("/category")
    public String addCategory(@RequestBody JpaCategory c)throws Exception{
        jpaCategoryDao.save(c);
        return "redirect:/category";
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(JpaCategory c)throws Exception{
        jpaCategoryDao.delete(c);
        return "redirect:/category";
    }

    @PostMapping("/category/{id}")
    public String updateCategory(JpaCategory c)throws Exception{
        jpaCategoryDao.save(c);
        return "redirect:/category";
    }

    @GetMapping("/category/{id}")
    public String editCategory(@PathVariable("id") int id, Model m)throws Exception{
        JpaCategory category = jpaCategoryDao.getOne(id);
        m.addAttribute("category", category);
        return "editCategory";
    }

    /**
     * 支持json
     * addJpaCategory
     * @param c
     * @return
     * @throws Exception
     */
    @PutMapping("/categoryJson")
    public void addJpaCategory(@RequestBody JpaCategory c)throws Exception{
        jpaCategoryDao.save(c);
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+c.toString());
    }

    /**
     * getOneJpaCategory
     * 支持json
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/categoryJson/{id}")
    public JpaCategory getOneJpaCategory(@PathVariable("id") int id) throws Exception{
        JpaCategory c = jpaCategoryDao.getOne(id);
        System.out.println("getOne: " + c.toString());
        return c;
    }

    /**
     * getManyJpaCategory
     * 支持json
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/categoryJsonList")
    public List<JpaCategory> getManyJpaCategory(@RequestParam(value = "start", defaultValue = "0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
//      设置倒序
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size ,sort);
        Page<JpaCategory> pageList = jpaCategoryDao.findAll(pageable);
        return pageList.getContent();
    }
}
