package com.dove.lol.dovelol.utils;

import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * @author Dovelol
 * @date 2019/3/11 22:43
 */
public class ApiResponse<T> {

    /**
     * 1 成功, 0 警告, -1 错误 -2业务异常
     */
    private Integer status = 1;
    private String code = "1";
    private Boolean success = true;
    private T data;
    private String message = "";
    private String desc = "";
    private String trace = "";
    public static final String MESSAGE_FETCH_CONTENT_ERROR = "Fetch Injoy Content Error.";
    public static final String MESSAGE_INJOY_IDS_EMPTY_ERROR = "Injoy ids should not be null or empty.";
    public static final String MESSAGE_PARAMS_INVALID_ERROR = "param: %s value is invalid. value=";

    public ApiResponse() {
    }

    public ApiResponse(Status status) {
        this(status, null, "", "");
    }

    public ApiResponse(Status status, T data) {
        this(status, data, "", "");
    }

    public ApiResponse(T data, String desc) {
        this(Status.SUCCESS, data, null, desc);
    }

    public ApiResponse(Status status, String message) {
        this(status, null, message, null);
    }

    public ApiResponse(Status status, T data, String message) {
        this(status, data, message, null);
    }

    public ApiResponse(Integer status, String message) {
        if (Objects.equals(status, Status.SUCCESS.getStatus()) || status == HttpStatus.OK.value()) {
            this.success = true;
            code = "1";
        } else {
            code = "-1";
        }
        //code = String.valueOf(status);
        this.message = message;
    }

    public ApiResponse(Status status, T data, String message, String desc) {
        if (status == null) {
            status = Status.ERROR;
        }
        this.status = status.status;
        this.code = status.code;
        this.success = status.success;
        this.message = message;
        this.data = data;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    /**
     * @category ApiResponse状态
     */
    public enum Status {
        // 成功
        SUCCESS(1, "1", true),
        // 警告
        WARN(0, "0", false),
        // 异常
        ERROR(-1, "-1", false),
        // 业务异常
        BUSINESS_ERROR(-2, "-2", false),
        // 业务异常显示message
        BUSINESS_ERROR_MESSAGE(-201, "-201", false),
        // 积分兑换付费PGC
        PGC_ERROR(-3, "-3", false),
        // 未登录
        NO_LOGIN(-101, "-101", false),
        // 未第三方登录
        NO_THIRD_LOGIN(-102, "-102", false),
        // 支付失败（账号不存在或无效）
        PAYMENT_INVALID_ACCOUNT(-601, "-601", false),
        // 支付失败（账号没有经过kyc验证）
        PAYMENT_KYC_NOT_VERIFIED(-602, "-602", false),
        // 支付正在进行中
        PAYMENT_PENDING(-603, "-603", false),
        // 其它原因（余额不足）
        OTHER_PENDING(-604, "-604", false);


        Status(Integer status, String code, Boolean success) {
            this.status = status;
            this.success = success;
            this.code = code;
        }

        private Integer status;
        private Boolean success;
        private String code;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }

}
