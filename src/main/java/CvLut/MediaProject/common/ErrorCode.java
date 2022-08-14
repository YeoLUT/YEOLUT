package CvLut.MediaProject.common;

import lombok.Getter;

//
@Getter
public enum ErrorCode {
    // 400 Client Error
    BAD_REQUEST(400, "잘못된 요청입니다."),
    UNAUTHORIZED_REQUEST(401, "해당 요청에 권한이 없습니다."),
    FORBIDDEN_REQUEST(403, "금지된 요청입니다."),
    USER_EXISTS(400, "이미 존재하는 계정입니다."),
    // 500 Server Error
    INTERNAL_SERVER_ERROR(500, "서버 내부 오류로 요청에 실패하였습니다.");

    private final static boolean status = false;
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean getStatus(){
        return status;
    }


}
