package com.til.wtcr_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.til.wtcr_service.pojo.User;
import com.til.wtcr_service.service.UserService;
import com.til.wtcr_service.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author til
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-23 17:57:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




