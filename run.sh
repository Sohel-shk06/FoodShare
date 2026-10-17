#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
: "${SUPABASE_JDBC_URL:?Set SUPABASE_JDBC_URL first}"
: "${SUPABASE_DB_USER:?Set SUPABASE_DB_USER first}"
: "${SUPABASE_DB_PASSWORD:?Set SUPABASE_DB_PASSWORD first}"
exec mvn -q compile exec:java
