curl -X POST ^
	--insecure ^
   -H "Authorization: Bearer %YC_API_KEY%" ^
   --data-urlencode "text=Hello World" ^
   -d "lang=ru-RU&voice=filipp&folderId=%YC_API_FOLDER_ID%" ^
   "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize" > speech.ogg


@PAUSE