package com.github.lazyf1sh.logic;

/**
 * All these items are available in yandex console.
 * <p>
 * Referred by the same names in yandex console.
 * <p>
 * No need to add screenshots or detailed instructions.
 */
public enum YandexApiEnvironmentVariable {
    YC_API_FOLDER_ID,
    YANDEX_CLOUD_SERVICE_ACCOUNT_ID,
    YANDEX_CLOUD_AUTHORIZED_KEY_ID;

    /**
     * Referred the same way in yandex cloud console - 'an authorized key'.
     */
    public static final String YC_API_AUTHORIZED_KEY = "yandex-api-authorized.private_key";
    public static final String YC_IAM_TOKEN_SOURCE = "https://iam.api.cloud.yandex.net/iam/v1/tokens";
}
