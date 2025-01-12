DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_id              BIGSERIAL PRIMARY KEY,
                       username             VARCHAR(8) NOT NULL UNIQUE,
                       given_name           VARCHAR(512) NOT NULL,
                       family_name          VARCHAR(512) NOT NULL,
                       email                VARCHAR(1024) NOT NULL,
                       preferred_language   VARCHAR(10) NOT NULL DEFAULT 'en-US',
                       is_active            BOOLEAN NOT NULL DEFAULT TRUE,
                       last_updated_user_id BIGINT DEFAULT 1,
                       last_updated_at      TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       created_user_id      BIGINT DEFAULT 1,
                       created_at           TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- alter table users
--     add constraint fk_users_last_updated_user_id foreign key (last_updated_user_id) references users (user_id);
-- alter table users
--     add constraint fk_users_created_user_id foreign key (created_user_id) references users (user_id);

ALTER TABLE users
    ADD CONSTRAINT fk_users_last_updated_user_id
        FOREIGN KEY (last_updated_user_id) REFERENCES users (user_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE users
    ADD CONSTRAINT fk_users_created_user_id
        FOREIGN KEY (created_user_id) REFERENCES users (user_id) DEFERRABLE INITIALLY DEFERRED;