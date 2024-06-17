package umc.workbook.apiPayload.exception.handler;

import umc.workbook.apiPayload.code.BaseErrorCode;
import umc.workbook.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
