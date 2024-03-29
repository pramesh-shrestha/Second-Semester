@echo off

rem
rem Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
rem Use is subject to license terms.
rem

setlocal

rem ---------------------------------------------------------------------------
rem ------------------  Set Required Environment ---------------------------
rem ---------------------------------------------------------------------------
set ASENV_CONF_LOCATION=C:/GlassFish-Tools-Bundle-For-Eclipse-1.1/glassfishv2.1/config
call "%ASENV_CONF_LOCATION%/asenv.bat"

rem ---------------------------------------------------------------------------
rem ------------------  Check JAVA_HOME  --------------------------------------
rem ---------------------------------------------------------------------------
if "%JAVA_HOME%"=="" set JAVA_HOME=%AS_JAVA%
if exist "%JAVA_HOME%\bin\java.exe" goto gotJava
echo JAVA_HOME (%JAVA_HOME%) is not pointing at a valid JDK installation.
goto end
:gotJava

rem ---------------------------------------------------------------------------
rem ------------------  Set Server-Specific Environment  ----------------------
rem ---------------------------------------------------------------------------

set SERVER_NAME=server
set INSTANCE_ROOT=%~dp0..

rem ---------------------------------------------------------------------------
rem ------------------  Set  Environment for Readability  ---------------------
rem ---------------------------------------------------------------------------

set CLASSNAME=com.sun.enterprise.ee.admin.servermgmt.ASShutdown
set JAVA="%JAVA_HOME%\bin\java.exe" 
set CP="%AS_INSTALL%\lib\appserv-admin.jar";"%AS_INSTALL%\lib\appserv-rt.jar";"%AS_INSTALL%\lib\appserv-se.jar";"%AS_INSTALL%\lib\javaee.jar"

rem ---------------------------------------------------------------------------
rem ------------------  Shutdown    ------------------------------------------------
rem ---------------------------------------------------------------------------

%JAVA% -cp %CP% %CLASSNAME%

endlocal
