# FoodShare Java AWT + Supabase PostgreSQL

FoodShare keeps its existing Java AWT screens and connects directly to Supabase PostgreSQL using JDBC. The project uses Maven to download the PostgreSQL JDBC driver. No credentials are stored in source code or `resources/db.properties`.

## Features
- Separate Donor and NGO dashboard behavior. Donors can post donations; only NGOs can claim donations and view their own claimed pickups.
- Supabase PostgreSQL shared storage for donors, NGOs, donations, claims and per-user activity history.
- Atomic claim update (`WHERE status='available'`) prevents two NGOs from claiming the same item.
- PBKDF2-HMAC-SHA256 password hashes with random salts; passwords are not stored in plain text.
- Prepared statements and environment-based database configuration.

## 1. Create the Supabase database
1. Create a Supabase project at https://supabase.com/dashboard.
2. Open **SQL Editor** and run the complete `resources/schema.sql` script once.
3. In Supabase Database settings, find the direct or session-pooler PostgreSQL connection details. Use a PostgreSQL JDBC URL with SSL, for example `jdbc:postgresql://YOUR_DB_HOST:5432/postgres?sslmode=require`. Replace the host/port/database with the values shown for your project. Do not copy the placeholder literally.
4. Optional but recommended: run `resources/setup_permissions.sql` after reviewing it and replacing its password placeholder. This creates a restricted `foodshare_app` database login with only table-level permissions needed by this prototype. If Supabase reports that role creation is restricted for your project, create a database role through the Supabase database settings and grant equivalent permissions. Do not use the Supabase `service_role` API key as a JDBC password. Avoid giving the desktop app an unrestricted postgres/admin account.

The app expects these environment variables:
- `SUPABASE_JDBC_URL` e.g. `jdbc:postgresql://YOUR_DB_HOST:5432/postgres?sslmode=require`
- `SUPABASE_DB_USER` database role username shown/created for your project (if using the optional SQL script, this is `foodshare_app`; pooler usernames may include the project reference)
- `SUPABASE_DB_PASSWORD` password for that database role

## 2. Set environment variables on Windows
Open a **new PowerShell** terminal from the project folder. Set the actual values from your Supabase project, then run the app in that same terminal:

```powershell
$env:SUPABASE_JDBC_URL = "jdbc:postgresql://db.pcgahfpoizkczzmctpbu.supabase.co:5432/postgres?sslmode=require"
$env:SUPABASE_DB_USER = "postgres"
$env:SUPABASE_DB_PASSWORD = ""
compile_and_run.bat
```

Replace every `YOUR_...` value with the exact value from Supabase. These are session-only environment variables; opening a new terminal means setting them again. For persistent configuration use Windows Environment Variables, but do not commit secrets or share screenshots containing them.

## 3. Run
- Install JDK 11+ (Maven is not required).
- Ensure the four tables exist by running `resources/schema.sql` in Supabase SQL Editor.
- Set the three environment variables above.
- Run `compile_and_run.bat` from the same configured terminal.
- Register a donor first, then sign in as that donor to create a donation. Register an NGO separately, sign in as the NGO, browse available food and claim it. Each user sees only their own activity history; NGOs see their own claimed pickups.

## Security warning: direct JDBC in a desktop app
Environment variables keep credentials out of the repository, but they do **not** make a database password secret from someone who controls the desktop machine. A user can inspect process environment, app files, or runtime memory. Anyone who receives an unrestricted database credential could access the database outside the UI. Direct JDBC is acceptable for a controlled class prototype, not a secure public deployment. Use a dedicated least-privilege database role, rotate any exposed password, and never commit credentials. For a real multi-user app, move database access behind a backend API and enforce authorization server-side.

## Notes
- This app uses a new schema with `password_hash`. It is not a drop-in migration for an old SQLite/MySQL database that stores plain-text `password` values. Use a fresh Supabase schema for this build, or plan a deliberate data migration.
- Deployment is not performed by this project archive. You must create/configure your own Supabase project and supply its credentials locally.
