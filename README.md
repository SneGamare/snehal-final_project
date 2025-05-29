version: '3.8'
services:
  postgres:
    image: postgres:14
    ports:
      - "5432:5432"
    environment:
      POSTGRES_USER: test_user
      POSTGRES_PASSWORD: test_pass
      POSTGRES_DB: test_db
    healthcheck:
      test: ["CMD", "pg_isready", "-U", "test_user"]
      interval: 10s
      timeout: 5s
      retries: 5
