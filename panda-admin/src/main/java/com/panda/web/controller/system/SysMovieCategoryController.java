package com.panda.web.controller.system;

import com.panda.common.response.ResponseResult;
import com.panda.system.domin.SysMovieCategory;
import com.panda.system.service.impl.SysMovieCategoryServiceImpl;
import com.panda.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SysMovieCategoryController extends BaseController {

    @Autowired
    private SysMovieCategoryServiceImpl sysMovieCategoryService;

    @GetMapping("/sysMovieCategory/find")
    public ResponseResult findAll(){
        startPage();
        List<SysMovieCategory> data = sysMovieCategoryService.findAll();
        return getResult(data);
    }

    @GetMapping("/sysMovieCategory/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return getResult(sysMovieCategoryService.findById(id));
    }

    @PostMapping("/sysMovieCategory")
    public ResponseResult add(@Validated @RequestBody SysMovieCategory sysMovieCategory){
        return getResult(sysMovieCategoryService.add(sysMovieCategory));
    }


    @PutMapping("/sysMovieCategory")
    public ResponseResult update(@Validated @RequestBody SysMovieCategory sysMovieCategory){
        return getResult(sysMovieCategoryService.update(sysMovieCategory));
    }

    @DeleteMapping("/sysMovieCategory/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        return getResult(sysMovieCategoryService.delete(ids));
    }
}
