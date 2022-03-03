#!/usr/bin/env bash

url1="${CCCLASSROOM_URL}?CI=${CI}&ASSESSMENT_ID=${ASSESSMENT_ID}&CHALLENGE_ID=${CHALLENGE_ID}"
url2="&GITHUB_ACTOR=${GITHUB_ACTOR}&GITHUB_REPOSITORY_OWNER=${GITHUB_REPOSITORY_OWNER}"
url3="&GITHUB_REPOSITORY=${GITHUB_REPOSITORY}&GITHUB_SERVER_URL=${GITHUB_SERVER_URL}"
url4="&GITHUB_RUN_NUMBER=${GITHUB_RUN_NUMBER}&GITHUB_RUN_ATTEMPT=${GITHUB_RUN_ATTEMPT}"

url="${url1}${url2}${url3}${url4}"


for f in target/surefire-reports/*.txt
do
  if [[ -f $f ]]; then
  grep '^Tests run:.*Time elapsed:' "$f" | tee tmp.txt
  curl -m 2 -s -X POST -d @tmp.txt -H "Content-Type: application/json" "$url"
  rm tmp.txt
  else
    echo "Surefire reports were not found... Maybe project did not comply. Sending GET to CCClassroom server"
    curl -m 2 "$url"
  fi
done
