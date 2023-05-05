package top.hjh.enums;

import lombok.Getter;
import top.hjh.consts.MsgConsts;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 28 14 18
 **/
@Getter
public enum CustomExceptionType {
    PARAM_ERROR(MsgConsts.CODE_400, MsgConsts.PARAM_ERROR),

    UNAUTHORIZED_ERROR(MsgConsts.CODE_401,MsgConsts.UNAUTHRIZED_ERROR),

    FORBIDDEN_ERROR(MsgConsts.CODE_403,MsgConsts.FORBIDDEM_ERROR),

    SYSTEM_ERROR(MsgConsts.CODE_500, MsgConsts.SYSTEM_ERROR),

    OTHER_ERROR(MsgConsts.CODE_999, MsgConsts.OTHER_ERROR);


    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;
    }
