# Use official stable JDK image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for dependency caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (this step gets cached)
RUN chmod +x mvnw

#Download dependencies (cached if no pom.xml changes)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Render will override with its own PORT)
EXPOSE 8080

# Run the jar file dynamically ( finds the .jar in target folder)
CMD ["sh", "-c", "java -jar $(find target -name '*.jar' | head -n 1)"]
