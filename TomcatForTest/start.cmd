@echo off
REM call mvn assembly:assembly >> build.txt
call mvn clean package
if %errorlevel%==1 (
    echo "failed"
) else (
    scp target/TomcatForTest.war root@xiegy:/opt/apache-tomcat-8.5.15/webapps
)