package com.til.wtcr_service.pojo.filter;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.til.wtcr_service.eumn.UserGender;
import com.til.wtcr_service.eumn.UserPermission;
import com.til.wtcr_service.eumn.sort.UserSortMode;
import com.til.wtcr_service.pojo.PageModel;
import com.til.wtcr_service.pojo.data.TimeRanger;
import com.til.wtcr_service.pojo.User;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserFilter {
    private PageModel pageModel;
    @Nullable
    private UserSortMode userSortMode;
    @Nullable
    private Boolean asc;

    @Nullable
    private Long id;
    @Nullable
    private String account;
    @Nullable
    private String blurryAccount;
    @Nullable
    private String name;
    @Nullable
    private String blurryName;
    @Nullable
    private String email;
    @Nullable
    private String blurryEmail;
    @Nullable
    private String phone;
    @Nullable
    private String blurryPhone;
    @Nullable
    private List<UserGender> gender;
    @Nullable
    private List<UserPermission> permission;
    @Nullable
    private UserPermission greaterPermission;
    @Nullable
    private UserPermission lessPermission;
    @Nullable
    private TimeRanger registerTimeRanger;
    @Nullable
    private TimeRanger lastLoginTimeRanger;

    public Wrapper<User> asWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (getId() != null) {
            wrapper.eq(User::getId, getId());
            return wrapper;
        }

        if (getAccount() != null) {
            wrapper.eq(User::getAccount, getAccount());
        } else if (getBlurryAccount() != null) {
            wrapper.like(User::getAccount, getBlurryAccount());
        }

        if (getName() != null) {
            wrapper.eq(User::getName, getName());
        } else if (getBlurryName() != null) {
            wrapper.like(User::getAccount, getBlurryName());
        }

        if (getEmail() != null) {
            wrapper.eq(User::getEmail, getEmail());
        } else if (getBlurryEmail() != null) {
            wrapper.like(User::getEmail, getBlurryEmail());
        }

        if (getPhone() != null) {
            wrapper.eq(User::getPhone, getPhone());
        } else if (getBlurryPhone() != null) {
            wrapper.like(User::getPhone, getBlurryPhone());
        }

        if (getGender() != null && !getGender().isEmpty()) {
            if (getGender().size() == 1) {
                wrapper.eq(User::getGender, getGender().getFirst());
            } else {
                wrapper.in(User::getGender, new HashSet<>(getGender()));
            }
        }

        List<UserPermission> userPermissionList = getPermission() != null
                ? getPermission()
                : getGreaterPermission() != null
                        ? Arrays.stream(UserPermission.values()).filter(userPermission -> userPermission.getId() >= getGreaterPermission().getId()).collect(Collectors.toList())
                        : getLessPermission() != null
                                ? Arrays.stream(UserPermission.values()).filter(userPermission -> userPermission.getId() <= getLessPermission().getId()).collect(Collectors.toList())
                                : null;


        if (getGender() != null && !getGender().isEmpty()) {
            if (getGender().size() == 1) {
                wrapper.eq(User::getGender, getGender().getFirst());
            } else {
                wrapper.in(User::getPermission, userPermissionList);
            }
        }

        if (getRegisterTimeRanger() != null) {
            LocalDateTime max = getRegisterTimeRanger().getMax() == null ? LocalDateTime.now() : getRegisterTimeRanger().getMax();
            LocalDateTime min = getRegisterTimeRanger().getMin() == null ? LocalDateTime.MIN : getRegisterTimeRanger().getMin();
            wrapper.gt(User::getRegisterTime, min).lt(User::getRegisterTime, max);
        }

        if (getLastLoginTimeRanger() != null) {
            LocalDateTime max = getLastLoginTimeRanger().getMax() == null ? LocalDateTime.now() : getLastLoginTimeRanger().getMax();
            LocalDateTime min = getLastLoginTimeRanger().getMin() == null ? LocalDateTime.MIN : getLastLoginTimeRanger().getMin();
            wrapper.gt(User::getLastLoginTime, min).lt(User::getLastLoginTime, max);
        }

        if (getUserSortMode() != null) {
            boolean asc = getAsc() != null ? getAsc() : false;
            switch (getUserSortMode()) {
                case CREATION_TIME:
                    wrapper.orderBy(true, asc, User::getRegisterTime);
                    break;
                case LOGIN_TIME:
                    wrapper.orderBy(true, asc, User::getLastLoginTime);
                    break;
                case NAME:
                    wrapper.orderBy(true, asc, User::getName);
                    break;
            }
        }

        return wrapper;
    }

}
