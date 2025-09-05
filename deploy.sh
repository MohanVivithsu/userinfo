#!/bin/bash
set -e

# Stop existing container if running
docker stop userinfo-app || true
docker rm userinfo-app || true

# Pull latest image from ECR
$(aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin <AWS_ACCOUNT_ID>.dkr.ecr.ap-south-1.amazonaws.com)
docker pull ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/userinfo-app:latest

# Run container
docker run -d --name userinfo-app -p 8080:8080 \
  -e DB_USERNAME=$DB_USERNAME \
  -e DB_PASSWORD=$DB_PASSWORD \
  ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/userinfo-app:latest
