#/bin/bash
source ./config.sh

curl -iv -X PUT \
  -d '{"id": "8a90f89f-3c0348c2-013c-03ab274a-0004","name": "BBBB"}' \
  -H "Accept: application/json;" \
  -H "Content-Type: application/json" \
  $USER_SERVICE/8a90f89f-3c0348c2-013c-03ab274a-0004