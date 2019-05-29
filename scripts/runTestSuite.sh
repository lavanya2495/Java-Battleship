#!/bin/bash
#===============================================================================
#!/bin/bash
#===============================================================================
# Team D'Buggers (Team 7)
# Professor McKee
# CPSC 5200-01
# 6 June 2019
#                              Milestone #2
#
# File: runTestSuite.sh
#
# Description: <TBD>
# TODO:
# 1. INTEGER COMPARISON
# 2. Failure return code from java
# 3. Counting/reporting/parsing PASS/FAILs...
#===============================================================================

#set -o errexit
#set -o pipefail
set -o nounset
# set -o xtrace

#===============================================================================
# Constants
#===============================================================================
MIN_ARGS=1
MAX_ARGS=2

OUT_DIR="out"
JUNIT_JAR="junit-platform-console-standalone-1.5.0-M1.jar"
PROJECT_ROOT=".."

# Hack required due to memory limitations on CS1
CS1_HACK="-XX:MaxHeapSize=512m -XX:InitialHeapSize=512m -XX:CompressedClassSpaceSize=64m -XX:MaxMetaspaceSize=128m -XX:+UseConcMarkSweepGC"

LOG_FILE="testOutput.txt"

#===============================================================================
# Script
#===============================================================================

# Check number of arguments
if [ "$#" -lt "$MIN_ARGS" ] || [ "$#" -gt "$MAX_ARGS" ]; then
    echo "ERROR: Invalid number of command-line arguments!"
    echo "Usage:"
    echo "   ./runTestSuite <numIter> [emailRecipient]"
    echo "     - <numIter> - Number of times to run the test suite. Range: [1,10000)"
    echo "     - [emailRecipient] - Optional e-mail address to notify with test results"
    exit 1
fi

# Basic input validation for number of iterations
if [ "$1" -le "0" ]; then
    echo "ERROR: Caller must enter numIter of 1 or more!"
    exit 2
fi

# Clean-up any stale log files
rm -f $LOG_FILE

# Run the test suite
numTests=$1
numPass=0
numFail=0
echo "Running the test suite..." | tee -a $LOG_FILE
echo "Start date/time:" $(date) | tee -a $LOG_FILE
start=$SECONDS
for i in `seq 1 $numTests`; do
    echo "Executing test run $i of $1..." | tee -a $LOG_FILE
    java $CS1_HACK -jar $PROJECT_ROOT/$JUNIT_JAR --class-path $PROJECT_ROOT/$OUT_DIR --scan-class-path | tee -a $LOG_FILE
    rv=$?
    echo "Tests completed with return code: $rv" | tee -a $LOG_FILE
    if [ $rv == 0 ]; then
        let "numPass++"
    else
        let "numFail++"
    fi
done
stop=$(( $SECONDS - $start ))
echo "Stop date/time:" $(date) | tee -a $LOG_FILE

# Report statistics
echo "Test duration:       $stop [seconds]" | tee -a $LOG_FILE
echo "Number of test runs: $numTests" | tee -a $LOG_FILE
echo "Number of PASS:      $numPass"  | tee -a $LOG_FILE
echo "Number of FAIL:      $numFail"  | tee -a $LOG_FILE
echo "Passing rate:        $((numPass / numTests * 100 ))%" | tee -a $LOG_FILE

# Determine overall result
isFail=1
status="FAIL"
if [ $numPass == $numTests ]; then
    isFail=0
    status="PASS"
fi

# Notify e-mail recipient if one was provided by caller
if [ $# == $MAX_ARGS ]; then
    echo "Sending e-mail report to $2..."
    mail -v -s "TEST RUN -- $status!" $2 < $LOG_FILE
    if [ $? != 0 ]; then
        echo "ERROR: Unable to send e-mail! rv = $?"
        exit 3
    fi
fi

# Set return code
if [ $numPass == $numTests ]; then
    exit 0
else
    exit 4
fi

# Propagate status
exit $isFail
