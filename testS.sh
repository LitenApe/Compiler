# make directories
mkdir -p resLogs/scannerLog
mkdir -p resLogs/scannerRes
mkdir -p resLogs/scannerFails

# get current path
curPath=$(pwd)

# compile the source file
ant

# iterate through the pascal files
for f in $(find . -type f -name '*.pas'); do
  # execute program
  java -jar pascal2016.jar -testscanner $f
  echo ' '
done

# move log files in testFiles directory to a seperate folder
mv $curPath/testFiles/*.log $curPath/resLogs/scannerLog/
mv $curPath/failFiles/*.log $curPath/resLogs/scannerFails/
