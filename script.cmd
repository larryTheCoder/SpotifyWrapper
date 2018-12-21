@echo off
COPY "E:\ACD-JavaWorkplace\SpotifyReader\target\SpotifyReader.jar" "E:\ACD-JavaWorkplace\SpotifyReader\Containers\"
java -jar ./containers/SpotifyReader.jar --file ./containers/Spotify-Data-v1.zip --debug 1
pause