# make directories
mkdir -p pascal/resLogs/

# flag
mode=""

# get current path
curPath=$(pwd)

# compile the source file
ant jar

if [[ ${#@} > 0 ]]; then
    java -jar pascal.jar "pascal/testFiles/$1";
else
    for f in $(find pascal/testFiles -type f -name '*.pas'); do
        java -jar pascal.jar $mode $f; echo ' '
    done
fi

mv $curPath/pascal/testFiles/*.s $curPath/pascal/resLogs/
