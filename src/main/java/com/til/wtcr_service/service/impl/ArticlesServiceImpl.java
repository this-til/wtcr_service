package com.til.wtcr_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.til.wtcr_service.pojo.Articles;
import com.til.wtcr_service.service.ArticlesService;
import com.til.wtcr_service.mapper.ArticlesMapper;
import org.springframework.stereotype.Service;

/**
* @author til
* @description 针对表【articles】的数据库操作Service实现
* @createDate 2024-11-25 14:06:13
*/
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles>
    implements ArticlesService{

}




