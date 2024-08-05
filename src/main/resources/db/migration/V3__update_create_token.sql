ALTER TABLE client RENAME TO "user";

-- If the 'client' table needs additional columns or modifications to match 'user' table:
ALTER TABLE "user"
    ADD COLUMN username VARCHAR NOT NULL;

