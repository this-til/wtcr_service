package com.til.wtcr_service.pojo.data;

import com.til.wtcr_service.eumn.ResultType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<R>  {

    private ResultType resultType;
    private String message;
    @Nullable
    private R data;

    public static <T> Result<T> success(@Nullable String message) {
        return new Result<>(ResultType.SUCCESS, message == null ? "" : message, null);
    }

    public static <T> Result<T> fail(@Nullable String message) {
        return new Result<>(ResultType.FAIL, message == null ? "" : message, null);
    }

    public static <T> Result<T> error(@Nullable String message) {
        return new Result<>(ResultType.ERROR, message == null ? "" : message, null);
    }

}
