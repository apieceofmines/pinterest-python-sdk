# Family Kids Analytics — Spring Boot Sample

Minimal Spring Boot sample that exposes REST endpoints for tracking and analytics with **H2 in-memory database persistence**.

The project uses tracking ID `549768018410` and demonstrates:
- Event tracking with JSON serialization
- Database persistence with JPA
- Query endpoints to retrieve stored events

## Build and Run

Maven required (Java 17+):

```bash
cd java-spring-sample
mvn clean package
java -jar target/family-kids-analytics-0.0.1-SNAPSHOT.jar
```

Server runs on `http://localhost:8080`

## Authentication

All endpoints except `/api/health` require an **API Key** header:

```bash
X-API-Key: apieceofmines-prod-key-2026
```

Missing or invalid API key returns `401 Unauthorized`.

## Endpoints

### Tracking
- `GET /api/health` — health check → `ok` (no auth needed)
- `POST /api/track` — submit tracking event (requires API key)

**Request:**
```json
{
  "type": "play",
  "metadata": {
    "level": "5",
    "game": "chess"
  }
}
```

**Response:**
```json
{
  "trackingId": "549768018410",
  "eventId": "4456db40-9d15-4d23-9117-d514d88dd448",
  "receivedAt": "2026-03-06T02:31:45.123Z"
}
```

### Events Query (Requires API Key)
- `GET /api/events` — retrieve all stored events
- `GET /api/events/type/{type}` — filter events by type (e.g., `/api/events/type/play`)

**Example:**
```bash
curl http://localhost:8080/api/events | jq .
curl http://localhost:8080/api/events/type/learn | jq .
```

## Database

Uses **H2 in-memory database** for event persistence:
- Auto-creates tables on startup
- Drops on shutdown (demo mode, can be changed)
- H2 console available at `/h2-console` (optional)

## Configuration

See `src/main/resources/application.properties` for:
- Server port (8080)
- H2 datasource URL and credentials
- JPA/Hibernate settings

## Example Requests

### Send a play event
```bash
curl -X POST http://localhost:8080/api/track \
  -H 'Content-Type: application/json' \
  -H 'X-API-Key: apieceofmines-prod-key-2026' \
  -d '{"type":"play","metadata":{"level":"1"}}'
```

### Query all events
```bash
curl -H 'X-API-Key: apieceofmines-prod-key-2026' http://localhost:8080/api/events | jq .
```

### Query play events only
```bash
curl -H 'X-API-Key: apieceofmines-prod-key-2026' http://localhost:8080/api/events/type/play | jq .
```

## Support

For questions, contact: **joserafael@apieceofmines.com**

## Related

- [Java Client SDK](../java-client-sdk/) — Client library to call these endpoints
- [Landing Page](../apieceofmines-web/) — Public website for A Piece of Mines
