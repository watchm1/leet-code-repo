#!/usr/bin/env bash
# Apache Maven Wrapper startup script v3.2.0 (simplified)
set -euo pipefail

WRAPPER_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MVNW_JAR="$WRAPPER_DIR/.mvn/wrapper/maven-wrapper-3.2.0.jar"
MVN_WRAPPER_PROPERTIES="$WRAPPER_DIR/.mvn/wrapper/maven-wrapper.properties"

# Download wrapper jar if missing
if [ ! -f "$MVNW_JAR" ]; then
  PROP_URL=$(grep -E "^wrapperUrl=" "$MVN_WRAPPER_PROPERTIES" | sed -E 's/^wrapperUrl=//')
  echo "Downloading Maven Wrapper jar..." >&2
  curl -fsSL "$PROP_URL" -o "$MVNW_JAR"
fi

# Determine Maven distribution path
DIST_URL=$(grep -E "^distributionUrl=" "$MVN_WRAPPER_PROPERTIES" | sed -E 's/^distributionUrl=//')
MAVEN_DIST_DIR="$WRAPPER_DIR/.mvn/wrapper/dists"
MAVEN_PROJECTBASEDIR="$WRAPPER_DIR"
export MAVEN_PROJECTBASEDIR

# Extract version from URL (apache-maven-3.9.8-bin.tar.gz -> 3.9.8)
DIST_VERSION=$(echo "$DIST_URL" | sed -E 's/.*apache-maven-([0-9.]+)-bin.*/\1/')
DIST_DIR="$MAVEN_DIST_DIR/apache-maven-$DIST_VERSION"

# Download and extract Maven if needed
if [ ! -d "$DIST_DIR" ] || [ ! -x "$DIST_DIR/bin/mvn" ]; then
  echo "Downloading Maven distribution $DIST_VERSION..." >&2
  mkdir -p "$MAVEN_DIST_DIR"
  TMP_TGZ="$(mktemp)"
  curl -fsSL "$DIST_URL" -o "$TMP_TGZ"
  tar -xzf "$TMP_TGZ" -C "$MAVEN_DIST_DIR"
  rm -f "$TMP_TGZ"
fi

MVN_BIN="$DIST_DIR/bin/mvn"

exec "$MVN_BIN" "$@"
