@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  rinha-naut startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and RINHA_NAUT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\rinha-naut-0.1.jar;%APP_HOME%\lib\micronaut-flyway-5.5.0.jar;%APP_HOME%\lib\micronaut-kotlin-extension-functions-3.2.2.jar;%APP_HOME%\lib\micronaut-kotlin-runtime-3.2.2.jar;%APP_HOME%\lib\micronaut-redis-lettuce-5.4.0.jar;%APP_HOME%\lib\micronaut-jdbc-hikari-4.8.1.jar;%APP_HOME%\lib\micronaut-data-runtime-3.10.0.jar;%APP_HOME%\lib\micronaut-data-model-3.10.0.jar;%APP_HOME%\lib\micronaut-r2dbc-core-4.0.0.jar;%APP_HOME%\lib\micronaut-cache-core-3.5.0.jar;%APP_HOME%\lib\micronaut-jdbc-4.8.1.jar;%APP_HOME%\lib\micronaut-data-tx-3.10.0.jar;%APP_HOME%\lib\micronaut-reactor-2.6.0.jar;%APP_HOME%\lib\micronaut-data-r2dbc-3.10.0.jar;%APP_HOME%\lib\micronaut-http-client-3.10.1.jar;%APP_HOME%\lib\micronaut-http-server-netty-3.10.1.jar;%APP_HOME%\lib\micronaut-http-netty-3.10.1.jar;%APP_HOME%\lib\micronaut-http-server-3.10.1.jar;%APP_HOME%\lib\micronaut-websocket-3.10.1.jar;%APP_HOME%\lib\micronaut-http-client-core-3.10.1.jar;%APP_HOME%\lib\micronaut-management-3.10.1.jar;%APP_HOME%\lib\micronaut-runtime-3.10.1.jar;%APP_HOME%\lib\micronaut-jackson-databind-3.10.1.jar;%APP_HOME%\lib\micronaut-jackson-core-3.10.1.jar;%APP_HOME%\lib\micronaut-json-core-3.10.1.jar;%APP_HOME%\lib\micronaut-router-3.10.1.jar;%APP_HOME%\lib\micronaut-http-3.10.1.jar;%APP_HOME%\lib\micronaut-buffer-netty-3.10.1.jar;%APP_HOME%\lib\micronaut-context-3.10.1.jar;%APP_HOME%\lib\micronaut-aop-3.10.1.jar;%APP_HOME%\lib\micronaut-validation-3.10.1.jar;%APP_HOME%\lib\micronaut-inject-3.10.1.jar;%APP_HOME%\lib\jakarta.persistence-api-3.1.0.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.15.0.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.15.0.jar;%APP_HOME%\lib\jackson-databind-2.15.0.jar;%APP_HOME%\lib\jackson-annotations-2.15.0.jar;%APP_HOME%\lib\jackson-core-2.15.0.jar;%APP_HOME%\lib\jackson-module-kotlin-2.15.0.jar;%APP_HOME%\lib\kotlin-reflect-1.6.21.jar;%APP_HOME%\lib\kotlinx-coroutines-reactor-1.5.1.jar;%APP_HOME%\lib\kotlinx-coroutines-reactive-1.5.1.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.5.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.6.21.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\postgresql-42.5.4.jar;%APP_HOME%\lib\r2dbc-postgresql-0.9.2.RELEASE.jar;%APP_HOME%\lib\r2dbc-pool-0.9.2.RELEASE.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\reactor-netty-1.0.17.jar;%APP_HOME%\lib\reactor-netty-http-brave-1.0.17.jar;%APP_HOME%\lib\reactor-netty-http-1.0.17.jar;%APP_HOME%\lib\reactor-netty-incubator-quic-0.0.6.jar;%APP_HOME%\lib\reactor-netty-core-1.0.17.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.94.Final.jar;%APP_HOME%\lib\netty-codec-http2-4.1.94.Final.jar;%APP_HOME%\lib\lettuce-core-6.2.5.RELEASE.jar;%APP_HOME%\lib\netty-codec-http-4.1.94.Final.jar;%APP_HOME%\lib\netty-incubator-codec-native-quic-0.0.26.Final-linux-x86_64.jar;%APP_HOME%\lib\netty-incubator-codec-classes-quic-0.0.26.Final.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.94.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.94.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.94.Final.jar;%APP_HOME%\lib\netty-handler-4.1.94.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.94.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.94.Final.jar;%APP_HOME%\lib\netty-codec-4.1.94.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.94.Final-linux-x86_64.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.94.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.94.Final.jar;%APP_HOME%\lib\netty-transport-4.1.94.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.94.Final.jar;%APP_HOME%\lib\reactor-pool-0.2.9.jar;%APP_HOME%\lib\reactor-core-3.5.0.jar;%APP_HOME%\lib\r2dbc-spi-1.0.0.RELEASE.jar;%APP_HOME%\lib\micronaut-core-reactive-3.10.1.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\micronaut-core-3.10.1.jar;%APP_HOME%\lib\HikariCP-4.0.3.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\snakeyaml-2.0.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.6.21.jar;%APP_HOME%\lib\kotlin-stdlib-1.6.21.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.6.21.jar;%APP_HOME%\lib\flyway-core-8.5.13.jar;%APP_HOME%\lib\netty-resolver-4.1.94.Final.jar;%APP_HOME%\lib\netty-common-4.1.94.Final.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\config-1.4.2.jar;%APP_HOME%\lib\client-2.1.jar;%APP_HOME%\lib\checker-qual-3.5.0.jar;%APP_HOME%\lib\common-2.1.jar;%APP_HOME%\lib\fastdoubleparser-0.8.0.jar;%APP_HOME%\lib\javax.transaction-api-1.3.jar;%APP_HOME%\lib\saslprep-1.1.jar;%APP_HOME%\lib\brave-instrumentation-http-5.14.1.jar;%APP_HOME%\lib\stringprep-1.1.jar;%APP_HOME%\lib\brave-5.14.1.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\zipkin-reporter-brave-2.16.3.jar;%APP_HOME%\lib\zipkin-reporter-2.16.3.jar;%APP_HOME%\lib\zipkin-2.23.2.jar


@rem Execute rinha-naut
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %RINHA_NAUT_OPTS%  -classpath "%CLASSPATH%" br.com.rinha.ApplicationKt %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable RINHA_NAUT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%RINHA_NAUT_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
