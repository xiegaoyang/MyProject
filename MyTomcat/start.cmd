@echo off
REM call mvn assembly:assembly >> build.txt
call mvn clean package
if %errorlevel%==1 (
    echo "failed"
) else (
    scp target/MyTomcat.war root@bjb:/opt/apache-tomcat-8.5.14/webapps
)