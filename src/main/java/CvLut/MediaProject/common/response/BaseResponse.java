package CvLut.MediaProject.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {
    @Schema(required = true, example = "True")
    @JsonProperty
    private final static boolean status = true;

    @Schema(required = true, example = "Success")
    @JsonProperty
    private String message;
    @Schema
    @JsonProperty("result")
    private T result;

    @Builder
    public BaseResponse(final String message){
        this.message = message;
        this.result = null;
    }
    public static <T> BaseResponse<T> res(boolean status, final String message){
        return res(status, message);
    }
    public static <T> BaseResponse<T> res(boolean status, final String message, final T t){
        return BaseResponse.<T>builder()
                .result(t)
                .message(message)
                .build();
    }
}
