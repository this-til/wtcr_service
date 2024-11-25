package java.com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName articles
 */
@TableName(value ="articles")
@Data
public class Articles implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 历史版本
     */
    @TableField(value = "basics")
    private Integer basics;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 正文内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 摘要
     */
    @TableField(value = "summary")
    private String summary;

    /**
     * 对应发布作者的id
     */
    @TableField(value = "author_id")
    private Integer author_id;

    /**
     * 所有能够编辑者的id
     */
    @TableField(value = "editors_id")
    private String editors_id;

    /**
     * 类别
     */
    @TableField(value = "category")
    private String category;

    /**
     * 
     */
    @TableField(value = "cover_image_url")
    private String cover_image_url;

    /**
     * 发布时间
     */
    @TableField(value = "publish_date")
    private LocalDateTime publish_date;

    /**
     * 最后更新时间
     */
    @TableField(value = "update_date")
    private LocalDateTime update_date;

    /**
     * 浏览次数
     */
    @TableField(value = "view_count")
    private Integer view_count;

    /**
     * 评论数
     */
    @TableField(value = "comment_count")
    private Integer comment_count;

    /**
     * 喜欢计数
     */
    @TableField(value = "like_count")
    private Integer like_count;

    /**
     * 不喜欢计数
     */
    @TableField(value = "dislike_count")
    private Integer dislike_count;

    /**
     * 分享计数
     */
    @TableField(value = "share_count")
    private Integer share_count;

    /**
     * lock at ArticlesTag
     */
    @TableField(value = "tags")
    private Integer tags;

    /**
     * 
     */
    @TableField(value = "customTags")
    private String customTags;

    /**
     * lock at ArticlesState
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * lock at ArticlesVisibility
     */
    @TableField(value = "visibility")
    private Integer visibility;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Articles other = (Articles) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBasics() == null ? other.getBasics() == null : this.getBasics().equals(other.getBasics()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getAuthor_id() == null ? other.getAuthor_id() == null : this.getAuthor_id().equals(other.getAuthor_id()))
            && (this.getEditors_id() == null ? other.getEditors_id() == null : this.getEditors_id().equals(other.getEditors_id()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getCover_image_url() == null ? other.getCover_image_url() == null : this.getCover_image_url().equals(other.getCover_image_url()))
            && (this.getPublish_date() == null ? other.getPublish_date() == null : this.getPublish_date().equals(other.getPublish_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()))
            && (this.getView_count() == null ? other.getView_count() == null : this.getView_count().equals(other.getView_count()))
            && (this.getComment_count() == null ? other.getComment_count() == null : this.getComment_count().equals(other.getComment_count()))
            && (this.getLike_count() == null ? other.getLike_count() == null : this.getLike_count().equals(other.getLike_count()))
            && (this.getDislike_count() == null ? other.getDislike_count() == null : this.getDislike_count().equals(other.getDislike_count()))
            && (this.getShare_count() == null ? other.getShare_count() == null : this.getShare_count().equals(other.getShare_count()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getCustomTags() == null ? other.getCustomTags() == null : this.getCustomTags().equals(other.getCustomTags()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVisibility() == null ? other.getVisibility() == null : this.getVisibility().equals(other.getVisibility()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBasics() == null) ? 0 : getBasics().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getAuthor_id() == null) ? 0 : getAuthor_id().hashCode());
        result = prime * result + ((getEditors_id() == null) ? 0 : getEditors_id().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getCover_image_url() == null) ? 0 : getCover_image_url().hashCode());
        result = prime * result + ((getPublish_date() == null) ? 0 : getPublish_date().hashCode());
        result = prime * result + ((getUpdate_date() == null) ? 0 : getUpdate_date().hashCode());
        result = prime * result + ((getView_count() == null) ? 0 : getView_count().hashCode());
        result = prime * result + ((getComment_count() == null) ? 0 : getComment_count().hashCode());
        result = prime * result + ((getLike_count() == null) ? 0 : getLike_count().hashCode());
        result = prime * result + ((getDislike_count() == null) ? 0 : getDislike_count().hashCode());
        result = prime * result + ((getShare_count() == null) ? 0 : getShare_count().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getCustomTags() == null) ? 0 : getCustomTags().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVisibility() == null) ? 0 : getVisibility().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", basics=").append(basics);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", summary=").append(summary);
        sb.append(", author_id=").append(author_id);
        sb.append(", editors_id=").append(editors_id);
        sb.append(", category=").append(category);
        sb.append(", cover_image_url=").append(cover_image_url);
        sb.append(", publish_date=").append(publish_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", view_count=").append(view_count);
        sb.append(", comment_count=").append(comment_count);
        sb.append(", like_count=").append(like_count);
        sb.append(", dislike_count=").append(dislike_count);
        sb.append(", share_count=").append(share_count);
        sb.append(", tags=").append(tags);
        sb.append(", customTags=").append(customTags);
        sb.append(", status=").append(status);
        sb.append(", visibility=").append(visibility);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}