package com.acabezas.ehealth_pacient_sdk.callbacks;

import com.acabezas.ehealth_pacient_sdk.model.UpdateProfileRequest;

/**
 * Created by alexandercabezas on 3/5/18.
 */

public interface GetUserProfileDataCallback {

    void success(UpdateProfileRequest response);

    void failure();
}
