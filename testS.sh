# make directories
mkdir -p pascal/resLogs/scannerLog
mkdir -p pascal/resLogs/parserLog
mkdir -p pascal/resLogs/checkerLog
# mkdir -p pascal/resLogs/scannerRes

# flag
mode="-testchecker"

# get current path
curPath=$(pwd)

# compile the source file
touch runLog.log
ant jar
# clear

if [[ ${#@} > 0 ]]; then
    java -jar pascal2016.jar $mode "pascal/testFiles/$1";
else
    for f in $(find pascal/ -type f -name '*.pas'); do
        java -jar pascal2016.jar $mode $f; echo ' '
    done
fi

# move log files in testFiles directory to a seperate folder
if [[ $mode == "-testscanner" ]]; then
    mv $curPath/pascal/testFiles/*.log $curPath/pascal/resLogs/scannerLog/
elif [[ $mode == "-testparser" ]]; then
    mv $curPath/pascal/testFiles/*.log $curPath/pascal/resLogs/parserLog/
elif [[ $mode == "-testchecker" ]]; then
    mv $curPath/pascal/testFiles/*.log $curPath/pascal/resLogs/checkerLog/
fi
