package com.til.wtcr_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.til.wtcr_service.pojo.Article;
import com.til.wtcr_service.service.ArticleService;
import com.til.wtcr_service.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author til
* @description 针对表【article】的数据库操作Service实现
* @createDate 2024-11-25 16:14:51
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




