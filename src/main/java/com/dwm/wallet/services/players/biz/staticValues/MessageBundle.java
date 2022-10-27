package com.dwm.wallet.services.players.biz.staticValues;

/**
 * improvement possibility: placed @ independent module and
 * share between all services
 * and involve account service message as a unique resource
 */
public enum MessageBundle {
    validateSuccess,
    saveSuccess,
    saveSuccess_withoutAccount,
    validateFail_NoInput,
    validateFail_InputValidation,
    validateFail_UserExist
}