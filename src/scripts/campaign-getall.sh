#/bin/bash
source ./config.sh

curl -iv -X GET -H "Accept: application/json;" $CAMPAIGN_SERVICE?page=1&start=0&limit=25