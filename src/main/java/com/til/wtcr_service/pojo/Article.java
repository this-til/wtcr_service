package com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.til.wtcr_service.eumn.ArticleState;
import com.til.wtcr_service.eumn.ArticleVisibility;
import lombok.Data;

/**
 * 
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 所有能够编辑者的id {aId}.{b.Id}
     */
    @TableField(value = "editors")
    private String editors;

    /**
     * 类别
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * lock at ArticleState
     */
    @TableField(value = "state")
    private ArticleState state;

    /**
     * lock at ArticleVisibility
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
    @TableField(value = "publish_time")
    private LocalDateTime publishTime;

    /**
     * 最后更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

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