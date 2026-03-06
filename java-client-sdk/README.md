# Family Kids Client SDK (Java)

Tiny Java client library for sending tracking events to the sample Family Kids Analytics service. Uses tracking ID `549768018410` by default in examples.

Build:

```bash
cd java-client-sdk
mvn package
```

Run the example (after building the server):

```bash
java -jar target/family-kids-client-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

The example sends a sample `play` event to `http://localhost:8080/api/track` with an API key header and prints the server acknowledgement.

## Usage

Initialize the client with your API key:

```java
String apiKey = "apieceofmines-prod-key-2026";
TrackingClient client = new TrackingClient("http://localhost:8080", "549768018410", apiKey);
TrackingResponse response = client.track(event);
```

## Support & Contact

For questions or bug reports, reach out to: **joserafael@apieceofmines.com**

## Related Projects

- [Spring Boot Analytics Server](../java-spring-sample/) — Backend API for tracking events
- [Landing Page](../apieceofmines-web/) — Public website
