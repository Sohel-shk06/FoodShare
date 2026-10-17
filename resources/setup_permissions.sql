-- Optional least-privilege app role. Run AFTER schema.sql in Supabase SQL Editor.
-- Replace the password placeholder with a strong, unique password before running.
-- Do not reuse your Supabase postgres/admin password.
CREATE ROLE foodshare_app LOGIN PASSWORD 'REPLACE_WITH_A_LONG_RANDOM_PASSWORD';
GRANT CONNECT ON DATABASE postgres TO foodshare_app;
GRANT USAGE ON SCHEMA public TO foodshare_app;
GRANT SELECT, INSERT ON public.donors, public.ngos TO foodshare_app;
GRANT SELECT, INSERT, UPDATE ON public.donations TO foodshare_app;
GRANT SELECT, INSERT ON public.activities TO foodshare_app;
GRANT USAGE, SELECT ON SEQUENCE public.donors_id_seq TO foodshare_app;
GRANT USAGE, SELECT ON SEQUENCE public.ngos_id_seq TO foodshare_app;
GRANT USAGE, SELECT ON SEQUENCE public.donations_id_seq TO foodshare_app;
GRANT USAGE, SELECT ON SEQUENCE public.activities_id_seq TO foodshare_app;
