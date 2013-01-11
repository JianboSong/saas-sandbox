#/bin/bash
source ./config.sh

curl -iv -X POST \
  -d '{"name": "abcabc", "metadata" : {"aaa": "aaa", "bbb": "bbb"}}' \
  -H "Accept: application/json;" \
  -H "Content-Type: application/json" \
  $USER_SERVICE