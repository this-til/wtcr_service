package com.til.wtcr_service.pojo.filter;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.til.wtcr_service.eumn.ArticleState;
import com.til.wtcr_service.eumn.ArticleType;
import com.til.wtcr_service.eumn.ArticleVisibility;
import com.til.wtcr_service.eumn.sort.ArticleNodeSortModel;
import com.til.wtcr_service.eumn.sort.ArticleSortModel;
import com.til.wtcr_service.pojo.Article;
import com.til.wtcr_service.pojo.PageModel;
import com.til.wtcr_service.pojo.User;
import com.til.wtcr_service.pojo.data.IntRanger;
import com.til.wtcr_service.pojo.data.TimeRanger;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleFilter {
    private PageModel pageModel;
    @Nullable
    private ArticleSortModel articleSortModel;
    @Nullable
    private Boolean asc;

    // 精准描述查找哪一个文章从id
    @Nullable
    private Integer id;

    // 表明必须是author所写的文章
    @Nullable
    private List<Integer> userId;

    // 表明是editor能够编辑的文章 TODO
    @Nullable
    private List<Integer> editorId;

    @Nullable
    private List<ArticleType> type;
    @Nullable
    private List<ArticleState> state;
    @Nullable
    private List<ArticleVisibility> visibility;

    @Nullable
    private TimeRanger createTimeRanger;
    @Nullable
    private TimeRanger publishTimeRanger;
    @Nullable
    private TimeRanger updateTimeRanger;

    @Nullable
    private IntRanger viewCountRanger;
    @Nullable
    private IntRanger commentCountRanger;
    @Nullable
    private IntRanger likeCountRanger;
    @Nullable
    private IntRanger dislikeCountRanger;
    @Nullable
    private IntRanger shareCountRanger;

    public Wrapper<Article> asWrapper() {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        if (getId() != null) {
            wrapper.eq(Article::getId, getId());
            return wrapper;
        }

        if (getUserId() != null && !getUserId().isEmpty()) {
            if (getUserId().size() == 1) {
                wrapper.eq(Article::getUserId, getUserId());
            } else {
                wrapper.in(Article::getUserId, getUserId());
            }
        }


        if (getEditorId() != null && !getEditorId().isEmpty()) {
            for(Integer i : getEditorId()) {
                wrapper.like(Article::getEditors, "," + i + ",");
            }
        }

        if (getType() != null && !getType().isEmpty()) {
            if (getType().size() == 1) {
                wrapper.eq(Article::getType, getType().getFirst());
            } else {
                wrapper.in(Article::getType, getType());
            }
        }

        if (getState() != null && !getState().isEmpty()) {
            if (getState().size() == 1) {
                wrapper.eq(Article::getState, getState().getFirst());
            } else {
                wrapper.in(Article::getState, getState());
            }
        }

        if (getVisibility() != null && !getVisibility().isEmpty()) {
            if (getVisibility().size() == 1) {
                wrapper.eq(Article::getVisibility, getVisibility().getFirst());
            } else {
                wrapper.in(Article::getVisibility, getVisibility());
            }
        }

        if (getCreateTimeRanger() != null) {
            LocalDateTime max = getCreateTimeRanger().getMax() == null ? LocalDateTime.now() : getCreateTimeRanger().getMax();
            LocalDateTime min = getCreateTimeRanger().getMin() == null ? LocalDateTime.MIN : getCreateTimeRanger().getMin();
            wrapper.gt(Article::getCreateTime, min).lt(Article::getCreateTime, max);
        }

        if (getPublishTimeRanger() != null) {
            LocalDateTime max = getPublishTimeRanger().getMax() == null ? LocalDateTime.now() : getPublishTimeRanger().getMax();
            LocalDateTime min = getPublishTimeRanger().getMin() == null ? LocalDateTime.MIN : getPublishTimeRanger().getMin();
            wrapper.gt(Article::getPublishTime, min).lt(Article::getPublishTime, max);
        }

        if (getUpdateTimeRanger() != null) {
            LocalDateTime max = getUpdateTimeRanger().getMax() == null ? LocalDateTime.now() : getUpdateTimeRanger().getMax();
            LocalDateTime min = getUpdateTimeRanger().getMin() == null ? LocalDateTime.MIN : getUpdateTimeRanger().getMin();
            wrapper.gt(Article::getUpdateTime, min).lt(Article::getUpdateTime, max);
        }

        if (getViewCountRanger() != null) {
            int min = getViewCountRanger().getMin() == null ? 0 : getViewCountRanger().getMin();
            int max = getViewCountRanger().getMax() == null ? Integer.MAX_VALUE : getViewCountRanger().getMax();
            wrapper.gt(Article::getViewCount, min).lt(Article::getViewCount, max);
        }

        if (getCommentCountRanger() != null) {
            int min = getCommentCountRanger().getMin() == null ? 0 : getCommentCountRanger().getMin();
            int max = getCommentCountRanger().getMax() == null ? Integer.MAX_VALUE : getCommentCountRanger().getMax();
            wrapper.gt(Article::getCommentCount, min).lt(Article::getCommentCount, max);
        }

        if (getLikeCountRanger() != null) {
            int min = getLikeCountRanger().getMin() == null ? 0 : getLikeCountRanger().getMin();
            int max = getLikeCountRanger().getMax() == null ? Integer.MAX_VALUE : getLikeCountRanger().getMax();
            wrapper.gt(Article::getLikeCount, min).lt(Article::getLikeCount, max);
        }

        if (getDislikeCountRanger() != null) {
            int min = getDislikeCountRanger().getMin() == null ? 0 : getDislikeCountRanger().getMin();
            int max = getDislikeCountRanger().getMax() == null ? Integer.MAX_VALUE : getDislikeCountRanger().getMax();
            wrapper.gt(Article::getDislikeCount, min).lt(Article::getDislikeCount, max);
        }

        if (getShareCountRanger() != null) {
            int min = getShareCountRanger().getMin() == null ? 0 : getShareCountRanger().getMin();
            int max = getShareCountRanger().getMax() == null ? Integer.MAX_VALUE : getShareCountRanger().getMax();
            wrapper.gt(Article::getShareCount, min).lt(Article::getShareCount, max);
        }

        if (getArticleSortModel() != null) {
            boolean asc = getAsc() != null ? getAsc() : false;
            switch (getArticleSortModel()) {
                case CREATE_TIME:
                    wrapper.orderBy(true, asc, Article::getCreateTime);
                    break;
                case PUBLISH_TIME:
                    wrapper.orderBy(true, asc, Article::getPublishTime);
                    break;
                case UPDATE_TIME:
                    wrapper.orderBy(true, asc, Article::getUpdateTime);
                    break;
                case VIEW_COUNT:
                    wrapper.orderBy(true, asc, Article::getViewCount);
                    break;
                case COMMENT_COUNT:
                    wrapper.orderBy(true, asc, Article::getCommentCount);
                    break;
                case LIKE_COUNT:
                    wrapper.orderBy(true, asc, Article::getLikeCount);
                    break;
                case DISLIKE_COUNT:
                    wrapper.orderBy(true, asc, Article::getDislikeCount);
                    break;
                case SHARE_COUNT:
                    wrapper.orderBy(true, asc, Article::getShareCount);
                    break;
            }
        }

        return wrapper;

    }
}
