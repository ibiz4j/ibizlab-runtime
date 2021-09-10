package cn.ibizlab.util.errors;


import org.springframework.dao.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.zalando.problem.DefaultProblem;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.validation.ConstraintViolationProblem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionTranslator implements ProblemHandling {

    @Override
    public ResponseEntity<Problem> process(@Nullable ResponseEntity<Problem> entity, NativeWebRequest request) {
        if (entity == null || entity.getBody() == null) {
            return entity;
        }
        Problem problem = entity.getBody();
        if (!(problem instanceof ConstraintViolationProblem || problem instanceof DefaultProblem)) {
            return entity;
        }
        ProblemBuilder builder = Problem.builder()
            .withType(Problem.DEFAULT_TYPE.equals(problem.getType()) ? ErrorConstants.DEFAULT_TYPE : problem.getType())
            .withStatus(problem.getStatus())
            .withTitle(problem.getTitle())
            .with("path", request.getNativeRequest(HttpServletRequest.class).getRequestURI());

        if (problem instanceof ConstraintViolationProblem) {
            builder
                .with("violations", ((ConstraintViolationProblem) problem).getViolations())
                .with("message", ErrorConstants.ERR_VALIDATION);
            return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
        } else {
            builder
                .withCause(((DefaultProblem) problem).getCause())
                .withDetail(problem.getDetail())
                .withInstance(problem.getInstance());
            problem.getParameters().forEach(builder::with);
            if (!problem.getParameters().containsKey("message") && problem.getStatus() != null) {
                builder.with("message", "error.http." + problem.getStatus().getStatusCode());
            }
            return new ResponseEntity<>(builder.build(), entity.getHeaders(), entity.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @Nonnull NativeWebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldErrorVM> fieldErrors = result.getFieldErrors().stream()
            .map(f -> new FieldErrorVM(f.getObjectName(), f.getField(),  f.getDefaultMessage()))
            .collect(Collectors.toList());

        Problem problem = Problem.builder()
            .withType(ErrorConstants.CONSTRAINT_VIOLATION_TYPE)
            .withTitle(ErrorConstants.ERR_VALIDATION)
            .withStatus(defaultConstraintViolationStatus())
            .with("message", ErrorConstants.ERR_VALIDATION )
            .with("fieldErrors", fieldErrors)
            .build();
        return create(ex, problem, request);
    }

    @ExceptionHandler(BadRequestAlertException.class)
    public ResponseEntity<Problem> handleBadRequestAlertException(BadRequestAlertException ex, NativeWebRequest request) {
        return create(ex, request, createFailureAlert(ex.getEntityName(), ex.getErrorKey(), ex.getMessage()));
    }

    @ExceptionHandler(ConcurrencyFailureException.class)
    public ResponseEntity<Problem> handleConcurrencyFailure(ConcurrencyFailureException ex, NativeWebRequest request) {
        Problem problem = Problem.builder()
            .withStatus(Status.CONFLICT)
            .with("message", ErrorConstants.ERR_CONCURRENCY_FAILURE)
            .build();
        return create(ex, problem, request);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Problem> handlerDataAccessFailure(DataAccessException ex, NativeWebRequest request){
        Problem problem = Problem.builder()
        .withStatus(Status.INTERNAL_SERVER_ERROR)
        .with("message", ex.getMessage())
        .build();
        return create(ex, problem, request,createFailureAlert(ex.getClass().getSimpleName(), ex.getClass().getSimpleName(), ex.getMessage()));
    }

    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-ibz-error", errorKey);
        headers.add("X-ibz-params", entityName);
        return headers;
    }

    /**
    * 上传文件大小超出限制异常
    */
    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Problem> handlerMaxUploadFile(MaxUploadSizeExceededException ex,NativeWebRequest request){
        Problem problem = Problem.builder()
        .withStatus(Status.BAD_REQUEST)
        .withDetail("上传文件不能大于"+maxFileSize)
        .with("message", "上传文件不能大于"+maxFileSize)
        .with("exmessage",""+ex.getMessage())
        .build();
        return create(ex, problem, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> handlerTest(Exception ex,NativeWebRequest request){
        Problem problem = Problem.builder()
        .withStatus(Status.INTERNAL_SERVER_ERROR)
        .withDetail("内部服务器异常")
        .with("message", "内部服务器异常")
        .with("exmessage",""+ex.getMessage())
        .build();
        return create(ex, problem, request);
    }
}
