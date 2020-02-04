package com.yourcom.proname.repository.service.impl;

import com.yourcom.proname.repository.entity.bizDb.User;
import com.yourcom.proname.repository.mapper.bizDb.UserMapper;
import com.yourcom.proname.repository.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dothetrick
 * @since 2020-01-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
