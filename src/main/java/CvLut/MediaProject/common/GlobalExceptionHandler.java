package CvLut.MediaProject.common;

import CvLut.MediaProject.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 컨트롤러에서 발생하는 예외를 전역적으로 처리
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleServerException(Exception e){
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        log.warn(e.getMessage(), e);
        return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
    }
    @ExceptionHandler({MethodArgumentNotValidException.class, RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e){
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.BAD_REQUEST);
        log.warn(e.getMessage(), e);
        return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
    }
}
