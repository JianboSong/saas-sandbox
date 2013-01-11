#/bin/bash
source ./config.sh

curl -iv -X POST \
  -d '{"cost": 100, "startDate": "2013-1-1", "endDate": "2013-2-1", "user": { "id": "4028b881-3c07a90b-013c-07aa2dfc-0001"}}' \
  -H "Accept: application/json;" \
  -H "Content-Type: application/json" \
  $CAMPAIGN_SERVICE