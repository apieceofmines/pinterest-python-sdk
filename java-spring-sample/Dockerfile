FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the built JAR 
COPY java-spring-sample/target/family-kids-analytics-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Health check
HEALTHCHECK --interval=10s --timeout=3s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/api/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
