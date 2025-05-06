CREATE TABLE country (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         continent VARCHAR(255) NOT NULL
);

CREATE TABLE host (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      surname VARCHAR(255) NOT NULL,
                      country_id INTEGER REFERENCES country(id) ON DELETE CASCADE
);

CREATE TABLE accommodation (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               category VARCHAR(255) NOT NULL,
                               host_id INTEGER REFERENCES host(id) ON DELETE CASCADE,
                               num_rooms INTEGER NOT NULL,
                               active BOOLEAN NOT NULL
);

CREATE TABLE shop_users (
                            username VARCHAR(255) PRIMARY KEY,
                            password VARCHAR(255) NOT NULL,
                            name VARCHAR(255) NOT NULL,
                            surname VARCHAR(255) NOT NULL,
                            role VARCHAR(255) NOT NULL,
                            is_account_non_expired BOOLEAN DEFAULT TRUE,
                            is_account_non_locked BOOLEAN DEFAULT TRUE,
                            is_credentials_non_expired BOOLEAN DEFAULT TRUE,
                            is_enabled BOOLEAN DEFAULT TRUE
);

CREATE TABLE booking (
                         id SERIAL PRIMARY KEY,
                         created_at TIMESTAMP NOT NULL,
                         user_username VARCHAR(255) REFERENCES shop_users(username)
);

CREATE TABLE booking_accommodations (
                                        booking_id INTEGER REFERENCES booking(id) ON DELETE CASCADE,
                                        accommodations_id INTEGER REFERENCES accommodation(id) ON DELETE CASCADE,
                                        PRIMARY KEY (booking_id, accommodations_id)
);
