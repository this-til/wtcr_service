package com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName article_node
 */
@TableName(value ="article_node")
@Data
public class ArticleNode implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "article_id")
    private Integer articleId;

    /**
     * lock at ArticlesNodeState
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 上一个版本
     */
    @TableField(value = "previous_version_id")
    private Integer previousVersionId;

    /**
     * 下一个版本
     */
    @TableField(value = "next_version_id")
    private Integer nextVersionId;

    /**
     * 上传时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 封面图标
     */
    @TableField(value = "cover_image_url")
    private String coverImageUrl;

    /**
     * 正文内容
     */
    @TableField(value = "content")
    private String content;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}