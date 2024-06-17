package umc.workbook.apiPayload.exception.handler;

import umc.workbook.apiPayload.code.BaseErrorCode;
import umc.workbook.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
