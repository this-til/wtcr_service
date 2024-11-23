package com.til.wtcr_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.til.wtcr_service.pojo.Users;
import com.til.wtcr_service.service.UsersService;
import com.til.wtcr_service.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author til
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-11-23 17:35:52
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




