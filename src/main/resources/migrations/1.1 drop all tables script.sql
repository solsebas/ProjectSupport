-- Jakby ktoś miał problemy z tworzeniem się tabelek po jakimś refaktorze tabel, to może pomóc ich najpierw usunięcie:
DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;