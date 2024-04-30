FROM sbtscala/scala-sbt:eclipse-temurin-11.0.17_8_1.8.0_2.13.10

# Update package lists and install build-essential
RUN apt-get update && \
    apt-get install -y build-essential && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

FROM sbtscala/scala-sbt:eclipse-temurin-11.0.17_8_1.8.0_2.13.10

# Update package lists and install build-essential
RUN apt-get update && \
    apt-get install -y build-essential && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app


ENTRYPOINT ["/bin/bash"]
CMD []