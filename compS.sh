# get current path
curPath=$(pwd)
# set path for directories
resPath="$curPath/testfiles"
fasPath="$curPath/testfiles/restestfiles"

# retrieve log files
resultater=$(ls testfiles/*.log)
fasit=$(ls testfiles)

# make it into an array
# resultater=$resultater | cut -d ' ' -f 1,2,3,4,5,6
# fasit=$fasit | cut -d ' ' -f 1,2,3,4,5,6

# # iterate through the files
for file in fasit; do
  for files in resultater; do
    if [[ $res == $fas ]]; then
      echo "Double checking:" $fas
      diff "$resPath$res" "$fasPath$fas"
    fi
  done
done
