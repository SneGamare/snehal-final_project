{
  "Effect": "Allow",
  "Action": "secretsmanager:GetSecretValue",
  "Resource": "arn:aws:secretsmanager:<region>:977098984058:secret:secret-plutus-dev-nonprod-01*"
}



Your application is trying to load a secret (secret-plutus-dev-nonprod-01) using AWS Secrets Manager, but the IAM role it is using (role-service-msk-ros-access-dev-01) does not have permission to call secretsmanager:GetSecretValue for that secret.
