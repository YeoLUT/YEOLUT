package CvLut.MediaProject.common.response;

import CvLut.MediaProject.common.ErrorCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    @Schema(required = true, example = "True")
    @JsonProperty
    private boolean status;

    @Schema(required = true, example = "Success")
    @JsonProperty
    private String message;

    @Schema(required = true, example = "500")
    @JsonProperty
    private int code;

    @Builder
    public ErrorResponse(boolean status, String message, int code){
        this.code = code;
        this.status = status;
        this.message = message;
    }
    public static ErrorResponse of(ErrorCode errorCode){
        return new ErrorResponse(errorCode.getStatus(), errorCode.getMessage(), errorCode.getCode());
    }
}
