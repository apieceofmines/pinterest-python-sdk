# GitHub Actions CI/CD for A Piece of Mines

This document explains the automated testing, building, and deployment workflows.

## Workflows

### 1. CI Pipeline (`ci.yml`)
Runs on every push and pull request to `main` or `develop`.

**Jobs:**
- **test** — Compile & test backend and client SDK
- **docker** — Build Docker images (without pushing)
- **quality** — Code quality checks (Checkstyle)
- **security** — Vulnerability scanning (Trivy)
- **notify** — Report final status

Run time: ~10-15 minutes

### 2. Integration Tests (`integration-tests.yml`)
Validates the entire dockerized stack works end-to-end.

**Tests:**
- API health check `/api/health`
- Create tracking event `/api/track`
- Query events `/api/events`
- Auth protection (401 without API key)
- Frontend serving on port 80

Run time: ~3-5 minutes

### 3. Publish (`publish.yml`)
Publishes Docker images to Docker Hub.

**Triggers:**
- Push to `main` branch
- Tag pushes (`v*`)

**Requirements:**
- `DOCKER_USERNAME` secret
- `DOCKER_PASSWORD` secret (access token, not password)

Run time: ~5-10 minutes

---

## Required Secrets

To enable Docker image publishing, add these GitHub secrets:

### In GitHub UI
1. Go to repo **Settings** → **Secrets and variables** → **Actions**
2. Click **New repository secret**

### Secrets to Add

```
DOCKER_USERNAME = your-docker-username
DOCKER_PASSWORD = your-docker-access-token
DOCKERHUB_TOKEN = your-docker-hub-token
```

Get tokens from [Docker Hub Account Settings](https://hub.docker.com/settings/security)

---

## Running Workflows Locally

Test workflows locally with [act](https://github.com/nektos/act):

```bash
# Run all workflows
act

# Run specific workflow
act -j test

# Run with secrets
act -s DOCKER_USERNAME=myuser -s DOCKER_PASSWORD=mytoken
```

---

## Monitoring

View workflow status:
- GitHub Actions tab in repo
- Click on workflow name
- See logs per job step

---

## Best Practices

1. **Keep commits clean** — One feature per PR
2. **Write tests** — All new code should have tests
3. **Update docs** — Keep README and guides current
4. **Check locally first** — Run `mvn test` before pushing
5. **Use conventional commits** — `feat:`, `fix:`, `docs:`

---

## Troubleshooting

### CI Fails
1. Check workflow logs in GitHub Actions tab
2. Run tests locally: `mvn test`
3. Verify Docker runs: `docker-compose up`

### Docker Push Fails
1. Verify credentials are correct (test with `docker login`)
2. Check Docker Hub account has access
3. Ensure `DOCKER_USERNAME`/`PASSWORD` are set as secrets

### Tests Fail Locally
```bash
# Clean build
mvn clean install

# Run specific test
mvn test -Dtest=YourTestClass
```

---

For more info, see [APIECEOFMINES_README.md](../APIECEOFMINES_README.md)
