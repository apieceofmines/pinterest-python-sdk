# Family Kids Analytics — Spring Boot Sample

This is a minimal Spring Boot sample that exposes a small tracking/analytics endpoint for a family/kids product. The project uses the tracking ID `549768018410` as a constant in the tracking service and demonstrates how events can be received and acknowledged.

Build and run (Maven required):

```bash
cd java-spring-sample
mvn package
java -jar target/family-kids-analytics-0.0.1-SNAPSHOT.jar
```

Endpoints:
- `GET /api/health` — simple health check
- `POST /api/track` — accept a tracking event JSON and return an acknowledgement containing the tracking id

Example `curl`:

```bash
curl -X POST http://localhost:8080/api/track \
  -H 'Content-Type: application/json' \
  -d '{"type":"play","metadata":{"level":"1"}}'
```
