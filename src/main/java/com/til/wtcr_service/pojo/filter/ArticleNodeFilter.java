package com.til.wtcr_service.pojo.filter;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.til.wtcr_service.eumn.ArticleNodeState;
import com.til.wtcr_service.eumn.sort.ArticleNodeSortModel;
import com.til.wtcr_service.pojo.Article;
import com.til.wtcr_service.pojo.ArticleNode;
import com.til.wtcr_service.pojo.PageModel;
import com.til.wtcr_service.pojo.data.TimeRanger;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleNodeFilter {
    private PageModel pageModel;
    @Nullable
    private ArticleNodeSortModel articleNodeSortModel;
    @Nullable
    private Boolean asc;


    @Nullable
    private Integer id;

    @Nullable
    private List<String> changeUserId;
    @Nullable
    private List<ArticleNodeState> state;
    @Nullable
    private TimeRanger updateTimeRange;

    public Wrapper<ArticleNode> asWrapper(@Nullable Article article) {
        LambdaQueryWrapper<ArticleNode> wrapper = new LambdaQueryWrapper<>();

        if (getId() != null) {
            wrapper.eq(ArticleNode::getId, getId());
            return wrapper;
        }

        if (article != null) {
            wrapper.eq(ArticleNode::getArticleId, article.getId());
        }

        if (getChangeUserId() != null && !getChangeUserId().isEmpty()) {
            if (getChangeUserId().size() == 1) {
                wrapper.eq(ArticleNode::getChangeUserId, getChangeUserId().getFirst());
            } else {
                wrapper.in(ArticleNode::getChangeUserId, getChangeUserId());
            }
        }

        if (getState() != null && !getState().isEmpty()) {
            if (getState().size() == 1) {
                wrapper.eq(ArticleNode::getState, getState().getFirst());
            } else {
                wrapper.in(ArticleNode::getState, getState());
            }
        }

        if (getUpdateTimeRange() != null) {
            LocalDateTime max = getUpdateTimeRange().getMax() == null ? LocalDateTime.now() : getUpdateTimeRange().getMax();
            LocalDateTime min = getUpdateTimeRange().getMin() == null ? LocalDateTime.MIN : getUpdateTimeRange().getMin();
            wrapper.gt(ArticleNode::getUpdateTime, min).lt(ArticleNode::getUpdateTime, max);
        }

        if (getArticleNodeSortModel() != null) {
            boolean asc = getAsc() != null ? getAsc() : false;
            switch (getArticleNodeSortModel()) {
                case UPDATE_TIME:
                    wrapper.orderBy(true, asc, ArticleNode::getUpdateTime);
                    break;
            }
        }

        return wrapper;
    }

}