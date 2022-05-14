package CvLut.MediaProject.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BaseResponse<T> {
    @JsonProperty
    private boolean status;
    @Schema(ref = "결과 코드")
    @JsonProperty
    private HttpStatus code;
    @JsonProperty
    private String message;
    @Schema(ref = "결과 데이터")
    @JsonProperty
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
