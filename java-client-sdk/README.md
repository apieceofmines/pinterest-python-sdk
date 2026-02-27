# Family Kids Client SDK (Java)

Tiny Java client library for sending tracking events to the sample Family Kids Analytics service. Uses tracking ID `549768018410` by default in examples.

Build:

```bash
cd java-client-sdk
mvn package
```

Run the example (after building the server):

```bash
java -cp target/family-kids-client-0.0.1-SNAPSHOT.jar com.example.family.client.ExampleClient
```

The example sends a sample `play` event to `http://localhost:8080/api/track` and prints the server acknowledgement.
