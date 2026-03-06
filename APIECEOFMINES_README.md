# A Piece of Mines — Family Online Kids Product

Complete project for **A Piece of Mines**, a family-first online kids product built with Java + Spring Boot + landing page.

**Tracking ID:** `549768018410`  
**Primary Contact:** joserafael@apieceofmines.com

## 📁 Project Structure

### `/apieceofmines-web`
Modern, responsive landing page for the product. Features include:
- Hero section with CTAs
- Feature highlights (6 feature cards)
- Safety & compliance info
- 3-tier pricing table
- Contact form  
- Analytics & tracking integration

**Quick start:**
```bash
cd apieceofmines-web
python3 -m http.server 8000
# Visit http://localhost:8000
```

See [apieceofmines-web/README.md](apieceofmines-web/README.md) for details.

---

### `/java-spring-sample`
Spring Boot backend service that exposes REST endpoints for tracking and analytics:
- `GET /api/health` — health check
- `POST /api/track` — accept tracking events

**Quick start:**
```bash
cd java-spring-sample
mvn clean package
java -jar target/family-kids-analytics-0.0.1-SNAPSHOT.jar
```

See [java-spring-sample/README.md](java-spring-sample/README.md) for details.

---

### `/java-client-sdk`
Java client library to call the Spring Boot tracking endpoints. Includes:
- `TrackingClient` — HTTP client with Jackson serialization
- `TrackingEvent` & `TrackingResponse` — data models
- `ExampleClient` — sample usage

**Quick start:**
```bash
cd java-client-sdk
mvn clean package
java -cp target/family-kids-client-0.0.1-SNAPSHOT.jar com.example.family.client.ExampleClient
```

See [java-client-sdk/README.md](java-client-sdk/README.md) for details.

---

## 🚀 Deployment

### Local Development
```bash
cd java-spring-sample && mvn clean package
java -jar target/family-kids-analytics-0.0.1-SNAPSHOT.jar
```

Backend runs on `http://localhost:8080`

### Docker Deployment (Recommended)

**Prerequisites:** Docker and Docker Compose installed

**Build and run the entire stack:**
```bash
docker-compose up --build
```

This starts:
- **API Backend** on `http://localhost:8080`
- **Frontend Landing Page** on `http://localhost`

**Verify services:**
```bash
docker ps
curl http://localhost/
curl -H 'X-API-Key: apieceofmines-prod-key-2026' http://localhost:8080/api/events
```

**Stop the stack:**
```bash
docker-compose down
```

---

## 🔄 CI/CD Pipeline

GitHub Actions automatically tests, builds, and validates on every push:

### Workflows
1. **CI Pipeline** — Build, test, code quality, security scans
2. **Integration Tests** — Full Docker stack validation
3. **Publish** — Push to Docker Hub (requires secrets)

See [CICD.md](CICD.md) for setup instructions and secret configuration.

### Status Badge
[![CI/CD Pipeline](https://github.com/yourusername/pinterest-python-sdk/actions/workflows/ci.yml/badge.svg)](https://github.com/yourusername/pinterest-python-sdk/actions)

---

### 1. Start the Backend
```bash
cd java-spring-sample
mvn clean package
java -jar target/family-kids-analytics-0.0.1-SNAPSHOT.jar
```
Server runs on `http://localhost:8080`

### 2. Send a Tracking Event (in another terminal)
```bash
curl -X POST http://localhost:8080/api/track \
  -H 'Content-Type: application/json' \
  -d '{"type":"play","metadata":{"level":"1"}}'
```

### 3. Or Use the Java Client
```bash
cd java-client-sdk
mvn clean package
java -cp target/family-kids-client-0.0.1-SNAPSHOT.jar com.example.family.client.ExampleClient
```

### 4. Serve the Landing Page (Optional)
```bash
cd apieceofmines-web
python3 -m http.server 8000
# Visit http://localhost:8000
```

---

## � Security

**All API endpoints require authentication except `/api/health`:**

API Key: `apieceofmines-prod-key-2026`

Header: `X-API-Key: apieceofmines-prod-key-2026`

Invalid or missing API keys return `401 Unauthorized`.

---

✅ **End-to-End Solution**
- Frontend: Responsive landing page (HTML/CSS/JS)
- Backend: Spring Boot REST API
- SDK: Java client library

✅ **Production-Ready Patterns**
- Model-Controller-Service architecture
- Jackson JSON serialization
- HTTP client with error handling
- Modular project structure

✅ **Tracking & Analytics**
- Built-in tracking ID (`549768018410`)
- Event logging and timestamps
- Response acknowledgement

✅ **Family-Friendly**
- Safety & parental controls messaging
- Privacy-first design
- COPPA compliance (claimed)

---

## 📞 Support & Contact

**Primary Contact:** joserafael@apieceofmines.com

For questions, issues, or contributions:
- Email the contact above
- Check individual project READMEs for specific guidance
- Review inline code comments for implementation details

---

## 🏗️ Next Steps (Optional)

- [ ] Add H2 or PostgreSQL persistence to spring-boot sample
- [ ] Implement basic auth / parental controls
- [ ] Dockerize both frontend and backend
- [ ] Add JUnit tests for the client SDK
- [ ] Set up GitHub Actions CI/CD pipeline
- [ ] Deploy to cloud (AWS, Google Cloud, etc.)
- [ ] Add mobile app (Android/iOS client)

---

## 📄 License

All projects in this repository are part of A Piece of Mines, owned and maintained by joserafael@apieceofmines.com.

---

## Architecture Overview

```
┌─────────────────────────────────────┐
│   apieceofmines-web                 │
│   (Landing Page / Frontend)         │
│   HTML + CSS + JS                   │
└─────────────────────────────────────┘
                ↓
    Sends tracking events via HTTP
                ↓
┌─────────────────────────────────────┐
│   java-spring-sample                │
│   (Backend REST API)                │
│   Spring Boot + Jackson             │
└─────────────────────────────────────┘
                ↑
    Java applications consume API
                ↑
┌─────────────────────────────────────┐
│   java-client-sdk                   │
│   (Client Library)                  │
│   TrackingClient + Models           │
└─────────────────────────────────────┘
```

---

**Version:** 0.0.1-SNAPSHOT  
**Last Updated:** March 6, 2026  
**Tracking ID:** 549768018410
