package com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.extension.handlers.GsonTypeHandler;
import com.til.wtcr_service.eumn.ArticleType;
import com.til.wtcr_service.eumn.ArticleVisibility;
import lombok.Data;

/**
 * @TableName article
 */
@TableName(value = "article")
@Data
public class Article implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应发布作者的id
     */
    @TableField(value = "author_id")
    private Integer authorId;

    /**
     * 所有能够编辑者的id
     */
    @TableField(value = "editors_id", typeHandler = GsonTypeHandler.class)
    private Integer[] editorsId;

    /**
     * 类别
     */
    @TableField(value = "type")
    private ArticleType type;

    /**
     * lock at ArticlesVisibility
     */
    @TableField(value = "visibility")
    private ArticleVisibility visibility;

    /**
     *
     */
    @TableField(value = "custom_tags")
    private String customTags;

    /**
     *
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 发布时间
     */
    @TableField(value = "publish_date")
    private LocalDateTime publishDate;

    /**
     * 最后更新时间
     */
    @TableField(value = "update_date")
    private LocalDateTime updateDate;

    /**
     * 浏览次数
     */
    @TableField(value = "view_count")
    private Integer viewCount;

    /**
     * 评论数
     */
    @TableField(value = "comment_count")
    private Integer commentCount;

    /**
     * 喜欢计数
     */
    @TableField(value = "like_count")
    private Integer likeCount;

    /**
     * 不喜欢计数
     */
    @TableField(value = "dislike_count")
    private Integer dislikeCount;

    /**
     * 分享计数
     */
    @TableField(value = "share_count")
    private Integer shareCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}