#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

cd "$PROJECT_ROOT"

MVN_CMD="./mvnw"
if [ ! -x "$MVN_CMD" ]; then
  if command -v mvn >/dev/null 2>&1; then
    MVN_CMD="mvn"
  else
    echo "Neither ./mvnw nor mvn found. Please install Maven." >&2
    exit 1
  fi
fi

"$MVN_CMD" -q --no-transfer-progress -DskipTests=true compile
java -cp target/classes leetcode.App "$@"
