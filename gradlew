#!/usr/bin/env bash

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls -ld "$PRG"
    link=$(expr "$PRG" : '.*-> \(.*\)$')
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=$(dirname "$PRG")"/$link"
    fi
done
SAVED="$(cd "$(dirname "$PRG")" >/dev/null 2>&1 && pwd)"
cd "$SAVED" >/dev/null 2>&1 || exit 1

APP_HOME=$SAVED
export APP_HOME

# Skip this if we just use the wrapper from an older version
# of Gradle.
if [ ! -x "$APP_HOME/gradlew" ]; then
    chmod +x "$APP_HOME/gradlew"
fi

# Classpath addition.
CP=
if [ -d "$APP_HOME/gradle/wrapper" ]; then
  CP="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
fi

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        echo "Error: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
        exit 1
    fi
else
    JAVACMD=java
    if ! command -v java >/dev/null 2>&1
    then
        echo "Error: JAVA_HOME is not set and no 'java' command could be found in your PATH."
        exit 1
    fi
fi

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$darwin" && ! "$nonstop" ; then
    MAX_FD_LIMIT=$(ulimit -H -n)
    if [ $? -eq 0 ] ; then
        if [ "$MAX_FD_LIMIT" != 'unlimited' ] ; then
            ulimit -n $MAX_FD_LIMIT
        fi
    fi
fi

# For Darwin, add options to specify how the application appears in the dock
if $darwin; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=$(cygpath --path --mixed "$APP_HOME")
    CP=$(cygpath --path --mixed "$CP")

    # We build the pattern for arguments to be converted via cygpath
    ROOTDIRSRAW=$(find -L / -maxdepth 3 -type d -name gradle 2>/dev/null)
fi

exec "$JAVACMD" \
  -classpath "$CP" \
  -Dorg.gradle.appname="$APP_BASE_NAME" \
  org.gradle.wrapper.GradleWrapperMain \
  "$@"
