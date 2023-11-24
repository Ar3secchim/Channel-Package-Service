CREATE TABLE channels (
    id VARCHAR(255) PRIMARY KEY,
    channel_id  VARCHAR(255),
    package_id VARCHAR(255),
    identifier INTEGER,
    name VARCHAR(255),
    category VARCHAR(255),
    FOREIGN KEY (package_id) REFERENCES packages(id)
 )
