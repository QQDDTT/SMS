@echo off
setlocal

:: 1. 检查是否安装 Maven 和 Tomcat
where mvn >nul 2>&1
if %errorlevel% neq 0 (
    echo Maven 未安装，请安装 Maven 后重试。
    exit /b
)
where catalina >nul 2>&1
if %errorlevel% neq 0 (
    echo Tomcat 未安装，请安装 Tomcat 后重试。
    exit /b
)

:: 2. 检查 Maven 和 Tomcat 的环境变量
if "%MAVEN_HOME%"=="" (
    echo 没有检测到 MAVEN_HOME 环境变量，请配置后重试。
    exit /b
)
if "%CATALINA_HOME%"=="" (
    echo 没有检测到 CATALINA_HOME 环境变量，请配置后重试。
    exit /b
)

:: 3. 打包 Spring 项目为 ROOT.war
echo 正在使用 Maven 打包项目...
mvn clean package -DskipTests
if %errorlevel% neq 0 (
    echo Maven 打包失败。
    exit /b
)

:: 检查是否成功生成 WAR 文件
if not exist "target\*.war" (
    echo 未找到 WAR 文件，请检查项目配置。
    exit /b
)

:: 删除已有的 ROOT.war 文件并重命名新的 WAR 文件
set WAR_FILE=target\*.war
del /q "%CATALINA_HOME%\webapps\ROOT.war"
copy "%WAR_FILE%" "%CATALINA_HOME%\webapps\ROOT.war"
if %errorlevel% neq 0 (
    echo WAR 文件复制失败。
    exit /b
)

:: 4. 运行 Tomcat
echo 正在启动 Tomcat...
call "%CATALINA_HOME%\bin\catalina.bat" run
if %errorlevel% neq 0 (
    echo Tomcat 启动失败。
    exit /b
)

:: 5. 打开 localhost:8080
echo 正在打开 localhost:8080...
start http://localhost:8080

endlocal
exit /b
