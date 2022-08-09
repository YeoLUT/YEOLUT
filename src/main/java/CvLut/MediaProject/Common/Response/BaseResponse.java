package CvLut.MediaProject.Common.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {
    @Schema(required = true, example = "True")
    @JsonProperty
    private boolean status;

    @Schema(required = true, example = "Success")
    @JsonProperty
    private String message;
    @Schema
    @JsonProperty("result")
    private T result;

    @Builder
    public BaseResponse(boolean status, final String message){
        this.status = status;
        this.message = message;
        this.result = null;
    }
    public static <T> BaseResponse<T> res(boolean status, final String message){
        return res(status, message);
    }
    public static <T> BaseResponse<T> res(boolean status, final String message, final T t){
        return BaseResponse.<T>builder()
                .result(t)
                .status(status)
                .message(message)
                .build();
    }
}
