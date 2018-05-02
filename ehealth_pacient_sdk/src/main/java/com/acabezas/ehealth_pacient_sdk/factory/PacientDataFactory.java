package com.acabezas.ehealth_pacient_sdk.factory;

import com.acabezas.ehealth_pacient_sdk.BuildConfig;
import com.acabezas.ehealth_pacient_sdk.data_source.LocalDataSource;
import com.acabezas.ehealth_pacient_sdk.data_source.PacientDataSource;
import com.acabezas.ehealth_pacient_sdk.data_source.RemoteDataSource;

/**
 * Created by alexandercabezas on 16/4/18.
 */

public class PacientDataFactory {

    private static LocalDataSource sLocalDataSource;
    private static RemoteDataSource sRemoteDataSource;

    public static PacientDataSource create() {

        if (BuildConfig.FLAVOR.equals("mock")) {

            if (sLocalDataSource == null) {
                sLocalDataSource = new LocalDataSource();
            }

            return sLocalDataSource;

        } else {
            if (sRemoteDataSource == null) {
                sRemoteDataSource = new RemoteDataSource();
            }

            return sRemoteDataSource;
        }
    }
}
