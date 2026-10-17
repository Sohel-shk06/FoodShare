package com.foodshare.database;

import java.sql.*;

/**
 * Supabase PostgreSQL connection. Credentials are read from environment
 * variables only.
 */
public final class DBConnection {
  private DBConnection() {
  }

  public static Connection getConnection() throws SQLException {
    String url = System.getenv("SUPABASE_JDBC_URL"), user = System.getenv("SUPABASE_DB_USER"),
        password = System.getenv("SUPABASE_DB_PASSWORD");
    if (blank(url) || blank(user) || blank(password))
      throw new SQLException(
          "Missing SUPABASE_JDBC_URL, SUPABASE_DB_USER, or SUPABASE_DB_PASSWORD environment variable.");
    if (!url.startsWith("jdbc:postgresql://"))
      throw new SQLException("SUPABASE_JDBC_URL must start with jdbc:postgresql://");
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      throw new SQLException(
          "PostgreSQL JDBC driver missing. Run with Maven or add the PostgreSQL JDBC JAR to classpath.", e);
    }
    return DriverManager.getConnection(url, user, password);
  }

  public static void initializeDatabase() throws SQLException {
    // Schema is applied manually in Supabase SQL Editor; app user needs no DDL
    // privileges.
    try (Connection c = getConnection();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(
            "SELECT to_regclass('public.donors'), to_regclass('public.ngos'), to_regclass('public.donations'), to_regclass('public.activities')")) {
      if (!r.next() || r.getString(1) == null || r.getString(2) == null || r.getString(3) == null
          || r.getString(4) == null)
        throw new SQLException(
            "FoodShare tables are missing. Run resources/schema.sql in the Supabase SQL Editor first.");
    }
  }

  private static boolean blank(String x) {
    return x == null || x.trim().isEmpty();
  }
}
