package com.yourcom.proname.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yourcom.proname.repository.entity.bizDb.User;
import com.yourcom.proname.repository.service.IUserService;
import com.yourcom.proname.vo.CommonResVo;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class UserController {
    @Resource
    IUserService userService;

    /**
     * 新增用户
     *
     * @param jsonObject
     * @return
     */
    @PostMapping("/user/add")
    public CommonResVo<Boolean> addUser(@RequestBody JSONObject jsonObject) {
        User user = new User();
        user.setName(jsonObject.getString("name"));
        String pwd = jsonObject.getString("passwd");
        user.setPasswd(DigestUtils.md5DigestAsHex(pwd.getBytes()).toLowerCase());
        Boolean res = userService.save(user);
        return CommonResVo.success(res);
    }

    /**
     * 根据名字获取用户
     *
     * @param name
     * @return
     */
    @GetMapping("user/{name}")
    public CommonResVo<User> getUserByName(@PathVariable String name) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getName, name));
        return CommonResVo.success(user);
    }
}
