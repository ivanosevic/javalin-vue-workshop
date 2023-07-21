CREATE TABLE IF NOT EXISTS source
(
    source_id INT GENERATED ALWAYS AS IDENTITY,
    source_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (source_id)
);

CREATE TABLE IF NOT EXISTS quote
(
    quote_id INT GENERATED ALWAYS AS IDENTITY,
    quote_content VARCHAR(500) NOT NULL,
    source_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (quote_id),
    CONSTRAINT fk_quote_source_id FOREIGN KEY (source_id) REFERENCES source(source_id)
);