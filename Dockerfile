# Use official lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for dependency caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (this step gets cached)
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy the rest of the source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Render will override with its own PORT)
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/*.jar"]
