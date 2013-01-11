#/bin/bash
source ./config.sh

curl -iv -X PUT \
  -d '{"id": "4028b881-3c03f29c-013c-03f8db2e-0002", "cost": 500, "startDate": "2013-5-1"}' \
  -H "Accept: application/json;" \
  -H "Content-Type: application/json" \
  $CAMPAIGN_SERVICE/4028b881-3c03f29c-013c-03f8db2e-0002