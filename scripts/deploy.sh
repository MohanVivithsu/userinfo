#!/bin/bash
set -e

AWS_ACCOUNT_ID=753548365490
AWS_REGION=ap-south-1

# Stop existing container if running
docker stop userinfo-app || true
docker rm userinfo-app || true

# Login to ECR
aws ecr get-login-password --region ${AWS_REGION} | \
  docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com

# Pull latest image
docker pull ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/userinfo-app:latest

# Run container
docker run -d --name userinfo-app -p 8080:8080 \
  -e DB_USERNAME=$DB_USERNAME \
  -e DB_PASSWORD=$DB_PASSWORD \
  ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/userinfo-app:latest
