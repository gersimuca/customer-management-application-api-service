-- Enable the pgcrypto extension for UUID generation
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create the sequence for primary keys
CREATE SEQUENCE primary_key_seq;

-- Create the 'client' table
CREATE TABLE client (
                        client_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                        first_name VARCHAR NOT NULL,
                        last_name VARCHAR NOT NULL,
                        email VARCHAR UNIQUE,
                        password VARCHAR NOT NULL,
                        role VARCHAR NOT NULL,
                        created_by UUID NOT NULL,
                        updated_by UUID NOT NULL,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT unique_email UNIQUE (email)
);

-- Create the 'product' table
CREATE TABLE product (
                         product_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                         product_name VARCHAR UNIQUE,
                         manufacturer VARCHAR,
                         quantity VARCHAR,
                         country_of_origin VARCHAR,
                         CONSTRAINT unique_product_name UNIQUE (product_name)
);

-- Create the 'requests' table
CREATE TABLE requests (
                          request_id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                          product_name VARCHAR NOT NULL,
                          quantity INTEGER NOT NULL,
                          status VARCHAR,
                          client_id UUID REFERENCES client(client_id)
);