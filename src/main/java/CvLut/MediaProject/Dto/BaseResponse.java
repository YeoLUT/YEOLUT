package CvLut.MediaProject.Dto;

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
    @Schema(required = true, example = "OK")
    @JsonProperty
    private HttpStatus code;
    @Schema(required = true, example = "Success")
    @JsonProperty
    private String message;
    @Schema
    @JsonProperty("result")
    private T result;

    public BaseResponse(boolean status, final HttpStatus code, final String message){
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = null;
    }
    public static <T> BaseResponse<T> res(boolean status, final HttpStatus code, final String message){
        return res(status, code, message);
    }
    public static <T> BaseResponse<T> res(boolean status, final HttpStatus code, final String message, final T t){
        return BaseResponse.<T>builder()
                .result(t)
                .code(code)
                .status(status)
                .message(message)
                .build();
    }
}
