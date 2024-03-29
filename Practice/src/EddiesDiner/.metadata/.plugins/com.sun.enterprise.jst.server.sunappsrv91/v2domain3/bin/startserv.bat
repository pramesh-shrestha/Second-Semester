@echo off

rem
rem Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
rem Use is subject to license terms.
rem

setlocal

if "%1"=="help" goto help
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
rem ------------------  Set Domain-Specific Environment  ----------------------
rem ---------------------------------------------------------------------------
set SERVER_NAME=server
set INSTANCE_ROOT=%~dp0..
set PROCESS_NAME=as9-server

rem ---------------------------------------------------------------------------
rem ------------------  Process Args                      ---------------------
rem ---------------------------------------------------------------------------
set CLI=
if not "%1"=="cli" goto NOT_CLI
shift /1
set CLI=cli
:NOT_CLI

rem check for "native" remove and remember it
set NATIVE=
if  not "%1"=="native" goto NOT_NATIVE
shift /1
set NATIVE=native

rem Don't allow "native" arg when running directly from the commandline, because
rem we have no access to stdin
if not "%CLI%"=="cli" goto NATIVE_NOT_ALLOWED

:NOT_NATIVE

rem ---------------------------------------------------------------------------
rem ------------------  Set  Environment for Readability  ---------------------
rem ---------------------------------------------------------------------------
set CLASSNAME=com.sun.enterprise.admin.servermgmt.launch.ASLauncher
set JAVA="%JAVA_HOME%\bin\java.exe" 
set CP="%AS_INSTALL%\lib\appserv-admin.jar";"%AS_INSTALL%\lib\appserv-rt.jar";"%AS_INSTALL%\lib\admin-cli.jar"
set D01=-Dcom.sun.aas.installRoot="%AS_INSTALL%" 
set D02=-Dcom.sun.aas.instanceRoot="%INSTANCE_ROOT%"  
set D03=-Dcom.sun.aas.instanceName="%SERVER_NAME%"
set D04=-Dcom.sun.aas.processName=%PROCESS_NAME%

rem only needed for instances and node-agents
rem set D05=-Dcom.sun.aas.launcherReturn=

if "%CLI%"=="cli" set D06=-Dcaller=cli

rem ---------------------------------------------------------------------------
rem ------------------  Start    ------------------------------------------------
rem ---------------------------------------------------------------------------

set PATH=%AS_INSTALL%\lib;%AS_INSTALL%\bin
if  not "%NATIVE%"=="native" goto JAVA_LAUNCH

"%AS_INSTALL%/lib/appservLauncher.exe" "%AS_INSTALL%/lib/appservDAS.exe %DOMAIN_NAME%"  "\"%~df0\" %CLI% display %1 %2 %3 %4" 
exit

:JAVA_LAUNCH
%JAVA% -cp %CP% %D01% %D02% %D03% %D04% %D05% %D06% %CLASSNAME% start %1 %2 %3 %4 %5 %6 %7 %8
rem if ERRORLEVEL 1 goto error 
goto end

:help
echo startserv [verbose] [debug]
goto end

:NATIVE_NOT_ALLOWED
echo Can not start in native mode from the commandline
:end
endlocal
