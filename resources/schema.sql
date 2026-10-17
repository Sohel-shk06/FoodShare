-- FoodShare Supabase PostgreSQL schema. Run once in Supabase SQL Editor.
-- App passwords are PBKDF2 hashes; do not add plain-text password columns.
CREATE TABLE IF NOT EXISTS public.donors (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(254) UNIQUE NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  address VARCHAR(200) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS public.ngos (
  id BIGSERIAL PRIMARY KEY,
  org_name VARCHAR(120) NOT NULL,
  email VARCHAR(254) UNIQUE NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  address VARCHAR(200) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE TABLE IF NOT EXISTS public.donations (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  category VARCHAR(50) NOT NULL,
  portions INTEGER NOT NULL CHECK (portions > 0),
  donor_name VARCHAR(100) NOT NULL,
  donor_email VARCHAR(254) NOT NULL REFERENCES public.donors(email),
  pickup_address VARCHAR(200) NOT NULL,
  expiry_hours INTEGER NOT NULL CHECK (expiry_hours > 0),
  dietary VARCHAR(100),
  status VARCHAR(20) NOT NULL DEFAULT 'available' CHECK (status IN ('available','claimed')),
  claimed_by VARCHAR(254),
  claimed_by_name VARCHAR(120),
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  claimed_at TIMESTAMPTZ
);
CREATE TABLE IF NOT EXISTS public.activities (
  id BIGSERIAL PRIMARY KEY,
  user_email VARCHAR(254) NOT NULL,
  action_type VARCHAR(50) NOT NULL,
  description VARCHAR(255) NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE INDEX IF NOT EXISTS idx_donations_status_created ON public.donations(status, created_at DESC);
CREATE INDEX IF NOT EXISTS idx_donations_claimed_by ON public.donations(claimed_by);
CREATE INDEX IF NOT EXISTS idx_activities_user_created ON public.activities(user_email, created_at DESC);
