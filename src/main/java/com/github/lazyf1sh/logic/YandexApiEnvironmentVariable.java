package com.github.lazyf1sh.logic;

/**
 * All these items are available in yandex console, no need to add screenshots and deep instructions - the same names in yandex console
 */
public enum YandexApiEnvironmentVariable {
    YC_API_FOLDER_ID, YANDEX_CLOUD_SERVICE_ACCOUNT_ID, YANDEX_CLOUD_AUTHORIZED_KEY_ID;

    /**
     * Last time it was refered the same way in yandex cloud console - 'an authorized key'
     */
    public static String YC_API_AUTHORIZED_KEY = "yandex-api-authorized.private_key";
    public static String YC_IAM_TOKEN_SOURCE = "https://iam.api.cloud.yandex.net/iam/v1/tokens";
}
