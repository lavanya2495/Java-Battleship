#!/bin/bash
#===============================================================================
# Team D'Buggers (Team 7)
# Professor McKee
# CPSC 5200-01
# 6 June 2019
#                              Milestone #2
#
# File: buildTestSuite.sh
#
# Description: <TBD>
#
#===============================================================================

#set -o errexit
#set -o pipefail
set -o nounset
# set -o xtrace

#===============================================================================
# Constants
#===============================================================================
OUT_DIR="out"
JUNIT_JAR="junit-platform-console-standalone-1.5.0-M1.jar"

# NOTE: This list needs to be updated if any additional source files are added
#       to the project!
sourceList=(
    Battleship
    Grid
    Location
    Randomizer
    Ship
)

# NOTE: This list needs to be updated if any additional test files are added
#       to the project!
testList=(
    LocationTest
    #ShipTest  # Commented out for now since it blows up (potentially due to old Java compiler on CS1?)
)

#===============================================================================
# Script
#===============================================================================
echo "Building test suite..."

echo "Creating directory for build artifacts..."
mkdir -p $OUT_DIR

echo "Removing stale artifacts..."
rm -f $OUT_DIR/*.class

echo "Building source code..."
for i in ${sourceList[@]}; do
    echo "Building: $i.java --> $i.class"
    javac -d $OUT_DIR $i.java
    if [ $? != 0 ]; then
        echo "ERROR: Unable to build $i.java! Aborting build..."
        exit 1
    fi
done

echo "Building unit tests..."
for i in ${testList[@]}; do
    echo "Building: $i.java --> $i.class"
    javac -d $OUT_DIR -cp $OUT_DIR:$JUNIT_JAR $i.java
    if [ $? != 0 ]; then
        echo "ERROR: Unable to build $i.java! Aborting build..."
        exit 2
    fi
done

echo "Build success!"
exit 0
