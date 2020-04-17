#!/bin/bash
set -eo pipefail
aws cloudformation package --template-file template.yml --s3-bucket cv19-jw --output-template-file out.yml
aws cloudformation deploy --template-file out.yml --stack-name cv19-mars --capabilities CAPABILITY_NAMED_IAM
