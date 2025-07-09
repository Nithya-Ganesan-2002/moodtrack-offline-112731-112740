#!/bin/bash
cd /home/kavia/workspace/code-generation/moodtrack-offline-112731-112740/android_app_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

