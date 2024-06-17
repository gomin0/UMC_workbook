package umc.workbook.apiPayload.exception.handler;

import umc.workbook.apiPayload.code.BaseErrorCode;
import umc.workbook.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
