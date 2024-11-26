package com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.til.wtcr_service.eumn.ArticleState;
import com.til.wtcr_service.eumn.ArticleType;
import com.til.wtcr_service.eumn.ArticleVisibility;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ArticleFilter {
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
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (getId() != null) {
            lambdaQueryWrapper.eq(Article::getId, getId());
            return lambdaQueryWrapper;
        }

        if (getUserId() != null && !getUserId().isEmpty()) {
            if (getUserId().size() == 1) {
                lambdaQueryWrapper.eq(Article::getUserId, getUserId());
            } else {
                lambdaQueryWrapper.in(Article::getUserId, getUserId());
            }
        }


        if (getEditorId() != null && !getEditorId().isEmpty()) {
            for(Integer i : getEditorId()) {
                lambdaQueryWrapper.like(Article::getEditors, "," + i + ",");
            }
        }

        if (getType() != null && !getType().isEmpty()) {
            if (getType().size() == 1) {
                lambdaQueryWrapper.eq(Article::getType, getType().getFirst());
            } else {
                lambdaQueryWrapper.in(Article::getType, getType());
            }
        }

        if (getState() != null && !getState().isEmpty()) {
            if (getState().size() == 1) {
                lambdaQueryWrapper.eq(Article::getState, getState().getFirst());
            } else {
                lambdaQueryWrapper.in(Article::getState, getState());
            }
        }

        if (getVisibility() != null && !getVisibility().isEmpty()) {
            if (getVisibility().size() == 1) {
                lambdaQueryWrapper.eq(Article::getVisibility, getVisibility().getFirst());
            } else {
                lambdaQueryWrapper.in(Article::getVisibility, getVisibility());
            }
        }

        if (getCreateTimeRanger() != null) {
            LocalDateTime max = getCreateTimeRanger().getMax() == null ? LocalDateTime.now() : getCreateTimeRanger().getMax();
            LocalDateTime min = getCreateTimeRanger().getMin() == null ? LocalDateTime.MIN : getCreateTimeRanger().getMin();
            lambdaQueryWrapper.gt(Article::getCreateTime, min).lt(Article::getCreateTime, max);
        }

        if (getPublishTimeRanger() != null) {
            LocalDateTime max = getPublishTimeRanger().getMax() == null ? LocalDateTime.now() : getPublishTimeRanger().getMax();
            LocalDateTime min = getPublishTimeRanger().getMin() == null ? LocalDateTime.MIN : getPublishTimeRanger().getMin();
            lambdaQueryWrapper.gt(Article::getPublishTime, min).lt(Article::getPublishTime, max);
        }

        if (getUpdateTimeRanger() != null) {
            LocalDateTime max = getUpdateTimeRanger().getMax() == null ? LocalDateTime.now() : getUpdateTimeRanger().getMax();
            LocalDateTime min = getUpdateTimeRanger().getMin() == null ? LocalDateTime.MIN : getUpdateTimeRanger().getMin();
            lambdaQueryWrapper.gt(Article::getUpdateTime, min).lt(Article::getUpdateTime, max);
        }

        if (getViewCountRanger() != null) {
            int min = getViewCountRanger().getMin() == null ? 0 : getViewCountRanger().getMin();
            int max = getViewCountRanger().getMax() == null ? Integer.MAX_VALUE : getViewCountRanger().getMax();
            lambdaQueryWrapper.gt(Article::getViewCount, min).lt(Article::getViewCount, max);
        }

        if (getCommentCountRanger() != null) {
            int min = getCommentCountRanger().getMin() == null ? 0 : getCommentCountRanger().getMin();
            int max = getCommentCountRanger().getMax() == null ? Integer.MAX_VALUE : getCommentCountRanger().getMax();
            lambdaQueryWrapper.gt(Article::getCommentCount, min).lt(Article::getCommentCount, max);
        }

        if (getLikeCountRanger() != null) {
            int min = getLikeCountRanger().getMin() == null ? 0 : getLikeCountRanger().getMin();
            int max = getLikeCountRanger().getMax() == null ? Integer.MAX_VALUE : getLikeCountRanger().getMax();
            lambdaQueryWrapper.gt(Article::getLikeCount, min).lt(Article::getLikeCount, max);
        }

        if (getDislikeCountRanger() != null) {
            int min = getDislikeCountRanger().getMin() == null ? 0 : getDislikeCountRanger().getMin();
            int max = getDislikeCountRanger().getMax() == null ? Integer.MAX_VALUE : getDislikeCountRanger().getMax();
            lambdaQueryWrapper.gt(Article::getDislikeCount, min).lt(Article::getDislikeCount, max);
        }

        if (getShareCountRanger() != null) {
            int min = getShareCountRanger().getMin() == null ? 0 : getShareCountRanger().getMin();
            int max = getShareCountRanger().getMax() == null ? Integer.MAX_VALUE : getShareCountRanger().getMax();
            lambdaQueryWrapper.gt(Article::getShareCount, min).lt(Article::getShareCount, max);
        }

        return lambdaQueryWrapper;

    }
}
