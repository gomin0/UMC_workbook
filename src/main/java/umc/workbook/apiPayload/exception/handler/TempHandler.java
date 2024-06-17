package umc.workbook.apiPayload.exception.handler;

import umc.workbook.apiPayload.code.BaseErrorCode;
import umc.workbook.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}